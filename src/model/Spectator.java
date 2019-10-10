package model;

public class Spectator extends Person {

	//Relations
	private Spectator left;
	private Spectator rigth;
	public Spectator(String id, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthDay, Spectator left, Spectator rigth) {
		super(id, firstName, lastName, email, gender, country, photo, birthDay);
		this.left = left;
		this.rigth = rigth;
	}
	public Spectator getLeft() {
		return left;
	}
	public void setLeft(Spectator left) {
		this.left = left;
	}
	public Spectator getRigth() {
		return rigth;
	}
	public void setRigth(Spectator rigth) {
		this.rigth = rigth;
	}
	
	

}
