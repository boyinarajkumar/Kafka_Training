/**
 * 
 */
package rk.kafka.training.sender;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @author Administrator
 *
 */
public class MessageSender {

	public static void main(String[] args) {
		
		Properties props=new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String, String> producer=new KafkaProducer<String, String>(props);
		String topicName="test-topic";
		/*for(int i=1;i<=50;i++){
		ProducerRecord<String, String> record=
				new ProducerRecord<String, String>(topicName, "message-"+i,"This is a test message--- "+i);
		producer.send(record);
		}*/
		ProducerRecord<String, String> record=
				new ProducerRecord<String, String>(topicName, "message-1","This is a test message");
		
		producer.send(record, new Callback() {
			
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				System.out.println("message delivered to partition: "+metadata.partition()+" at offset: "+metadata.offset());
			}
		});
		
		producer.close();
		System.out.println("messages sent");
	}
}
