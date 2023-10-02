package com.kareem.kafka.producer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.admin.AdminClientConfig;

public class KProducer {
    private static final Logger logger = LogManager.getLogger(KProducer.class);
    
    public KProducer(){

    }
    public void sendMessage(String message){

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        // props.put("linger.ms", 1);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

         Producer<String, String> producer = new KafkaProducer<>(props);
        try{
            for (int i = 0; i < 100; i++)
                producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));

        }finally{
            producer.close();
        }

        logger.info("Sending message: " + message);
    }
    
}
