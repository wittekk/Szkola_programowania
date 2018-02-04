package model;

public class Group {

	private int id;
	private String name;

	public Group(){}

	public Group(String name){
		this.id = 0;
		setName(name);
	}
	public Group setName(String name){
		this.name = name;
		return this;
	}
	public String getName(){
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}	
	@Override
	public String toString(){
		return "id: " + this.id + ", name: "+this.name;
	}
}
