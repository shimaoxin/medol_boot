package model.boot_mybatis.mq.rabbitMQ.consumer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author smx
 * @date : 2019/4/11
 */
@Component
@RabbitListener(queues = "topic.a")
public class RabbitDemoConsumer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("[topic.a] recieved message:" + msg);
        //回发
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.back.to", "处理完成");
    }

}