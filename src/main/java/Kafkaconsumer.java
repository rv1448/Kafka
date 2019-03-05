import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kafkaconsumer {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Kafkaconsumer.class.getName());
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers","192.168.99.100:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer",StringDeserializer.class.getName()) ;
        properties.setProperty("group.id","test");
        properties.setProperty("enable.auto.commit","true");
        properties.setProperty("auto.commit.interval.ms","1000");
        properties.setProperty("auto.offset.reset","earliest");


        KafkaConsumer<String, String> consumer = new KafkaConsumer(properties);
        consumer.subscribe(Arrays.asList("first_topic"));

        while(true){
            ConsumerRecords<String, String> consumerrecords = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String, String> consumerrecord : consumerrecords){
                logger.info("key "+ consumerrecord.key());
                System.out.println("Partition: "+ consumerrecord.partition()+
                        ", Key: "+consumerrecord.key()+
                        ", Value: "+consumerrecord.value()+
                        ", offset: "+consumerrecord.offset()+
                        ", Timestamp: "+consumerrecord.timestamp());
            }
            consumer.commitSync();
        }
    }
}
