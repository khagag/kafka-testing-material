package com.kareem.kafka.producer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KafkaProducer {
    private static final Logger logger = LogManager.getLogger(KafkaProducer.class);
    
    public KafkaProducer(){

    }
    public void sendMessage(String message){
        logger.info("Sending message: " + message);
    }
    
}
