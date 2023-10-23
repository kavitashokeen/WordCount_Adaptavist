package com.kavita.adaptavist.kafkawordcountdemo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.TopicBuilder;

import javax.swing.*;
@Configuration
public class AppConfigs {
    public static final String inputTopic = "test-topic";
    public static final String outputTopic = "output-topic";

    @Bean
    NewTopic testTopic()
    {
        return TopicBuilder.name("test-topic").partitions(3).replicas(3).build();
    }


    @Bean
    NewTopic outputTopic()
    {
        return TopicBuilder.name("output-topic").partitions(3).replicas(3).build();
    }





}
