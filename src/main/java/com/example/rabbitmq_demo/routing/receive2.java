package com.example.rabbitmq_demo.routing;

import com.example.rabbitmq_demo.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class receive2 {

    private static final String EXCHANGE_NAME="test_exchange_direct";
    private static final String QUEUE_NAME="test_queue_direct_2";
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);


//绑定队列
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"error");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"info");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"warning");

        channel.basicQos(1);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("[2] receive msg:" + msg);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("[2] done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        boolean autoAck=false;
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }
}
