package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB_Connection.main_connection;



public class user_registration {
	
	public void insert_value1(String first_name, String last_name, String email, String mb_number, String user_name, String password, String activation_code) throws ClassNotFoundException, SQLException{
		 main_connection obj_DB_Connection = new main_connection();
		 Connection connection = obj_DB_Connection.get_connection();
		 
		 PreparedStatement ps = null;
		 
		 String query="insert into user(first_name,last_name,email,mb_number,user_name,password,activation_code) values(?,?,?,?,?,?,?)";
		 ps=connection.prepareStatement(query);
		 ps.setString(1, first_name);
		 ps.setString(2, last_name);	 
		 ps.setString(3, email);
		 ps.setString(4, mb_number);
		 ps.setString(5, user_name);
		 ps.setString(6, password);
		 ps.setString(7, activation_code);
		 ps.executeUpdate();
		 
		 
		 
	}


}
