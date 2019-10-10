package model;

public class Competitor extends Person {

	//Relations
	private Competitor previous, next;
	
	public Competitor(String id, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthDay, Competitor previous, Competitor next) {
		super(id, firstName, lastName, email, gender, country, photo, birthDay);
		this.previous = previous;
		this.next = next;
	}

	public Competitor getPrevious() {
		return previous;
	}

	public void setPrevious(Competitor previous) {
		this.previous = previous;
	}

	public Competitor getNext() {
		return next;
	}

	public void setNext(Competitor next) {
		this.next = next;
	}

	
}
