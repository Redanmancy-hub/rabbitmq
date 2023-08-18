package cn.itcast.mq;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

@Slf4j
@SpringBootApplication
public class PublisherApplication {
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        SpringApplication.run(PublisherApplication.class);
        stopwatch.stop();
        log.info("项目启动耗时:{}s",stopwatch.elapsed().getSeconds());
    }
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
