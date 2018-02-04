package model;

import java.util.Date;

public class Solution {

	private int id;
	private Date created;
	private Date updated;
	private String description;
	private int exercise_id;
	private int users_id;

	public Solution(){}

	public Solution(Date created, Date updated, String description, int exercise_id, int users_id){		
		setCreated(created);
		setUpdated(updated);
		setDescription(description);
		setExercise_id(exercise_id);
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
	public int getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	@Override
	public String toString() {
		return "Solution [id=" + id + ", created=" + created + ", updated=" + updated + ", description=" + description
				+ ", exercise_id=" + exercise_id + ", users_id=" + users_id + "]";
	}
}
