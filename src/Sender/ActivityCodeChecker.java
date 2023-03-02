package Sender;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ActivityCodeChecker")
public class ActivityCodeChecker extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String uEmail = request.getParameter("email");
			String Activation_code = request.getParameter("acode");
			checker cc = new checker();	
			if(cc.check(uEmail,Activation_code)==true) {
				response.sendRedirect("userlogin.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		//PrintWriter out = response.getWriter();
		//out.println();
		
		
		
			
	}

}
