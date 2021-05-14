package com.lwj.test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @author: linwj
 * @date: 2021-04-10 18:44
 * @description:
 **/
public class PersonProxy implements InvocationHandler {

    private Object object;

    public Object getPersonProxy(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("111");
        return method.invoke(object,args);
    }

    public static void main(String[] args) {
        PersonProxy personProxy=new PersonProxy();
        Person person = (Person) personProxy.getPersonProxy(new PersonImpl());
        person.buy();

    }
}
