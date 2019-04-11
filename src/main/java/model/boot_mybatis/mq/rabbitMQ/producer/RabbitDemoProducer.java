package model.boot_mybatis.mq.rabbitMQ.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author smx
 * @date : 2019/4/11
 */
@Component
public class RabbitDemoProducer {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void topicTopicSend() {

        this.rabbitTemplate.convertAndSend("topicExchange", "topic.msg.send", "一条消息，请处理");
    }
}