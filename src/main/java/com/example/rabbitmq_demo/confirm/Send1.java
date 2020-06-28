package com.example.rabbitmq_demo.confirm;

import com.example.rabbitmq_demo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 普通模式
 */
public class Send1 {
    private static final String QUEUE_NAME="test_queue_confirm1";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//生产者调用confirmSelect，将channel设置未confirm模式。同一个队列不可多次设置
        channel.confirmSelect();

        String msg="hello confirm";

        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        if(!channel.waitForConfirms()){
            System.out.println("masg send failed");
        } else {
            System.out.println("msg send success");
        }
        channel.close();
        connection.close();
    }
}
