<%@page import="java.util.List"%>
<%@page import="com.unique.db.EmpDetail"%>
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
		
	  <% EmpDetail e = (EmpDetail) request.getAttribute("EmpById");  %>

       <form action="<%= request.getContextPath()%>/emp/edit/<%= e.getId()  %>" method = "post">
		First Name : <input type="text" name="fname" value="<%= e.getFname()  %>"> &nbsp;
		Last  Name : <input type="text" name="lname" value="<%= e.getLname() %>" > &nbsp;
		City name : <input type="text" name="city"  value="<%=  e.getCity() %>"> &nbsp;
		<input type="submit" name="submit" value="update">
		</form> 	
</body>
</html>