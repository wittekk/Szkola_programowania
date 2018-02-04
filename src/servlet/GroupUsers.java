package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Group;
import model.GroupDao;
import model.User;
import model.UserDao;


@WebServlet("/groupusers")
public class GroupUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{
			if(request.getParameter("groupId") != null){
				int groupId = Integer.parseInt(request.getParameter("groupId"));
				Group gDao = GroupDao.loadGroupById(groupId);
				request.setAttribute("groupName", gDao);
								
				List<User> groupUsers = UserDao.loadAllByGroupId(groupId);
				request.setAttribute("groupusers", groupUsers);
			}
		}catch(NumberFormatException exc){
			System.out.println("Wyłapany wyjątek: " + exc.getMessage());
		}		
		getServletContext().getRequestDispatcher("/views/groupUsers.jsp").forward(request, response);		
	}
}
