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
<title>Update form</title>
</head>
<body align="center">

<h1>Employee Register Form</h1>
<%
		String id = request.getParameter("id");
		
		Class.forName("org.postgresql.Driver");
	     Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo","axelor", "axelor");	     
	     Statement st = c.createStatement();
	     ResultSet rs = st.executeQuery("select * from empdetail where id = '"+id+"'");
	     while(rs.next()){
		%>	
		<form action="emp/update/<%= rs.getInt("id") %>" method = "post">
		First Name : <input type="text" name="fname" value="<%= rs.getString("fname") %>"> &nbsp;
		Last  Name : <input type="text" name="lname" value="<%= rs.getString("lname") %>" > &nbsp;
		City name : <input type="text" name="city"  value="<%= rs.getString("city") %>"> &nbsp;
		<input type="submit" name="submit" value="update">
		</form>
		<%
		}
		%>
</body>
</html>