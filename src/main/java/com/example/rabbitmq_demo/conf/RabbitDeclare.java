package com.example.rabbitmq_demo.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * 队列与交换机定义与绑定
 */

@Configuration
@PropertySource("classpath:application.yml")
public class RabbitDeclare {
    /**
     * 用户队列
     * @param userQueueName 用户队列名
     *
     * @return
     */

    @Bean
    public Queue userQueue(@Value("${app.rabbitmq.queue.user}")String userQueueName){

        return QueueBuilder.durable(userQueueName)
//                声明该队列的死信消息发送到的 交换机（队列添加这个参数后会自动与该交换机绑定，并设置路由键，不需要手动设置）
//                .withArgument("x-dead-letter-exchange",commonDeadLetterExchange)
//                声明该队列死信消息在交换机的 路由键
//                .withArgument("x-dead-letter-routing-key","user-dead-letter-routing-key")
                .build();
    }

    /**
     * 用户交换机
     * @param userExchangeName 用户交换机名
     * @return
     */
    @Bean
    public Exchange userExchange(@Value("${app.rabbitmq.exchange.user}")String userExchangeName){
        return ExchangeBuilder.topicExchange(userExchangeName)
                .durable(true)
                .build();
    }

    /**
     * 用户队列与交换机绑定
     * @param userQueue 用户队列名
     * @param userExchange  用户交换机
     * @return
     */
    @Bean
    public Binding userBinding(Queue userQueue,Exchange userExchange){
        return BindingBuilder.bind(userQueue)
                .to(userExchange)
//                路由键规则
                .with("normal.*")
                .noargs();
    }
}
