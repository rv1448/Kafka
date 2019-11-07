import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public interface KafkaConsumerProp {

    public static final String TOPIC="kk";
    public static final String BOOT_STRAP_SERVER = "localhost:9092";
    public static final String STRING_DESERIALIZER = StringDeserializer.class.getName();
    public static final String GROUP_ID = "consumer_group_2";

    default Properties getProp(){
        Properties prop = new Properties();
        prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOT_STRAP_SERVER);
        prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,STRING_DESERIALIZER);
        prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,STRING_DESERIALIZER);
        prop.setProperty(ConsumerConfig.GROUP_ID_CONFIG,GROUP_ID);
        prop.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        return prop;
    }

}
