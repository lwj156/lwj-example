package com.lwj.mvc;

import com.lwj.mvc.annotation.LwjController;
import com.lwj.mvc.annotation.LwjRequstParam;
import com.lwj.mvc.annotation.LwjService;
import org.springframework.util.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @author Linwj
 * @date 2019/7/11 18:37
 */
public class LwjDispatcherServlet extends HttpServlet {

    private Properties properties=new Properties();
    private List<String> classNames=new ArrayList<>();
    private Map<String, Method> handlerMappings=new HashMap<>();
    private Map<String,Object> ioc=new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //扫描配置文件
        doLoadConfig(config);
        //类扫描
        doScanner(this.properties.getProperty("scanPackage"));
        //实例化类  放入ioc容器
        doInstance();
        //DI 依赖注入
        doAutowired();
        //url与method的对应关系
        initHandlerMappings();
    }

    private void initHandlerMappings() {
    }

    private void doAutowired() {
    }

    private void doInstance() {
        try {

            for (String className : classNames) {
                Object object=Class.forName(className).newInstance();
                Class<?>clazz=object.getClass();
                if (clazz.isAnnotationPresent(LwjController.class)){
                    ioc.put(lowCase(clazz.getName()),object);
                }
                if (clazz.isAnnotationPresent(LwjService.class)){
                   LwjService service= clazz.getAnnotation(LwjService.class);
                   if (StringUtils.isEmpty(service.value())){
                   }
                    for (Class<?> i : clazz.getInterfaces()) {
                        String name=i.getName();
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String lowCase(String name) {
        char[] chars=name.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }

    private void doScanner(String packageName) {
        if (StringUtils.isEmpty(packageName)){return;}
        URL resource = this.getClass().getClassLoader().getResource(packageName.replace(".", "/"));
        File file=new File(resource.getFile());
        //packageName为包，一般不会配置到类名上
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()){
                doScanner(packageName+"."+listFile.getName());
            }else {
                if (!listFile.getName().endsWith(".class")){continue;}
                this.classNames.add(packageName+"."+listFile.getName().replace(".class",""));
            }
        }
    }

    private void doLoadConfig(ServletConfig config) {
        //读取配置文件为输入流
        InputStream is=this.getClass().getClassLoader().
                getResourceAsStream(config.getInitParameter("contextConfigLocation"));
        try {
            this.properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
