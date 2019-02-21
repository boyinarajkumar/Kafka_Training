/**
 * 
 */
package rk.kafka.custom.sender;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author Administrator
 *
 */
public class AuthSender {

	public static void main(String[] args) {
		
		Properties props=new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("security.protocol", "SASL_PLAINTEXT");
		props.setProperty("sasl.mechanism", "PLAIN");
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		String topicName = "first-topic";
		for(int i=1; i<=50; i++) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "message-"+i, "Kafka messages");
			producer.send(record);
		}
		
		
		producer.close();
		System.out.println("Message Sent");
	}
}
