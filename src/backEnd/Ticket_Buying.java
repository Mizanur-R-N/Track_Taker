package backEnd;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ticket_Buying")
public class Ticket_Buying extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mc_number = request.getParameter("MC_number");
		String card_password = request.getParameter("card_password");
		
		Ticket_payment_Confirmation TPC = new Ticket_payment_Confirmation();
		try {
			if(TPC.card_checker(mc_number, card_password)==true) {
				response.sendRedirect("ticket_confirmation.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
