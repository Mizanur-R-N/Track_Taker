package User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoPac.loginDao;



@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		
		
		
		loginDao dao = new loginDao();
		
		if(dao.check(user_name, password)==true){
			HttpSession session = request.getSession();
			session.setAttribute("username", user_name);
			response.sendRedirect("user_home.html");
		}
		else{
			response.sendRedirect("userlogin.html");
		}
	}

}
