package com.example.rabbitmq_demo.mq;

import com.example.rabbitmq_demo.pojo.DataMQ;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.example.rabbitmq_demo.util.TxtUtil.readFile;
import static com.example.rabbitmq_demo.util.TxtUtil.txtMapUtil;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange.user}")
    private String userExchange;

    public void send(Map<Object,Object> map){

        rabbitTemplate.convertAndSend(userExchange,"normal.file",map);
    }
}
