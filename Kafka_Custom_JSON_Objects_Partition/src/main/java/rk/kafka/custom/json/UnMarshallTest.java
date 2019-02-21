/**
 * 
 */
package rk.kafka.custom.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import rk.kafka.custom.json.domain.Employee;

/**
 * @author Administrator
 *
 */
public class UnMarshallTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			FileInputStream fin =  new FileInputStream("employee.xml");
			Employee e =  (Employee) unmarshaller.unmarshal(fin);
			fin.close();
			System.out.println("Id: " +e.getEmpId());
			System.out.println("Name: " +e.getEmpName());
			System.out.println("Designation: " +e.getDesignation());
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
