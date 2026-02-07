package org.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

// Start Kafka server before running this app
// C:\kafka\bin\windows\kafka-server-start.bat C:/kafka/config/server.properties

@Service
public class KafkaTestApp implements CommandLineRunner {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    @Autowired
    private KafkaConnnection kafkaConnnection;

    // wire to a properties with this name
    @Value("${app.kafka.connect.topic.name}")
    private String topic;

    private KafkaConsumer<String, String> kafkaConsumer;
    private KafkaProducer<String, String> kafkaProducer;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running KafkaTestApp");
        Map<String, Object> connMap = new HashMap<String, Object>(kafkaConnnection.properties());
        System.out.println(kafkaConnnection.properties());

        // Register a consumer to the server
        kafkaConsumer = new KafkaConsumer<>(connMap);
        System.out.println("KafkaConsumer subscribes to a topic: " + topic);
        kafkaConsumer.subscribe(Arrays.asList(topic));

        // Register a producer
        System.out.println("KafkaProducer - registering...");
        kafkaProducer = new KafkaProducer<>(connMap);
    }

    // This task running indefinitely to consume messages from the topic
    // control how often it poll by changing the milliseconds in fixedDelay field
    @Scheduled(initialDelay = 10, fixedDelay = 1)
    public void simulateKafkaConsumerProcess() throws Exception {
       // System.out.println("Consumer Task is running");
        if(kafkaConsumer == null) {
            System.out.println("kafkaConsumer is not initialized");
            return;
        }

        ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(2));
        for (ConsumerRecord<String, String> record : records)
            System.out.println(dateFormat.format(Calendar.getInstance().getTime())
                    + ": Receive record: " + record.value());

    }

    // Simulate kafka producer sending messages periodically
    // initialDelay - wait for kafkaProducer to be initialized first
    // fixedDelay - how often to send a message
    @Scheduled (initialDelay = 1000, fixedDelay = 1000)
    public void simulateKafkaProducerProcess() throws Exception {
        if(kafkaProducer == null) {
            System.err.println("kafkaProducer not initialized");
            return;
        }
        try {
            Long id = System.currentTimeMillis();
            String data = "Test message";
            StringRawData srd = new StringRawData(id, data);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, id +"", srd.toString());
            kafkaProducer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception ex) {
                    if(ex != null) {
                        System.err.println("Error: " + ex);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
