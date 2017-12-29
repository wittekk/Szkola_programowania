package model;

import java.util.Date;

public class Solution {

	private int id;
	private Date created;
	private Date updated;
	private String description;
	private int excercise_id;
	private long users_id;

	public Solution(){}

	public Solution(Date created, Date updated, String description, int excercise_id, long users_id){		
		setCreated(created);
		setUpdated(updated);
		setDescription(description);
		setExcercise_id(excercise_id);
		setUsers_id(users_id);
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getExcercise_id() {
		return excercise_id;
	}
	public void setExcercise_id(int excercise_id) {
		this.excercise_id = excercise_id;
	}
	public long getUsers_id() {
		return users_id;
	}
	public void setUsers_id(long users_id) {
		this.users_id = users_id;
	}
	@Override
	public String toString() {
		return "Solution [id=" + id + ", created=" + created + ", updated=" + updated + ", description=" + description
				+ ", excercise_id=" + excercise_id + ", users_id=" + users_id + "]";
	}
}
