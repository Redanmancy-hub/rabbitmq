package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    //申明交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("itcast.fanout");
    }
    //申明队列1
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanout.queue1");
    }
    //进行交换机和队列1的绑定
    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1,FanoutExchange fanoutExchange){
        return BindingBuilder
                .bind(fanoutQueue1)
                .to(fanoutExchange);
    }

    //申明队列2
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanout.queue2");
    }
    //进行交换机和队列2的绑定
    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2,FanoutExchange fanoutExchange){
        return BindingBuilder
                .bind(fanoutQueue2)
                .to(fanoutExchange);
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("object.queue");
    }
}
