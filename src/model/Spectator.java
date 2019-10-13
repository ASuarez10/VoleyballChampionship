package model;

public class Spectator extends Person {

	//Relations
	private Spectator left;
	private Spectator right;
	public Spectator(String id, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthDay, Spectator left, Spectator right) {
		super(id, firstName, lastName, email, gender, country, photo, birthDay);
		this.left = left;
		this.right = right;
	}
	public Spectator getLeft() {
		return left;
	}
	public void setLeft(Spectator left) {
		this.left = left;
	}
	public Spectator getRight() {
		return right;
	}
	public void setRight(Spectator right) {
		this.right = right;
	}
	
	

}
