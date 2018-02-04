package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/useredit")
public class UserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User userToEdit;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		int userId = Integer.parseInt(request.getParameter("id"));		
		userToEdit = UserDao.loadUserById(userId);		
		request.setAttribute("usertoedit", userToEdit);			
		getServletContext().getRequestDispatcher("/views/useredit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		userToEdit.setUsername(username);
		userToEdit.setEmail(email);
		userToEdit.setPassword(password);
				
		
		UserDao.saveToDB(userToEdit);
		response.sendRedirect(request.getContextPath()+"/adminpanel");
	}
}
