package com.example.rabbitmq_demo.work;

import com.example.rabbitmq_demo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    /**
     *                      |--C1
     * p-------Queue------  |--C2
     * @param args
     * @throws IOException
     * @throws TimeoutException
     */
    private static final  String  QUEUE_NAME="test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
//        连接获取
        Connection connection = ConnectionUtils.getConnection();
//        获取channel
        Channel channel = connection.createChannel();
//      声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//
        for (int i = 0; i <50 ; i++) {
            String msg="."+i;
            System.out.println("[WQ]"+msg);
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            Thread.sleep(i*20);
        }

        channel.close();
        connection.close();
    }
}
