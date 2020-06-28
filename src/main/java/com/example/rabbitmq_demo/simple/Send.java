package com.example.rabbitmq_demo.simple;

import com.example.rabbitmq_demo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static  final String QUEUE_NAME="test_simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
//        获取一个连接
        Connection connection=ConnectionUtils.getConnection();
//        创建一个通道
        Channel channel=connection.createChannel();
//         创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String msg="hello simple !";
//第一个参数为空（匿名转发，交换机名字为“”）
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        System.out.println("------send msg");
        channel.close();
        connection.close();
    }
}
