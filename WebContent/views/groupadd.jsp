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

	<form method="POST" action='./groupadd'>		
		<input name="name" type="TEXT" placeholder="name"
			onfocus="this.placeholder=''" onblur="this.placeholder='name'" /></br>
		<input type="SUBMIT" value="Add"/>		
	</form>
	<h3>Dostępne grupy:</h3>
	<table>
		<thead>
			<tr>
				<td><strong>id:</strong></td>
				<td><strong>Name:</strong></td>								
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${groupsAll}" var="groupx">
				<tr>
					<td>${groupx.id}</td>
					<td>${groupx.name}</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>