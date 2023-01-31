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


<%--  	<table align="center">
	<thead>	
	<tr>
	<th>Id</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>City</th>
	</tr>
	</thead>
	<tbody>

	<c:forEach items="${EmpList}" var="emp">
	<tr>
	<td><c:out value = "${emp.id}"/></td>
	<td><c:out value = "${emp.fname}"/></td>
	<td><c:out value = "${emp.lname}"/></td>
	<td><c:out value = "${emp.city}"/></td>

	</tr>
	</c:forEach>
	</tbody>
	</table>
	 --%>
	
 	<table border=2 align="center">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <% for (EmpDetail EmpDetail :(List<EmpDetail>)request.getAttribute("EmpList")) { %>
        <tr width="42" height="42">
            <td><%= EmpDetail.getId() %></td>
            <td><%= EmpDetail.getFname() %></td>
            <td><%= EmpDetail.getLname() %></td>
          	<td><%= EmpDetail.getCity() %></td>
        </tr>
        <% } %>
    </table>
	 
	
</body>
</html>