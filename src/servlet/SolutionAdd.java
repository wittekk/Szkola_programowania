package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Exercise;
import model.ExerciseDao;
import model.Solution;
import model.SolutionDao;
import model.UserDao;


@WebServlet("/solutionadd")
public class SolutionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Exercise exerciseToAddSolution;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		int exerciseId = Integer.parseInt(request.getParameter("id"));		
		exerciseToAddSolution = ExerciseDao.loadExcerciseById(exerciseId);		
		request.setAttribute("exercisetoaddsolution", exerciseToAddSolution);
				
		UserDao uDao  = new UserDao();
		request.setAttribute("usersAll", uDao.loadAllUsers());	
		
		getServletContext().getRequestDispatcher("/views/solutionadd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		System.out.println(date);
		System.out.println(utilDate);
		
		String description = request.getParameter("description");		
		int users_id = Integer.parseInt(request.getParameter("selecteduser"));		
		
//		newSolution.setCreated(utilDate);
//		newSolution.setUpdated(utilDate);
//		newSolution.setDescription(description);
//		newSolution.setExcercise_id(excercise_id);
//		newSolution.setUsers_id(users_id);
		
		Solution newSolution = new Solution(date, date, description, exerciseToAddSolution.getId() , users_id);
		SolutionDao.saveToDB(newSolution);
		response.sendRedirect(request.getContextPath()+"/adminpanel");		
		
//		java.util.Date utilDate = new java.util.Date();
//		java.sql.Date date = new java.sql.Date(utilDate.getTime());
	}
}
