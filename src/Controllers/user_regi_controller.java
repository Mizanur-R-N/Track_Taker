package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Sender.ActivationKeyGenerator;
import Sender.test;
import User.user_registration;


@WebServlet("/user_regi_controller")
public class user_regi_controller extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActivationKeyGenerator activecode = new ActivationKeyGenerator();
		
		String gcode = activecode.nextString(); //fetch the generate code
		
		String first_name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		String email = request.getParameter("email");
		String mb_number = request.getParameter("mb");
		String user_name = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		
		boolean m;
		user_registration obj_ur = new user_registration();
		try {
			obj_ur.insert_value1(first_name, last_name, email, mb_number, user_name, password, gcode);
			test ts = new test();
			m = ts.mail(email, gcode);
			if(m==true) {
				response.sendRedirect("ActivationCodeSubmit.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	


}
