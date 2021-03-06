/**
 * 
 */
package rk.kafka.custom.receiver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * @author Administrator
 *
 */
public class AuthRecevier {
	
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		//Desrialization from Byte to String
		props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("group.id", "test-group");
		props.setProperty("security.protocol", "SASL_PLAINTEXT");
		props.setProperty("sasl.mechanism", "PLAIN");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		List<String> topicList = new ArrayList<String>();
		topicList.add("first-topic");
		consumer.subscribe(topicList);
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ZERO);
			for(ConsumerRecord<String, String> record: records) {
				System.out.println("Message Recived with Key:"+record.key()+ " and value "+record.value());
			}
		}
	}

}
