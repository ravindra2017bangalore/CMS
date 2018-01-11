<%@page import="complaint.ComplainGetSet"%>
<%@page import="java.util.List"%>
<%@page import="complaint.ComplaintDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>View Complaints</title>
</head>
<body>
<h1>Complaint List</h1>  
<%  
List<ComplainGetSet> list=ComplaintDao.getAllRecordsforOth();  
request.setAttribute("list",list);  
%>  

<table class="table" border="1">
<thead>  
<tr><th>Complaint Id</th><th>Complaint Type</th><th>Name</th><th>Mobile</th>  
<th>Full View Complaint</th><th>Delete</th><th>Allot</th></tr> </thead> 
<c:forEach items="${list}" var="u">  
<tr class="active"><td>${u.getComplaintId()}</td><td>${u.getComplaintType()}</td><td>${u.getName()}</td>  
<td>${u.getMobile()}</td>
<td><a href="viewfullcomplaint.jsp?id=${u.getComplaintId()}">View</a></td>  
<td><a href="deleteuser.jsp?id=${u.getComplaintId()}">Delete</a></td> 
<td><a href="deleteuser.jsp?id=${u.getComplaintId()}">Allot</a></td></tr>  
</c:forEach>  
</table>  
</body>
</html>