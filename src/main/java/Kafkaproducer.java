
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.clients.producer.Producer;
import java.util.Properties;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;

public class Kafkaproducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // Kafka Bootstrap Server
        properties.setProperty("bootstrap.servers", "192.168.99.100:9092");
        // Producer acks
        properties.setProperty("acks", "1");
        // retries
        properties.setProperty("retries", "3");
        // Key Serializer
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        // Value Serializer
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        properties.setProperty("linger.ms", "1");
        Producer<String, String> producer = new KafkaProducer<String,String>(properties);

//            producer.send(new ProducerRecord<String, String>("first_topic", "b","a"));
        producer.send(new ProducerRecord<String, String>("first_topic", "File","Description"));

        producer.close();
    }

}
