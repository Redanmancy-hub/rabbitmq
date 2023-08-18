package cn.itcast.mq;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        SpringApplication.run(ConsumerApplication.class, args);
        stopwatch.stop();
        log.info("项目启动耗时:{}s",stopwatch.elapsed().getSeconds());
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
