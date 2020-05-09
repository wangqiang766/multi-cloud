package com.wq.multiuser.service;

import java.io.Serializable;

/**
 * 单例模式
 */
public class LazyInnerClassSingleton implements Serializable {
    private LazyInnerClassSingleton(){
        if (lazyInnerClassSingleton!=null){
            throw new RuntimeException("不允许创建多例");
        }
    };
    private static LazyInnerClassSingleton lazyInnerClassSingleton= new LazyInnerClassSingleton();
    //饱汉模式
    public static LazyInnerClassSingleton getInstance(){
        return lazyInnerClassSingleton;
    }
    //饿汉模式，调用时才创建
    public synchronized static LazyInnerClassSingleton getInstance2(){
        if (lazyInnerClassSingleton == null) {
            return new LazyInnerClassSingleton();
        }
        return lazyInnerClassSingleton;
    }
}
