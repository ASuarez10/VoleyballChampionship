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
	
	//addSpectator
	
	public void addSpectator(Spectator s, Spectator root) {
		
		if(s.getId().compareTo(root.getId()) < 0) {
			if(root.getLeft() == null) {
				root.setLeft(s);
			}else {
				addSpectator(s, root.getLeft());
			}
		}else {
			if(root.getRight() == null) {
				root.setRight(s);
			}else {
				addSpectator(s, root.getRight());
			}
		}
	}

}//final
