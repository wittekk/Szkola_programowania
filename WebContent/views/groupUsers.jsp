<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista grup.</title>
</head>
<body>
<%@ include file="header.jsp"%>
<h3>Lista użytkowników grupy Wit : ${groupName}</h3>


<c:if test="${not empty groupusers}">
<table border=2>
	<tr>
		<th>Nazwa</th>
	    	<th>Akcja</th>
	</tr>
	<c:forEach items="${groupusers}" var="gusers">
		<tr> 
			<td>${gusers.username}</td>
    			<td><a href="userdetail?userId=${gusers.id}">Szczegóły</a>
    			<%-- <td><a href="'<c:url>/Solution?id=${sulution.id}</c:url>'">Szczegóły</a> --%>
    		</tr>
	</c:forEach>
</table>
</c:if>

<c:if test="${empty groupusers}">
	<p>Brak danych do wyświetlenia. :-(</p>
</c:if>

</body>
</html>