/**
 * 
 */
package rk.kafka.training.custompartitioner;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

/**
 * @author Administrator
 *
 */
public class MessagePartitioner implements Partitioner {

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.Configurable#configure(java.util.Map)
	 */
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.clients.producer.Partitioner#partition(java.lang.String, java.lang.Object, byte[], java.lang.Object, byte[], org.apache.kafka.common.Cluster)
	 */
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		// TODO Auto-generated method stub
		
		String msgKey = (String)key;
		int partition=3;
		if(msgKey.equals("message-1")) {
			partition=0;
		} else  if(msgKey.equals("message-2")) {
			partition=1;
		} else  if(msgKey.equals("message-3")) {
			partition=2;
		}
		return partition;
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.clients.producer.Partitioner#close()
	 */
	public void close() {
		// TODO Auto-generated method stub

	}

}
