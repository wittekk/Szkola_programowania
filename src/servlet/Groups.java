package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GroupDao;

@WebServlet("/groups")
public class Groups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GroupDao dao  = new GroupDao();

		request.setAttribute("groupsAll", dao.loadAllGroups());

		getServletContext().getRequestDispatcher("/views/groups1.jsp").forward(request, response);
	}

}
