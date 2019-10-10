package model;

public class Event {

	//Attributes
	private String name;
	
	//Relations
	private Person person;
	
	//Constructor
	public Event(String name, Person person) {
		this.name = name;
		this.person = person;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
