package Sender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB_Connection.main_connection;

public class checker {
	
	/*public String Generate_Code;
	public String Activation_code;
	private int result;
	
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public void getActivationCode(String Acode) {
		this.Activation_code=Acode;
		System.out.println(Activation_code);
	}*/
	
	/*public void ActivationCode(String activation_code, String uEmail) throws ClassNotFoundException, SQLException {
		
		main_connection obj_DB_Connection = new main_connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		
		String query = "update class set activation_code=? where email=?";
		ps=connection.prepareStatement(query);
		ps.setString(1, activation_code);
		ps.setString(2, uEmail);
		ps.executeUpdate();
				
		
	}*/

	public boolean check(String email, String activation_code) throws ClassNotFoundException, SQLException {
		
		String sql = "select * from user where email=? and activation_code=?";
		main_connection obj_DB_Connection = new main_connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, activation_code);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return true;
		}
		
		return false;
	}

}
