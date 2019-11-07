import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public interface KafkaProperties {
    public static final String TOPIC="first_topic";
    public static final String BOOT_STRAP_SERVER = "localhost:9092";
    public static final String STRING_SERIAZER = StringSerializer.class.getName();

    default Properties  returnprop(){
        Properties prop = new Properties();

        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOT_STRAP_SERVER);
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, STRING_SERIAZER);
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,STRING_SERIAZER);

        return prop;
    }


}
