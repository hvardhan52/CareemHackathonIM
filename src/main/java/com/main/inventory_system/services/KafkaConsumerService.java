package com.main.inventory_system.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Callable;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.solr.client.solrj.SolrServerException;

import com.google.gson.Gson;
import com.main.inventory_system.models.CarLocation;

public class KafkaConsumerService implements Runnable {
	KafkaConsumer<String, String> consumer;
	String topicName = "carLocation";

	public KafkaConsumerService() {
		// Kafka consumer configuration settings

		Properties props = new Properties();

		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		consumer = new KafkaConsumer<String, String>(props);
		// Thread th = new Thread(this);
		// th.start();
	}

	public void run() {
		// Kafka Consumer subscribes list of topics here.
		consumer.subscribe(Arrays.asList(topicName));

		// print the topic name
		System.out.println("Subscribed to topic " + topicName);

		try {
			while (true) {
				System.out.println("***********************");
				ConsumerRecords<String, String> records = consumer.poll(100);
				for (ConsumerRecord<String, String> record : records) {

					// print the offset,key and value for the consumer records.
					System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());

					Gson gson = new Gson();
					CarLocation carLocation = gson.fromJson(record.value(), CarLocation.class);
					SolrService.setDataInSolr(carLocation);

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			consumer.close();
			System.out.println("##############Conusmer closed##############");
		}
	}

}
