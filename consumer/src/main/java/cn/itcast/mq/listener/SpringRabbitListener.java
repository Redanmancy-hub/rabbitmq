package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class SpringRabbitListener {

    //设置监听的队列名称
/*    @RabbitListener(queues = "simple.queue")
    public void listenerSimpleQueue(String msg){
        System.out.println("消费者接送到simple.queue的消息为：" + msg);
    }*/

    @RabbitListener(queues = "simple.queue")
    public void listenerWorkQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1,接收到simple.queue的消息为：[" + msg+"]"+ LocalDateTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenerWorkQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2...,接收到simple.queue的消息为：" + msg+"]"+ LocalDateTime.now());
        Thread.sleep(200);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenerFanoutQueue1(String msg){
        System.out.println("消费者接送到fanout.queue1的消息为：" + msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenerFanoutQueue2(String msg){
        System.out.println("消费者接送到fanout.queue2的消息为：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name="direct.queue1"),
            exchange = @Exchange(name = "itcast.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void listenerDirectQueue1(String msg){
        System.out.println("消费者1接送到direct.queue1的消息为：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name="direct.queue2"),
            exchange = @Exchange(name = "itcast.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void listenerDirectQueue2(String msg){
        System.out.println("消费者2接送到direct.queue2的消息为：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "itcast.topic",type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    public void listenerTopicQueue1(String msg){
        System.out.println("消费者1接送到topic.queue1的消息为：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "itcast.topic",type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    public void listenerTopicQueue2(String msg){
        System.out.println("消费者2接送到topic.queue2的消息为：" + msg);
    }


    @RabbitListener(queues = "object.queue")
    public void listenerObjectQueue(Map<String,Object> msg){
        System.out.println("消费者接收到object.queue的消息为：" + msg);
    }
}
