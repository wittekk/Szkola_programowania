package model;

import admin.org.mindrot.jbcrypt.BCrypt;

public class User {

	private long id;
	private String username;
	private String email;
	private String password;
	private String salt;
	private int person_group_id;
	
	public User(){}	
	
	public User(String username, String email, String password, int person_group_id){
		this.id = 0;
		setUsername(username).
		setEmail(email).
		setPassword(password).
		setPersonGroupId(person_group_id);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public User setUsername(String username) {
		this.username = username;
		return this;
	}	
	public String getEmail() {
		return email;
	}	
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.salt = BCrypt.gensalt();
		this.password = BCrypt.hashpw(password, salt);
		return this;
	}	
	public User setPersonGroupId(int id){
		this.person_group_id = id;
		return this;
	}
	public int getPersonGroupId(){
		return this.person_group_id;
	}
	@Override
	public String toString(){
		return "id: "+this.id+" username: "+this.username+" email:"+this.email+" password:" + this.password;
	}		
}