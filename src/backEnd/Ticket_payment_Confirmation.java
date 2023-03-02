package backEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ticket_payment_Confirmation {
	
	String sql = "select * from user where mc_number=? and card_password=?";
	String url="jdbc:mysql://localhost:3306/oop_project";
	String username="root";
	String pass="root";
	
	public boolean card_checker(String mc_number, String card_password) throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, mc_number);
			st.setString(2, card_password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
