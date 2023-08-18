package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAMQPTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

/*    @Test
    public void testSendMassage2SimpleQueue(){
        String queueName = "simple.queue";
        String massage = "hello,spring,rabbitmq";
        rabbitTemplate.convertAndSend(queueName,massage);
    }*/

/*    @Test
    public void testSendMassageWorkQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String massage = "hello,rabbitmq__";
        for (int i = 1; i <= 50 ; i++) {
            rabbitTemplate.convertAndSend(queueName,massage+i);
            Thread.sleep(20);
        }
    }*/

/*    @Test
    public void testSendFanoutExchange(){
        //交换机名称
        String exchangeName = "itcast.fanout";
        //消息
        String massage = "hello,every one!";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,"",massage);
    }*/

    @Test
    public void testSendDirectExchange(){
        //交换机名称
        String exchangeName = "itcast.direct";
        //消息
        String massage = "hello,yellow";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,"yellow",massage);
    }

    @Test
    public void testSendTopicExchange(){
        //交换机名称
        String exchangeName = "itcast.topic";
        //消息
        String massage = "中国近十年发生的大事！";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,"china.news",massage);
    }

    @Test
    public void testSendObjectQueue(){
        Map<String,Object> massage = new HashMap<>();
        massage.put("name","张三");
        massage.put("age",21);
        //发送消息
        rabbitTemplate.convertAndSend("object.queue",massage);
    }
}
