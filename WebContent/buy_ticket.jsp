<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String price = request.getParameter("Ticket_price");
		double Ticket_price = Double.parseDouble(price);
	%>
	your total bill = <% out.println(Ticket_price); %> BDT.
	
	<form action="Ticket_Buying" method="post">
		<table>
			<tr>
				<td>
					Enter Your Matro Card Number:<br>
					<input type="text" name="MC_number"> <br>
					Enter Card Password:<br>
					<input type="password" name="card_password"> <br>
					<br>
					<input type="submit">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>