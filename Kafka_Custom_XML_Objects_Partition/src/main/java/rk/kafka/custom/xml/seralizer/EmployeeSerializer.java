/**
 * 
 */
package rk.kafka.custom.xml.seralizer;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.kafka.common.serialization.Serializer;

import rk.kafka.custom.xml.domain.Employee;

/**
 * @author Administrator
 *
 */
public class EmployeeSerializer implements Serializer<Employee> {


	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	public byte[] serialize(String topic, Employee data) {
		JAXBContext context;
		byte[] array = null;
		try {
			 context = JAXBContext.newInstance(Employee.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter writer = new StringWriter();
			marshaller.marshal(data, writer);
			String xmlContent = writer.toString();
			System.out.println("Converted into XML"+xmlContent);
			array = xmlContent.getBytes();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

}
