package com.wq.multiuser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

//@SpringBootTest(classes = MultiUserApplication.class)
//@RunWith(SpringRunner.class)
public class MultiUserApplicationTests {
    @Test
    public void test(){
        Runnable runnable= new TestThread1();
        Thread thread1= new Thread(runnable);
        Thread thread2= new TestThread2();
        thread1.start();
        thread2.start();
    }

}
