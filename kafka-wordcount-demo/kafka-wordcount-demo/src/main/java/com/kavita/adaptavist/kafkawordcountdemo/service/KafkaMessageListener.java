package com.kavita.adaptavist.kafkawordcountdemo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaMessageListener {

    @KafkaListener(topics = "output-topic", groupId = "adaptavist_2")
    public void consumer(ConsumerRecord<String, Long> record)
    {
        System.out.println("received = " + record.value() + " with key "+ record.key());
    }


}


