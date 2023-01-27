<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
</head>
<body align="center">
<h1>Employee Register Form</h1>
		<form action="emp/create" method = "post">
		First Name : <input type="text" name="fname" placeholder="Enter First name "> &nbsp;
		Last  Name : <input type="text" name="lname" placeholder="Enter Last name "> &nbsp;
		City name : <input type="text" name="city" placeholder="Enter City name "> &nbsp;
		<input type="submit" name="submit">
		</form>
		
		<h1>Employee Detail </h1>
		<table border="1" align="center">
		<thead>
		<th>Id</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>City</th>
		<th>Operation</th>
		</thead>
		<tbody>
		
		<%
		Class.forName("org.postgresql.Driver");
	     Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo","axelor", "axelor");	     
	     Statement st = c.createStatement();
	     ResultSet rs = st.executeQuery("select * from empdetail");
	     while(rs.next()){
	  	
	    	 int id = rs.getInt("id");
		%>		
		<tr>
		<td><%= rs.getInt("id") %></td>		
		<td><%= rs.getString("fname") %></td>	
		<td><%= rs.getString("lname") %></td>	
		<td><%= rs.getString("city") %></td>
		
		<td><a href=emp/delete/<%= id %>>Delete</a> &nbsp;
		<a href=update.jsp?id=<%= id %>>Update</a>	
		</td>		
		</tr>
		<%
		}
		%>
		<tbody>
		</table>
</body>
</html>