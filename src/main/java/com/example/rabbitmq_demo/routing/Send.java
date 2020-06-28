package com.example.rabbitmq_demo.routing;

import com.example.rabbitmq_demo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String EXCAHNGE_NAME="test_exchange_direct";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

//        excahnge
        channel.exchangeDeclare(EXCAHNGE_NAME,"direct");
        String msg="hello direct";

        String routingKey="info";
        channel.basicPublish(EXCAHNGE_NAME,routingKey,null,msg.getBytes());

        System.out.println("send "+msg);
        channel.close();
        connection.close();
    }
}
