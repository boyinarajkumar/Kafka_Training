/**
 * 
 */
package rk.kafka.custom.json.deseralizer;

import java.io.IOException;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rk.kafka.custom.json.domain.Employee;

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
		Employee emp = null;
		System.out.println("Deserializing "+new String(data));
		ObjectMapper mapper = new ObjectMapper();
		try {
			emp = mapper.readValue(data, Employee.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return emp;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

}
