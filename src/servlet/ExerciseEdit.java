package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Exercise;
import model.ExerciseDao;

@WebServlet("/exerciseedit")
public class ExerciseEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Exercise exerciseToEdit;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		int exerciseId = Integer.parseInt(request.getParameter("id"));		
		exerciseToEdit = ExerciseDao.loadExcerciseById(exerciseId);		
		request.setAttribute("exercisetoedit", exerciseToEdit);			
		getServletContext().getRequestDispatcher("/views/exerciseedit.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		String exerciseTitle = request.getParameter("exercisetitle");
		String exerciseDescription = request.getParameter("exercisedescription");
		exerciseToEdit.setTitle(exerciseTitle);
		exerciseToEdit.setDescription(exerciseDescription);
		
		ExerciseDao.saveToDB(exerciseToEdit);
		response.sendRedirect(request.getContextPath()+"/adminpanel");
	}
}
