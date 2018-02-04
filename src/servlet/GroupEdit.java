package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Group;
import model.GroupDao;


@WebServlet("/groupedit")
public class GroupEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Group groupToEdit;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		int groupId = Integer.parseInt(request.getParameter("id"));		
		groupToEdit = GroupDao.loadGroupById(groupId);		
		request.setAttribute("grouptoedit", groupToEdit);			
		getServletContext().getRequestDispatcher("/views/groupedit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		String groupNme = request.getParameter("groupname");
		groupToEdit.setName(groupNme);		
		
		GroupDao.saveToDB(groupToEdit);
		response.sendRedirect(request.getContextPath()+"/adminpanel");
	}
}
