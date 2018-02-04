package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ExerciseDao;
import model.Solution;
import model.SolutionDao;
import model.SolutionViewUE;
import model.User;
import model.UserDao;





@WebServlet("/userdetail")
public class UserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		try{
			if(request.getParameter("userId") != null){
				
				User user = UserDao.loadUserById(userId);
				request.setAttribute("userx", user);
				
				List<SolutionViewUE> SolView = new ArrayList<>();
				for(Solution solution : SolutionDao.loadAllByUserId(userId)){
					SolView.add(SolutionViewUE.createViewForSolution(solution));
				}
				request.setAttribute("solview", SolView);
			}
		} catch(NumberFormatException exc){
			System.out.println(exc.getMessage());
		}
		
//		SolutionDao sDao  = new SolutionDao();
//
//		request.setAttribute("usersolutions", SolutionDao.loadAllByUserId(userId));
		
//		ExerciseDao eDao  = new ExerciseDao();
//		request.setAttribute("exerciseAll", eDao.loadAll());
//		
//		List<Solution> userSolutions = SolutionDao.loadAllByUserId(userId);
//		request.setAttribute("usersolutions", userSolutions);		

		getServletContext().getRequestDispatcher("/views/userdetail.jsp").forward(request, response);
	}
}
