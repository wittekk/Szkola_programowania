package model;

import java.util.Date;

public class SolutionViewUE {
	
	private Solution solution;
	//połączenie tablic solution z user igroup
	private User user;
	private Exercise exercise;	

	public static SolutionViewUE createViewForSolution (Solution solution) {
		
		SolutionViewUE newVewSol = new SolutionViewUE();
		newVewSol.solution = solution;
		newVewSol.user = UserDao.loadUserById(solution.getUsers_id());
		newVewSol.exercise = ExerciseDao.loadExerciseById(solution.getExercise_id());
		
		return newVewSol;	
	}

	public int getId() {
		return solution.getId();
	}

	public Date getCreated() {
		return solution.getCreated();
	}
	public User getUser() {
		return user;
	}
	public Exercise getExercise() {
		return exercise;
	}
}
