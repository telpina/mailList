<%@page import="ru.unlimit.DBService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="java.util.*" 
import  = "java.sql.*"
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show table with emails</title>
</head>
<body>
<table border="1">
<tr>
<td>Name:</td>
<td>Last name:</td>
<td>Email:</td>
</tr>
 <%
 try {
	 Connection con = DBService.getConnection();
	 PreparedStatement statement = con.prepareStatement("SELECT * FROM testtaskadress");
	 ResultSet result = statement.executeQuery();
	 while(result.next()) {%>
	<tr>
	<td> 
	 <%
	 out.println(result.getString("firstname"));
	 %>
	 </td>
	 
	 <td> 
	 <%
	 out.println(result.getString("lastname"));
	 %>
	 </td>	 
	 <td> 
	 <%
	 out.println(result.getString("email"));
	 %>
	 </td>	 
	 </tr>
	 <%		 
	 }
	 con.close();
	 statement.close();
 		}catch(Exception e) {System.out.println(e);}
	finally{}
%>
</table>
<a href="/TestTaskMicrofocus/index.html">Page back</a>
</body>
</html>