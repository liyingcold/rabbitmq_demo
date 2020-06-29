package com.example.rabbitmq_demo.rabbitmq_exm.simple;

import com.example.rabbitmq_demo.rabbitmq_exm.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者获取消息
 */
public class Receive {
private static final String QUEUE_NAME="test_simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
//获取连接
        Connection connection= ConnectionUtils.getConnection();
//创建通道
        Channel channel=connection.createChannel();
//声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//定义一个consumer消费者
//        一旦有消息进入队列，就会触发该方法handleDelivery【事件模型】
        DefaultConsumer consumer = new DefaultConsumer(channel) {
//            获取到达的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msgString = new String(body, "utf-8");
                System.out.println("--receive msg:" + msgString);
            }
        };
//监听队列 类似于 android的listener
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
