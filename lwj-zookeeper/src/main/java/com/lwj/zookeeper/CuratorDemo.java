package com.lwj.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Linwj
 * @date 2019/9/20 13:35
 */
public class CuratorDemo {

    private static final String ZOOKEEPER_URL="192.168.112.129:7181";
    private static final int SESSION_TIMEOUT=5000;

    private static final String TEST_NODE="/lwj";

    public static void main(String[] args) throws Exception {

        CuratorFramework curatorFramework= CuratorFrameworkFactory.builder()
                //zookeeper服务端地址
                .connectString(ZOOKEEPER_URL)
                //会话超时时间
                .sessionTimeoutMs(SESSION_TIMEOUT)
                //重试策略  超时后每1秒执行一次  最多执行1次
                .retryPolicy(new ExponentialBackoffRetry(1000,5))
                .build();
        //开启连接
        curatorFramework.start();

        //nodeCache监听
        //监听节点的创建和修改，不监听删除
        //dataIsCompressed参数代表是否压缩
        NodeCache nodeCache=new NodeCache(curatorFramework,"/lwj",false);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                //可以获取到包括路径，数据，状态等
                System.out.println("nodeCache监听到当前操作路径：" + nodeCache.getPath());
            }
        });

        //cacheData参数为是否返回监听子节点数据
        PathChildrenCache pathChildrenCache=new PathChildrenCache(curatorFramework,"/lwj",true);
        //NORMAL不监听子节点的更新状态
        //BUILD_INITIAL_CACHE会创建指定的节点
        //POST_INITIALIZED_EVENT不会创建指定的节点
        pathChildrenCache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("pathChildrenCache监听类型：" + pathChildrenCacheEvent.getType() + "---监听路径：" + pathChildrenCacheEvent.getData().getPath()
                        + "---监听数据：" + new String(pathChildrenCacheEvent.getData().getData()));
            }
        });

        TreeCache treeCache=new TreeCache(curatorFramework,"/lwj");
        treeCache.start();
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println("treeCache监听路径：" + treeCacheEvent.getData().getPath());
            }
        });

        createData(curatorFramework);

        Thread.sleep(1000);

        checkData(curatorFramework);
        updateData(curatorFramework);
        getData(curatorFramework);

        getChildren(curatorFramework);
        deleteData(curatorFramework);

        //关闭连接
        curatorFramework.close();
    }

    private static void deleteData(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().forPath("/lwj");
    }

    private static void getChildren(CuratorFramework curatorFramework) throws Exception {
        //打印子菜单数据
        List<String> childrens = curatorFramework.getChildren().forPath("/");
        childrens.parallelStream().forEach(System.out::println);
    }

    private static void updateData(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.setData().forPath(TEST_NODE,"更新后的数据".getBytes());
        System.out.println("更新成功");
    }

    private static void checkData(CuratorFramework curatorFramework) throws Exception {
        Stat stat = curatorFramework.checkExists().forPath(TEST_NODE);
        System.out.println("当前节点校验状态："+stat);
    }

    private static void getData(CuratorFramework curatorFramework) throws Exception {
        //获取节点数据
        System.out.println(new String(curatorFramework.getData().forPath(TEST_NODE)));
    }

    private static void createData(CuratorFramework curatorFramework) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        curatorFramework.create()
                //创建节点的同时判断父节点是否存在
                .creatingParentsIfNeeded()
                //创建持久节点
                .withMode(CreateMode.PERSISTENT)
                //回调函数
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                        System.out.println("code："+curatorEvent.getResultCode());
                        System.out.println("path："+curatorEvent.getPath());
                        System.out.println("type："+curatorEvent.getType());
                    }
                },executorService)
                .forPath(TEST_NODE,"第一次插入的数据".getBytes());
        //查看回调信息添加等待时间
        Thread.sleep(1000);
    }
}
