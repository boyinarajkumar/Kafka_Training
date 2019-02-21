/**
 * 
 */
package rk.kafka.training.sender;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
		Future<RecordMetadata> future=producer.send(record);
		try {
			RecordMetadata rmd=future.get();
			System.out.println("message delivered to parition: "+rmd.partition()+" at offset: "+rmd.offset());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producer.close();
		System.out.println("messages sent");
	}
}
