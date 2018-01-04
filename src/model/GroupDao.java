package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sql.DbManager;

public class GroupDao {


	public static void saveToDB(Group group){
		if(group.getId()==0){
			try {
				String generatedColumns[] = { "ID" };
				PreparedStatement stmt = DbManager.getPreparedStatement("INSERT INTO user_group(name) VALUES (?)",generatedColumns);
				stmt.setString(1, group.getName());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()){
					group.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}else{
			try {
				PreparedStatement stmt = DbManager.getPreparedStatement("UPDATE user_group SET name= ? WHERE id= ?");
				stmt.setString(1, group.getName());
				stmt.setInt(2, group.getId());
				stmt.executeUpdate();				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	public static void delete(Group group){
		String sql = "DELETE FROM user_group WHERE id= ?";
		try{
			if(group.getId()!=0){
				PreparedStatement stmt = DbManager.getPreparedStatement(sql);
				stmt.setInt(1, group.getId()); 
				stmt.executeUpdate();
				group.setId(0);
			}
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}	
	public ArrayList<Group> loadAllGroups(){
		try {
			ArrayList<Group> groups = new ArrayList<Group>();
			String sql = "SELECT * FROM user_group";
			PreparedStatement stmt = DbManager.getPreparedStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
				Group loadGroup = new Group();
				loadGroup.setId(resultSet.getInt("id"));
				loadGroup.setName(resultSet.getString("name"));
				groups.add(loadGroup);
			}
			return groups;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public static Group loadGroupById(int id){
		try { 
			String sql = "SELECT * FROM user_group where id=?";
			PreparedStatement stmt = DbManager.getPreparedStatement(sql); 
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Group loadedGroup = new Group();
				loadedGroup.setId(resultSet.getInt("id")); 
				loadedGroup.setName(resultSet.getString("name"));				
				return loadedGroup;
			}			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}		
		return null;
	}
}
