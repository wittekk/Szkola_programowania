package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Exercise;
import model.ExerciseDao;

@WebServlet("/exerciseadd")
public class ExerciseAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ExerciseDao eDao  = new ExerciseDao();
		request.setAttribute("groupsAll", eDao.loadAll());
		
		getServletContext().getRequestDispatcher("/views/exerciseadd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Exercise newExercise  = new Exercise(title, description);		
		ExerciseDao.saveToDB(newExercise);

		response.sendRedirect(request.getContextPath()+"/adminpanel"); 
	}
}
