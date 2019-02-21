/**
 * 
 */
package rk.kafka.custom.sender;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import rk.kafka.custom.json.domain.Employee;

/**
 * @author Administrator
 *
 */
public class EmployeeSender {

	public static void main(String[] args) {
		
		Properties props=new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "rk.kafka.custom.json.seralizer.EmployeeSerializer");
		//props.setProperty("partitioner.class", "rk.kafka.custom.partioner.EmployeePartitioner");
		
		KafkaProducer<String, Employee> producer=new KafkaProducer<String, Employee>(props);
		String topicName="emp-topic";
		/*for(int i=1;i<=50;i++){
		ProducerRecord<String, String> record=
				new ProducerRecord<String, String>(topicName, "message-"+i,"This is a test message--- "+i);
		producer.send(record);
		}*/
			ProducerRecord<String, Employee> record=
					new ProducerRecord<String, Employee>(topicName, "employee-1", new Employee(1004, "Rajkumar", "Developer"));
			producer.send(record);
			
			ProducerRecord<String, Employee> record1=
					new ProducerRecord<String, Employee>(topicName, "employee-1", new Employee(1005, "MahithSaiVenkat", "Admin"));
			producer.send(record1);

			
		producer.close();
		System.exit(0);
		System.out.println("messages sent");
	}
}
