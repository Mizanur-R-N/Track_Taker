package backEnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FareCalculation")
public class FareCalculation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int source=Integer.parseInt(request.getParameter("source"));
		int destination=Integer.parseInt(request.getParameter("destination"));
		String sourceStations="";
		String destinationStations="";
		double distance_bt_2_stations[]=new double[16];
		    Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null; 
		    ResultSet rs2 = null; 
		    
		    
		    dbConnection db=new dbConnection();
		    try {
				con=db.get_connection();
				String query="select * from stations_distance";
			    ps=con.prepareStatement(query);    
			    rs=ps.executeQuery();
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
		        
		    
		    int i=0;
		    if(rs!=null)
 		   {
 		 	  try {
 		 			 while(rs.next())
 		 				{  
 		 				 	distance_bt_2_stations[i]= rs.getDouble(4);
 		 				 	i++;
 		 				}
 		 		} catch (SQLException e) {
 		 			
 		 			e.printStackTrace();
 		 		}
 		   }
    try {
		rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
    
    
    try {
    	String query2="select * from stations";
		ps=con.prepareStatement(query2);
		rs2=ps.executeQuery();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}    
    
    //rs2=db.ExecuteQuery(st, query2);
    if(rs2!=null)
	   {
	 	  try {
	 			 while(rs2.next())
	 				{  
	 				if(source==rs2.getInt(1) )
	 					sourceStations=rs2.getString(2);
	 				if(destination==rs2.getInt(1))
	 					destinationStations=rs2.getString(2);
	 				}
	 		} catch (SQLException e) {
	 			
	 			e.printStackTrace();
	 		}
	   }
    try {
		rs.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    Calculation fc=new Calculation();
    fc.setStations();
    fc.setFair(distance_bt_2_stations,5);
    int totalFair=fc.totalCostCalculate(source, destination);
    double totalDistance=fc.totalDistanceCalculate(source, destination, distance_bt_2_stations);
    
    HttpSession session=request.getSession();
    session.setAttribute("totalDistance", totalDistance);
    session.setAttribute("totalFair", totalFair);
    session.setAttribute("sourceStations", sourceStations);
    session.setAttribute("destinationStations", destinationStations);
    
    PrintWriter out = response.getWriter();
    out.println(totalDistance);
    out.println(totalFair);
    out.println(sourceStations);
    out.println(destinationStations);
    out.println(source);
    out.println(destination);
    //db.ConnectionClose(rs, con);
    response.sendRedirect("farepage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
