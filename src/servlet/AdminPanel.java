package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GroupDao;
import model.UserDao;


@WebServlet("/adminpanel")
public class AdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GroupDao gDao  = new GroupDao();
		request.setAttribute("groupsAll", gDao.loadAllGroups());
		
		UserDao uDao  = new UserDao();
		request.setAttribute("usersAll", uDao.loadAllUsers());
		
		getServletContext().getRequestDispatcher("/views/admin1.jsp").forward(request, response);
	}

}
