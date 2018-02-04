package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Group;
import model.GroupDao;


@WebServlet("/groupadd")
public class GroupAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GroupDao gDao  = new GroupDao();
		request.setAttribute("groupsAll", gDao.loadAllGroups());
		
		getServletContext().getRequestDispatcher("/views/groupadd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		Group newGroup  = new Group(name);		
		GroupDao.saveToDB(newGroup);

		response.sendRedirect(request.getContextPath()+"/adminpanel"); 
	}
}
