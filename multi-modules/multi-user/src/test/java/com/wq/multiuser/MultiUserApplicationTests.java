package com.wq.multiuser;

import com.wq.multiuser.event.OrderEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest(classes = MultiUserApplication.class)
@RunWith(SpringRunner.class)
public class MultiUserApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void test(){
        OrderEvent orderEvent =new OrderEvent(this,"用户下单成功");
        applicationContext.publishEvent(orderEvent);
        System.out.println(".........over.........");
    }

}
