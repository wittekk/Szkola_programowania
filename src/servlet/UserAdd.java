package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GroupDao;
import model.User;
import model.UserDao;

@WebServlet("/useradd")
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GroupDao gDao  = new GroupDao();
		request.setAttribute("groupsAll", gDao.loadAllGroups());
		
		getServletContext().getRequestDispatcher("/views/useradd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int person_group_id = Integer.parseInt(request.getParameter("person_group_id"));		

		User newUser  = new User(username, email, password, person_group_id);		
		UserDao.saveToDB(newUser);

		response.sendRedirect(request.getContextPath()+"/adminpanel"); 
	}

}
