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

	<form method="POST" action='./useradd'>
		
		<input name="username" type="TEXT" placeholder="username"
			onfocus="this.placeholder=''" onblur="this.placeholder='username'" /></br>
		<input name="email" type="TEXT" placeholder="email"
			onfocus="this.placeholder=''" onblur="this.placeholder='email'" /></br>
		<input name="password" type="PASSWORD" placeholder="password"
			onfocus="this.placeholder=''" onblur="this.placeholder='password'" /></br>
		
		Wybierz grupę do której przydzielić usera: <select required id="gruopId" name="groupIdjsp">
       		<c:forEach items="${groupsAll}" var="groupx">
       			<option value="${groupx.id}">${groupx.name}</option>
       		</c:forEach>
		</select>
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