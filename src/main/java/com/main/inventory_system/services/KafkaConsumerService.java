package com.main.inventory_system.services;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Callable;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerService implements Runnable {
	KafkaConsumer<String, String> consumer;
	String topicName = "carLocation";
	public KafkaConsumerService(){
	//Kafka consumer configuration settings
    
    Properties props = new Properties();
    
    props.put("bootstrap.servers", "localhost:9092");
    props.put("group.id", "test");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("session.timeout.ms", "30000");
    props.put("key.deserializer", 
       "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", 
       "org.apache.kafka.common.serialization.StringDeserializer");
    consumer = new KafkaConsumer
       <String, String>(props);
	}
	
	public void run(){
		//Kafka Consumer subscribes list of topics here.
	      consumer.subscribe(Arrays.asList(topicName));
	      
	      //print the topic name
	      System.out.println("Subscribed to topic " + topicName);
	      int i = 0;
	      
	      while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(100);
	         for (ConsumerRecord<String, String> record : records)
	         
	         // print the offset,key and value for the consumer records.
	         System.out.printf("offset = %d, key = %s, value = %s\n", 
	            record.offset(), record.key(), record.value());
	      }
	}

}
