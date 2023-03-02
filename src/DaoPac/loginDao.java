package DaoPac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDao {
	
	String sql = "select * from user where user_name=? and password=?";
	String url="jdbc:mysql://localhost:3306/oop_project";
	String username="root";
	String pass="root";
	
	public boolean check(String user_name, String password){
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,pass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user_name);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

}
