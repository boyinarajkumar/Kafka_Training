package rk.kafka.custom.json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import rk.kafka.custom.json.domain.Employee;

public class Marshlingtest {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Marshaller marshaller = context.createMarshaller();
			Employee emp = new Employee(1001, "Rajkumar Papanaboyina", "Developer");
			FileOutputStream fout = new FileOutputStream("employee.xml");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(emp, fout);
			fout.close();
			System.out.println("Marshalling Done!!");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
