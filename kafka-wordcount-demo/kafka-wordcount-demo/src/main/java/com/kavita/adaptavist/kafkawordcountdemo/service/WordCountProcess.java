package com.kavita.adaptavist.kafkawordcountdemo.service;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.processor.TopicNameExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class WordCountProcess {


        @Autowired
        public void process(final StreamsBuilder builder)
        {
            final Serde<String> stringSerde = Serdes.String();
            final Serde<Long>  longSerde = Serdes.Long();

            final KTable<String,Long> kTable =  builder.stream("test-topic", Consumed.with(stringSerde,stringSerde))
                    .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
                    .groupBy(((key,value)-> value), Grouped.with(stringSerde,stringSerde))
                    .count();

            final KStream<String,Long> counts = kTable.toStream();

            counts.print(Printed.toSysOut());
            counts.to("output-topic", Produced.with(stringSerde,longSerde));

        }
}
