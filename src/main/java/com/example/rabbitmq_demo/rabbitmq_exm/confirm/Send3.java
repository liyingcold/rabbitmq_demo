package com.example.rabbitmq_demo.rabbitmq_exm.confirm;

import com.example.rabbitmq_demo.rabbitmq_exm.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

public class Send3 {
    private static final String QUEUE_NAME="test_queue_confirm3";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//生产者调用confirmSelect，将channel设置未confirm模式。同一个队列不可多次设置
        channel.confirmSelect();

//        未确认的消息标识
        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
//       添加监听
        channel.addConfirmListener(new ConfirmListener() {
//            没问题的handleAck
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                if (multiple){
                    System.out.println("------------handleACK--------multiple");
                    confirmSet.headSet(deliveryTag+1).clear();
                }else {
                    System.out.println("------------handleACK--------multiple--false");
                    confirmSet.headSet(deliveryTag);
                }
            }
//            handleNack
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                if(multiple){
                    System.out.println("------------handleNack----------multiple");
                    confirmSet.headSet(deliveryTag+1).clear();
                }else {
                    System.out.println("------------handleNack----------multiple false");
                    confirmSet.remove(deliveryTag);
                }
            }
        });
        String msg="hello confirm confirmSet";
        while (true){
            Long seqNo=channel.getNextPublishSeqNo();
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            confirmSet.add(seqNo);
        }

    }
}
