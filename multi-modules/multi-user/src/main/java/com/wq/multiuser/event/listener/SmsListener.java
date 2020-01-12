package com.wq.multiuser.event.listener;

import com.wq.multiuser.event.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SmsListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        System.out.println(Thread.currentThread()+"....短信监听到..."+orderEvent.getMessage()+"...."+orderEvent.getSource());
    }
}
