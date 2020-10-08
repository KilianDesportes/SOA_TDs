package fr.insa.mas.studentManagementMS;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")
public class Student {

	
	private int id;
	private String lastName;
	private String firstName;
	
	public Student(int id, String lastName, String firstName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public Student() {
		
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
