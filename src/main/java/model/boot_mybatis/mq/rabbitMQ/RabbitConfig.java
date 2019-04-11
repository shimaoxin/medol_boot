package model.boot_mybatis.mq.rabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author smx
 * @date : 2019/4/11
 */
@Configuration
public class RabbitConfig {


    @Bean
    public Queue topiocQueueA() {
        return new Queue("topic.a");
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue("topic.b");
    }


    /**
     * 定义个topic交换器
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        // 定义一个名为fanoutExchange的fanout交换器
        return new TopicExchange("topicExchange");
    }

    /**
     * 将定义的topicA队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithA() {
        return BindingBuilder.bind(topiocQueueA()).to(topicExchange()).with("topic.msg.*");
    }

    /**
     * 将定义的topicB队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithB() {
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with("topic.back.*");
    }

}