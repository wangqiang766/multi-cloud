package com.wq.multiuser;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
class MultiUserApplicationTests {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try{
            //TODO
        }catch (Exception e){
            //TODO
        }finally {
            reentrantLock.unlock();
        }
    }
}
