/**
 * 
 */
package rk.kafka.training.sender;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author Administrator
 *
 */
public class MessageSender {

	public static void main(String[] args) {
		
		Properties props =  new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		String topicName = "first-topic";
		for(int i=1; i<=50; i++) {
			if(i > 10 && i < 21) {
				ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "message-1", "This is from Partion1");
				producer.send(record);
			}
			else if(i > 21 && i < 30) {
				ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "message-2", "This is from Partion2");
				producer.send(record);
			}
			else if(i > 31 && i < 50) {
				ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "message-3", "This is from Partion3");
				producer.send(record);
			}
			}
		
		producer.close();
		System.out.println("Message Sent");
	}
}
