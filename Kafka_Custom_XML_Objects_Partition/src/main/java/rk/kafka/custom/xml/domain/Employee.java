/**
 * 
 */
package rk.kafka.custom.xml.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Administrator
 *
 */
@XmlRootElement
@XmlType(propOrder={"empId","empName","designation"})
public class Employee {
	
	private int empId;
	private String empName;
	private String designation;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Employee(int empId, String empName, String designation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
	}
	public Employee() {
		super();
	}
	
	

}
