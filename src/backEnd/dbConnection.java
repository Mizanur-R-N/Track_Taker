package backEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbConnection {
	
	public Connection get_connection() throws ClassNotFoundException, SQLException{
		String url = "jdbc:mysql://localhost:3306/matro_project";
		String name = "root";
		String Pass = "root";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, name, Pass);
		
		return conn;
	}


}
