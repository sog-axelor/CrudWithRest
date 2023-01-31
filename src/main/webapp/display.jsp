<%@page import="java.util.List"%>
<%@page import="com.unique.db.EmpDetail"%>
<%@page import="javax.inject.Inject"%>
<%@page import="com.unique.service.EmpService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<h1 align="center">Our Employee</h1>



	
 	<table border=2 align="center">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>City</th>
            <th>Operation</th>
        </tr>
        <% for (EmpDetail EmpDetail :(List<EmpDetail>)request.getAttribute("EmpList")) { %>
        <tr width="42" height="42">
            <td><%= EmpDetail.getId() %></td>
            <td><%= EmpDetail.getFname() %></td>
            <td><%= EmpDetail.getLname() %></td>
          	<td><%= EmpDetail.getCity() %></td>
          	<td><a href="delete/<%= EmpDetail.getId() %>">Delete</a>
          		<a href="<%= request.getContextPath()%>/emp/update/<%=EmpDetail.getId()%>">Edit</a>
          	</td>	
        </tr>
        <% } %>
    </table>
	 
	
</body>
</html>