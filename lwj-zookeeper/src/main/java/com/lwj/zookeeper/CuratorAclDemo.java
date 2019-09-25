package com.lwj.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.security.NoSuchAlgorithmException;
import java.security.acl.Acl;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Linwj
 * @date 2019/9/23 21:15
 */
public class CuratorAclDemo {

    private static final String ZOOKEEPER_URL="192.168.112.129:7181";
    private static final int SESSION_TIMEOUT=5000;

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

        List<ACL> acls=new ArrayList<>();
        Id id1=new Id("digest", DigestAuthenticationProvider.generateDigest("user1:pwd1"));
        Id id2=new Id("digest", DigestAuthenticationProvider.generateDigest("user2:pwd2"));
        //用户user1赋予所有权限all
        acls.add(new ACL(ZooDefs.Perms.ALL,id1));
        //用户user2赋予读取权限
        acls.add(new ACL(ZooDefs.Perms.READ,id2));

        curatorFramework.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .withACL(acls)
                .forPath("/lwj/aclTestNode");
    }
}
