/**
 * 
 */
package rk.kafka.custom.sender;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import rk.kafka.custom.xml.domain.Address;
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
		
		KafkaProducer<String, Employee> producer=new KafkaProducer<String, Employee>(props);
		String topicName="emp-topic";
		Employee e = new Employee(001, "Prince", "Developer");
		Address add = new Address("Hyderbad", "Telangana");
		e.setAddress(add);
		/*for(int i=1;i<=50;i++){
		ProducerRecord<String, String> record=
				new ProducerRecord<String, String>(topicName, "message-"+i,"This is a test message--- "+i);
		producer.send(record);
		}*/
		ProducerRecord<String, Employee> record=
				new ProducerRecord<String, Employee>(topicName, "employee-1", e);
		Future<RecordMetadata> future=producer.send(record);
		try {
			RecordMetadata rmd=future.get();
			System.out.println("message delivered to parition: "+rmd.partition()+" at offset: "+rmd.offset());
		} catch (Exception excep) {
			// TODO Auto-generated catch block
			excep.printStackTrace();
		}
		producer.close();
		System.out.println("messages sent");
	}
}
