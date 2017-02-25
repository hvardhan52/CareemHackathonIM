package com.main.inventory_system.services;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.main.inventory_system.models.CarLocation;

public class KafkaProducerService {
	
	 Producer<String, String> producer;
	 String topicName = "carLocation";
	public KafkaProducerService(){
		//Assign topicName to string variable
	      
	      
	      // create instance for properties to access producer configs   
	      Properties props = new Properties();
	      
	      //Assign localhost id
	      props.put("bootstrap.servers", "localhost:9092");
	      
	      //Set acknowledgements for producer requests.      
	      props.put("acks", "all");
	      
	      //If the request fails, the producer can automatically retry,
	      props.put("retries", 0);
	      
	      //Specify buffer size in config
	      props.put("batch.size", 16384);
	      
	      //Reduce the no of requests less than 0   
	      props.put("linger.ms", 1);
	      
	      //The buffer.memory controls the total amount of memory available to the producer for buffering.   
	      props.put("buffer.memory", 33554432);
	      
	      props.put("key.serializer", 
	         "org.apache.kafka.common.serialization.StringSerializer");
	         
	      props.put("value.serializer", 
	         "org.apache.kafka.common.serialization.StringSerializer");
	      
	     this.producer = new KafkaProducer
	    	         <String, String>(props);
	}
	
	public void postCabLocationToKafka(CarLocation carLocation){
		producer.send(new ProducerRecord<String, String>(topicName,carLocation.toString()));
	}
}
