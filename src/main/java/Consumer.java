import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class Consumer implements KafkaConsumerProp {


    public static void main(String[] args) {
        Properties prop = new Consumer().getProp();
        KafkaConsumer<String, String> cons = new KafkaConsumer<>(prop);
        cons.subscribe(Arrays.asList("kk"));

        while(true){

            ConsumerRecords<String,String> records = cons.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record: records){
                System.out.println(record.value());
            }
        }


    }
}
