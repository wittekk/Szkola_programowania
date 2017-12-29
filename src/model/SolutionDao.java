package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sql.DbManager;


public class SolutionDao {	
	// non-static DB methods
	public void saveToDB(Solution solution){
		if(solution.getId()==0){
			try {
				String generatedColumns[] = { "ID" };
				PreparedStatement stmt = DbManager.getPreparedStatement("INSERT INTO solution(created,updated,"
						+ "description,excercise_id, users_id) VALUES (?,?,?,?,?)",generatedColumns);
				stmt.setDate(1, (java.sql.Date) solution.getCreated()); 
				stmt.setDate(2, (java.sql.Date) solution.getUpdated());
				stmt.setString(3, solution.getDescription());
				stmt.setInt(4, solution.getExcercise_id());
				stmt.setLong(5, solution.getUsers_id());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys(); 
				if (rs.next()) {
					solution.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				e.getMessage();
			}
		}else{
			try{
				PreparedStatement stmt = DbManager.getPreparedStatement("UPDATE solution SET"
						+ " created=?,updated=?,description=?,excercise_id=?, users_id=? WHERE id=?");
				stmt.setDate(1, (java.sql.Date) solution.getCreated()); 
				stmt.setDate(2, (java.sql.Date) solution.getUpdated());
				stmt.setString(3, solution.getDescription());
				stmt.setInt(4, solution.getExcercise_id());
				stmt.setLong(5, solution.getUsers_id());
				stmt.setInt(6, solution.getId());
				stmt.executeUpdate();
			}catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	public void delete(Solution solution){
		String sql = "DELETE FROM solution WHERE id= ?";
		try{
			PreparedStatement stmt = DbManager.getPreparedStatement(sql);
			stmt.setInt(1, solution.getId()); 
			stmt.executeUpdate();
			solution.setId(0);
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	// static DB methods
	public static ArrayList<Solution> loadAllByExerciseId(int excerciseId){
		try{
			String sql = "SELECT * FROM solution WHERE excercise_id = ?"; 
			PreparedStatement stmt = DbManager.getPreparedStatement(sql);
			stmt.setInt(1, excerciseId);
			return getSolutionsFromStatement(stmt);
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}	
		return null;
	}	
	public static ArrayList<Solution> loadById(int id){
		try { 
			String sql = "SELECT * FROM solution where id=?";
			PreparedStatement stmt = DbManager.getPreparedStatement(sql); 
			stmt.setInt(1, id);
			return getSolutionsFromStatement(stmt);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} 
		return null;
	}
	public static ArrayList<Solution> loadAll(){
		String sql = "SELECT * FROM solution"; 
		PreparedStatement stmt = DbManager.getPreparedStatement(sql);
		return getSolutionsFromStatement(stmt);
	}
	private static ArrayList<Solution> getSolutionsFromStatement(PreparedStatement stmt) {
		try {
			ArrayList<Solution> solutions = new ArrayList<Solution>();
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.setId(resultSet.getInt("id")); 
				loadedSolution.setCreated(resultSet.getDate("created")); 
				loadedSolution.setUpdated(resultSet.getDate("updated"));   
				loadedSolution.setDescription(resultSet.getString("description"));
				loadedSolution.setExcercise_id(resultSet.getInt("excercise_id"));
				loadedSolution.setUsers_id(resultSet.getInt("users_id"));
				solutions.add(loadedSolution);
			}
			return solutions;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
