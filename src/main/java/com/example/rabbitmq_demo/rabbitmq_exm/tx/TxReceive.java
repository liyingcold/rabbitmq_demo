package com.example.rabbitmq_demo.rabbitmq_exm.tx;

import com.example.rabbitmq_demo.rabbitmq_exm.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TxReceive {

    private static final String QUEUE_NAME="test_queue_tx";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("receive tx msg :"+new String(body,"utf-8"));
            }
        });
    }
}
