package com.wq.multiuser;

import org.junit.Test;

public class DemoTest {
    @Test
    public void  test(){
        Runnable runnable= new TestThread1();
        Thread thread1= new Thread(runnable);
        Thread thread2= new TestThread2();
        thread1.start();
        thread2.start();
        System.out.println(1111);
    }
}
