/**
 * 
 */
package rk.kafka.custom.json.seralizer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rk.kafka.custom.json.domain.Employee;

/**
 * @author Administrator
 *
 */
public class EmployeeSerializer implements Serializer<Employee> {


	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	public byte[] serialize(String topic, Employee data) {
		byte[] array = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonContent = mapper.writeValueAsString(data);
			System.out.println("Converted to JSON"+jsonContent);
			array = jsonContent.getBytes();
		}  catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

}
