package com.kavita.adaptavist.kafkawordcountdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;


@SpringBootApplication
@EnableKafkaStreams
public class KafkaWordcountDemoApplication {


	public static void main(String[] args)
	{


		SpringApplication.run(KafkaWordcountDemoApplication.class, args);


		System.out.println("Hello EveryOne! My Name is Kavita ");
		System.out.println("Lets do WordCount by Kafka Streaming *** " );
	}



}

