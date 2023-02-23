package io.rediron;

import io.rediron.support.ResourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private List<ResourceBuilder> builders;

    @EventListener
    public void handle(ApplicationStartedEvent event) {
        builders.forEach(ResourceBuilder::build);
    }

}
