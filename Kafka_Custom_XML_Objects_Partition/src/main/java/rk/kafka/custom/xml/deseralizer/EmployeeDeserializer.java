/**
 * 
 */
package rk.kafka.custom.xml.deseralizer;

import java.io.StringReader;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.kafka.common.serialization.Deserializer;

import rk.kafka.custom.xml.domain.Employee;

/**
 * @author Administrator
 *
 */
public class EmployeeDeserializer implements Deserializer<Employee> {

	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	public Employee deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		JAXBContext context;
		String xmlContent = new String(data);
		Employee emp = null;
		 try {
			context = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader reader = new StringReader(xmlContent);
			emp = (Employee) unmarshaller.unmarshal(reader);
			reader.close();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

}
