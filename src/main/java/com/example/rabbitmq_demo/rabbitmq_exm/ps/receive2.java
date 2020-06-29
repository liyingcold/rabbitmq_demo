package com.example.rabbitmq_demo.rabbitmq_exm.ps;

import com.example.rabbitmq_demo.rabbitmq_exm.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class receive2 {

    private static final String EXCHANGE_NAME="test_exchange_fanout";
    private static final String QUEUE_NAME="test_queue_sms";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

//       声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//绑定队列到交换机/转发器
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

        channel.basicQos(1);//保证一次只分发一个

        //        消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                接收消息
                String message=new String(body,"utf-8");

                System.out.println("[2] receive:"+message);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("[2] fanout");

                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
//        监听队列，进行消费
        boolean autoAck=false;//自动应答false
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);


    }
}
