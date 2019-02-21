/**
 * 
 */
package rk.kafka.custom.partioner;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import rk.kafka.custom.json.domain.Employee;

/**
 * @author Administrator
 *
 */
public class EmployeePartitioner implements Partitioner{

	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
		
	}

	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		// TODO Auto-generated method stub
		Employee emp = (Employee)value;
		int partition=3;
		if(emp.getDesignation().equals("Accountant")) {
			partition=0;
		} else if(emp.getDesignation().equals("Developer")) {
			partition=1;
		}else if(emp.getDesignation().equals("Architect")) {
			partition=2;
		}
		return partition;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

}
