package ePetition;

public class User {
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	int position;
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public User(int position, String email, String passwordHash, String fullname) {
		super();
		this.position = position;
		this.email = email;
		this.passwordHash = passwordHash;
		this.fullname = fullname;
	}

	String email;
	String passwordHash;
	String fullname;

}
