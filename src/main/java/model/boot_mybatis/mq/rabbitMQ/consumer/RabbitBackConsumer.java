package model.boot_mybatis.mq.rabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author smx
 * @date : 2019/4/11
 */
@Component
@RabbitListener(queues = "topic.b")
public class RabbitBackConsumer {


    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("[topic.b] recieved message:" + msg);
    }
}