package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sql.DbManager;

public class UserDao {
	
	// non-static DB methods
	public static void saveToDB(User user){
		if(user.getId()==0){
			try {
				String generatedColumns[] = { "ID" };
				PreparedStatement stmt = DbManager.getPreparedStatement("INSERT INTO"
						+ " users(username,email,password,person_group_id) VALUES (?,?,?,?)",generatedColumns);
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getEmail());
				stmt.setString(3, user.getPassword());				
				stmt.setInt(4, user.getPerson_group_id());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys(); 
				if (rs.next()) {
					user.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}else{
			try{
				PreparedStatement stmt = DbManager.getPreparedStatement("UPDATE users "
						+ "SET username=?, email=?, person_group_id=?, password=? WHERE id=?");
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getEmail());
				stmt.setInt(3, user.getPerson_group_id());
				stmt.setString(4, user.getPassword());				
				stmt.setLong(5, user.getId());
				stmt.executeUpdate();
			}catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	public static void delete(User user){
		String sql = "DELETE FROM users WHERE id= ?";
		try{
			if(user.getId()!=0){
				PreparedStatement stmt = DbManager.getPreparedStatement(sql);
				stmt.setLong(1, user.getId()); 
				stmt.executeUpdate();
				user.setId(0);
			}
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	// static DB methods
	public static ArrayList<User> loadAllByGroupId(int groupId){
		String sql = "SELECT * FROM users WHERE person_group_id = ?";
		PreparedStatement stmt = DbManager.getPreparedStatement(sql);
		try {
			stmt.setInt(1, groupId);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return getUsersFromStatement(stmt);
	}
	public ArrayList<User> loadAllUsers(){
		String sql = "SELECT * FROM users"; 
		PreparedStatement stmt = DbManager.getPreparedStatement(sql); 
		return getUsersFromStatement(stmt);
	}
	private static ArrayList<User> getUsersFromStatement(PreparedStatement stmt) {
		try {
			ArrayList<User> users = new ArrayList<User>(); 
			ResultSet resultSet = stmt.executeQuery();
//			resultSet.last();
//			int size = resultSet.getRow();
//			resultSet.beforeFirst();
//			System.out.println("LOG COUNT Result: "+size);
			while (resultSet.next()) {
				User loadedUser = new User();
				loadedUser.setId(resultSet.getLong("id")); 
				loadedUser.setUsername(resultSet.getString("username")); 
				loadedUser.setPassword(resultSet.getString("password")); 
				loadedUser.setEmail(resultSet.getString("email"));				
				loadedUser.setPerson_group_id(resultSet.getInt("person_group_id"));
				users.add(loadedUser);
			}			
			return users;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} 
		return null;
	}
	public static User loadUserById(int id){
		try { 
			String sql = "SELECT * FROM users where id=?";
			PreparedStatement stmt = DbManager.getPreparedStatement(sql); 
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				User loadedUser = new User();
				loadedUser.setId(resultSet.getLong("id")); 
				loadedUser.setUsername(resultSet.getString("username")); 
				loadedUser.setPassword(resultSet.getString("password")); 
				loadedUser.setEmail(resultSet.getString("email"));				
				loadedUser.setPerson_group_id(resultSet.getInt("person_group_id"));
				return loadedUser;
			}			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} 		
		return null;
	}	
}