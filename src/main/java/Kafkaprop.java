import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Kafkaprop implements KafkaProperties{
   static Logger logger = LoggerFactory.getLogger(Kafkaprop.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Properties prop = new Kafkaprop().returnprop();

        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(prop);


        for(int i=0;i<10;i++){
            String key = "key_"+Integer.toString(i);
            ProducerRecord<String,String> record = new ProducerRecord<String,String>("kk",key,"Helloworld");
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception e) {
                if(e==null){
                    logger.info("Logger metadata for the record"+"\n"+
                            "Received metadata:"+ metadata.offset());
                }
                else {
                    System.out.println(e);
                }
            }
        });
        }
        producer.flush();


    }


}
