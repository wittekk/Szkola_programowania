package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Exercise;
import sql.DbManager;

public class ExerciseDao {

	// non-static DB methods
	public static void saveToDB(Exercise exercise) {
		if (exercise.getId() == 0) {
			try {
				String generatedColumns[] = { "ID" };
				PreparedStatement stmt = DbManager.getPreparedStatement(
						"INSERT INTO exercise(title, description) VALUES (?, ?)", generatedColumns);
				stmt.setString(1, exercise.getTitle());
				stmt.setString(2, exercise.getDescription());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					exercise.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			try {
				PreparedStatement stmt = DbManager
						.getPreparedStatement("UPDATE exercise SET title= ?, description= ? WHERE id= ?");
				stmt.setString(1, exercise.getTitle());
				stmt.setString(2, exercise.getDescription());
				stmt.setInt(3, exercise.getId());
				stmt.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void delete(Exercise exercise) {
		String sql = "DELETE FROM excercise WHERE id= ?";
		try {
			if (exercise.getId() != 0) {
				PreparedStatement stmt = DbManager.getPreparedStatement(sql);
				stmt.setInt(1, exercise.getId());
				stmt.executeUpdate();
				exercise.setId(0);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	// static DB methods
	public static ArrayList<Exercise> loadAllByUserId(int userId) {
		try {
			String sql = "SELECT * FROM exercise JOIN solution ON solution.exercise_id = exercise.id "
					+ "JOIN users ON solution.users_id = users.id WHERE users.id = ?";
			PreparedStatement stmt = DbManager.getPreparedStatement(sql);
			stmt.setInt(1, userId);
			return getExerciseFromStatement(stmt);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static ArrayList<Exercise> loadAll() {
		String sql = "SELECT * FROM exercise";
		PreparedStatement stmt = DbManager.getPreparedStatement(sql);
		return getExerciseFromStatement(stmt);
	}

	private static ArrayList<Exercise> getExerciseFromStatement(PreparedStatement stmt) {
		try {
			ArrayList<Exercise> excercises = new ArrayList<Exercise>();
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Exercise loadedEx = new Exercise();
				loadedEx.setId(resultSet.getInt("id"));
				loadedEx.setTitle(resultSet.getString("title"));
				loadedEx.setDescription(resultSet.getString("description"));
				excercises.add(loadedEx);
			}
			return excercises;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static Exercise loadExcerciseById(int id) {
		try {
			String sql = "SELECT * FROM excercise where id=?";
			PreparedStatement stmt = DbManager.getPreparedStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Exercise loadedExercise = new Exercise();
				loadedExercise.setId(resultSet.getInt("id"));
				loadedExercise.setTitle(resultSet.getString("title"));
				loadedExercise.setDescription(resultSet.getString("description"));
				return loadedExercise;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
