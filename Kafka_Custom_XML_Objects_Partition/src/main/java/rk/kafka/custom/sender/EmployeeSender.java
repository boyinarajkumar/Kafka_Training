/**
 * 
 */
package rk.kafka.custom.sender;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import rk.kafka.custom.xml.domain.Employee;

/**
 * @author Administrator
 *
 */
public class EmployeeSender {

	public static void main(String[] args) {
		
		Properties props=new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "rk.kafka.custom.xml.seralizer.EmployeeSerializer");
		props.setProperty("partitioner.class", "rk.kafka.custom.partioner.EmployeePartitioner");
		
		KafkaProducer<String, Employee> producer=new KafkaProducer<String, Employee>(props);
		String topicName="emp-topic";
		/*for(int i=1;i<=50;i++){
		ProducerRecord<String, String> record=
				new ProducerRecord<String, String>(topicName, "message-"+i,"This is a test message--- "+i);
		producer.send(record);
		}*/
			ProducerRecord<String, Employee> record=
					new ProducerRecord<String, Employee>(topicName, "employee-1", new Employee(1004, "Sai", "Accountant"));
			producer.send(record);
			ProducerRecord<String, Employee> record1=
					new ProducerRecord<String, Employee>(topicName, "employee-1", new Employee(1005, "Mahith", "Developer"));
			producer.send(record1);
			ProducerRecord<String, Employee> record2=
					new ProducerRecord<String, Employee>(topicName, "employee-1", new Employee(1006, "Raj", "Developer"));
			producer.send(record2);
			ProducerRecord<String, Employee> record3=
					new ProducerRecord<String, Employee>(topicName, "employee-1", new Employee(1007, "Gopal", "Accountant"));
			producer.send(record3);
			ProducerRecord<String, Employee> record4=
					new ProducerRecord<String, Employee>(topicName, "employee-1", new Employee(1008, "Mahith", "Admin"));
			producer.send(record4);
			
			ProducerRecord<String, Employee> record5=
					new ProducerRecord<String, Employee>(topicName, "employee-1", new Employee(1009, "Sunil", "Architect"));
			producer.send(record5);
			
		producer.close();
		System.exit(0);
		System.out.println("messages sent");
	}
}
