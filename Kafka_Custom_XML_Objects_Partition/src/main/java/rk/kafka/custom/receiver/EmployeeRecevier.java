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
import org.apache.kafka.common.TopicPartition;

import rk.kafka.custom.xml.domain.Employee;

/**
 * @author Administrator
 *
 */
public class EmployeeRecevier {
	
	public static void main(String[] args) {
		Properties props=new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("value.deserializer", "rk.kafka.custom.xml.deseralizer.EmployeeDeserializer");
		props.setProperty("group.id", "test-group");
		KafkaConsumer<String, Employee> consumer=new KafkaConsumer<String, Employee>(props);
		/*List<String> topicList=new ArrayList<String>();
		topicList.add("emp-topic");
		consumer.subscribe(topicList);*/
		/*List<TopicPartition> partitionList=new ArrayList<TopicPartition>();
		//int partitionNumber=Integer.parseInt(args[0]);
		TopicPartition partition=new TopicPartition("emp-topic",0);
		partitionList.add(partition);
		consumer.assign(partitionList);
		consumer.seek(partition,3);*/
		
		List<TopicPartition> partitionList = new ArrayList<TopicPartition>();
		partitionList.add(new TopicPartition("emp-topic", Integer.parseInt(args[0])));//PartitionNumer pass from command line args
		System.out.println("Assigned to emp topic");
		consumer.assign(partitionList);
		
		System.out.println("Subscribed to emp-topic");
		while(true){
			ConsumerRecords<String, Employee> records=consumer.poll(Duration.ZERO);
			for(ConsumerRecord<String, Employee> record:records){
				Employee e = record.value();
				System.out.println(e.getEmpId()+ "\t"+e.getEmpName()+ "\t "+e.getDesignation());
			}
		}
	}

}
