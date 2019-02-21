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
		props.setProperty("partitioner.class", "rk.kafka.training.custompartitioner.MessagePartitioner");
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		String topicName = "msg-topic";
		for(int i=1; i<=3; i++) {
				ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "message-1", "This is test message"+i);
				producer.send(record);
			}
		
		for(int i=1; i<=6; i++) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "message-2", "This is test message"+i);
			producer.send(record);
		}
		
		for(int i=1; i<=8; i++) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "message-3", "This is test message"+i);
			producer.send(record);
		}
		for(int i=1; i<=10; i++) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "message-x", "This is test message"+i);
			producer.send(record);
		}
		producer.close();
		System.out.println("Message Sent");
	}
}
