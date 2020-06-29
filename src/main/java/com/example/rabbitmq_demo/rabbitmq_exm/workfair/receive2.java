package com.example.rabbitmq_demo.rabbitmq_exm.workfair;

import com.example.rabbitmq_demo.rabbitmq_exm.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class receive2 {
    private static final  String  QUEUE_NAME="test_work_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
//        获取链接
        Connection connection = ConnectionUtils.getConnection();;
//        获取通道
        Channel channel = connection.createChannel();
//        声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.basicQos(1);//保证一次只分发一个

        //        消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                接收消息
                String message=new String(body,"utf-8");

                System.out.println("[2] receive:"+message);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("[2] done");
//                    手动回执
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
//        监听队列，进行消费
        boolean autoAck=false;
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }

}
