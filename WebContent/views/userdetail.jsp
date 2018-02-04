<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Szczegóły użytkownika: ${userx.username}</h3>
<p>Nazwa: ${userx.username}</p>
<p>Email: ${userx.email}</p>

<br><h3>Dodane rozwiązania</h3>

<c:if test="${not empty solview}">
<table border=2>
	<tr>
		<th>Tytuł zadania</th>
	    	<th>Data dodania</th>
	    	<th>Szczegóły</th>
	</tr>
	<c:forEach items="${solview}" var="solution">
		<tr>
			<td>${solution.exercise.title}</td>
   			<td>${solution.created}</td>
   			<td><a href="ShowSolution?id=${solution.id}">Szczegóły</a>
   			<%-- <td><a href="'<c:url>/Solution?id=${sulution.id}</c:url>'">Szczegóły</a> --%>
    	</tr>
	</c:forEach>
</table>
</c:if>

<c:if test="${empty solview}">
	<p>Brak rozwiązań do wyświetlenia. :-(</p>
</c:if>

<c:if test="${not empty solview}">
	${solution.description}
</c:if>

<c:if test="${empty solview}">
	<p>Pusty opis rozwiązania</p>
</c:if>

</body>
</html>