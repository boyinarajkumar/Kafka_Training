/**
 * 
 */
package rk.kafka.training.receiver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

/**
 * @author Administrator
 *
 */
public class MessageRecevier {
	
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		//Desrialization from Byte to String
		props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("group.id", "test-group");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		/*List<String> topicList = new ArrayList<String>();
		topicList.add("first-topic");
		consumer.subscribe(topicList);*/
		
		List<TopicPartition> partitionList = new ArrayList<TopicPartition>();
		partitionList.add(new TopicPartition("msg-topic", Integer.parseInt(args[0])));//PartitionNumer pass from command line args
		System.out.println("Assigned to msg topic");
		consumer.assign(partitionList);
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(3));
			for(ConsumerRecord<String, String> record: records) {
				System.out.println("Message Recived with Key:"+record.key()+ " and value "+record.value());
			}
		}
		
	}

}
