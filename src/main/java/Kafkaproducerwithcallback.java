import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Kafkaproducerwithcallback {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Logger logger = LoggerFactory.getLogger(Kafkaproducerwithcallback.class);


        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.99.100:9092");
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "3");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        properties.setProperty("linger.ms", "1");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);


        for (int i = 0; i < 10; i++) {

            String topic = "first_topic";
            String value = "Hello World "+Integer.toString(i);
            String key = "id_"+Integer.toString(i);


            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key,value);
            logger.info("Key is "+key);

            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    // Executes every time record is successfully send
                    if (e == null) {
                        logger.info("received new Metadata \n" +
                                "Topic: " + recordMetadata.topic() + "\n" +
                                "Partition: " + recordMetadata.partition() + "\n" +
                                "Offset: " + recordMetadata.offset() + "\n" +
                                "Timestamp: " + recordMetadata.timestamp() + "\n"


                        );
                    } else {
                        logger.error("Error while produced", e);
                    }
                }
            }).get();
        }
        producer.flush();
        producer.close();


//        ProducerRecord<String,String> record = new ProducerRecord<String, String>(topic:);


//        Producer<String, String> producer = new KafkaProducer<String,String>(properties);

//
//       for(int i=0; i < 20; i++){
//            producer.send(new ProducerRecord<String, String>("first_topic", Integer.toString(i),Integer.toString(i)));
//        }
//        producer.close();
    }

}
