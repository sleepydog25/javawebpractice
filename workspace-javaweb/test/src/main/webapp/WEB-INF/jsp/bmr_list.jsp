<%@ page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- handling data here with java,recieving data from BMRServlet-->
<%
 List<Map<String, Object>>bmrList = (List)request.getAttribute("bmrList");
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
<link rel="stylesheet" href="./../css/buttons.css"> 
<title>BMR LIST</title>
</head>
<body style="padding: 15px">
<!-- Bmr list: <%=request.getAttribute("bmrList") %> -->
<h2> 
	BMR List:
</h2>
    <table class="pure-table pure-table-bordered">
    <thead> 
    <tr>
     <th>Id</th><th>Name</th><th>height</th><th>Weight</th><th>Age</th><th>sex</th><th>BMR</th><th>Delete</th>
    </tr>
    </thead>
    <tbody>
    

    	    <%for (int i=0; i<bmrList.size();i++){ %>
    	    
    	<tr>
    	<%Map<String, Object> map = bmrList.get(i); %>
    	<td><%=i %>
    		<td><%=map.get("name") %></td>
    		<td><%=map.get("height") %></td>
    		<td><%=map.get("weight") %></td>
    		<td><%= map.get("Age") %></td>
    		<td><%=map.get("Sex") %></td>
    		<td><%=map.get("bmr") %></td>
    		<td><a href="/test/servlet/bmr?deleteId=<%=i %>" class="button-error pure button">Delete</a></td>
    	</tr>
    	<%} %>
    	</tbody>
    </table>
    
</body>
</html>