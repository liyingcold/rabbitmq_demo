package com.example.rabbitmq_demo.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class Consumer {

    @RabbitListener(queues = "${app.rabbitmq.queue.user}")
    public void userConsumer(Map<Object,Object> map, Message message, Channel channel){
        try {
            System.out.println(message);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
            System.out.println(message.getMessageProperties().getReceivedRoutingKey());
        } catch (IOException e) {
            System.out.println("==========失败");
            e.printStackTrace();
        }
    }
}
