<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminPan</title>
</head>
<body>

<%@ include file="header.jsp"%>

<h1>Panel administracyjny</h1>

<h2>Grupy</h2>
<h3><a href="./groupadd" class="add">Add new group</a></h3>
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
					<td><a href="groupedit?id=${groupx.id}"><span class="edit">edit</span></a></td>
					<td><a href="groupdelete?id=${groupx.id}"><span class="delete">delete</span></a></td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<h2>Użytownicy</h2>
<h3><a href="./useradd" class="add">Add new user</a></h3>
	<table>
		<thead>
			<tr>
				<td><strong>id:</strong></td>
				<td><strong>username:</strong></td>
				<td><strong>email:</strong></td>
				<td><strong>password:</strong></td>
				<td><strong>salt:</strong></td>
			 	<td><strong>nr grupy:</strong></td>								
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usersAll}" var="userx">
				<tr>
					<td>${userx.id}</td>
					<td>${userx.username}</td>
					<td>${userx.email}</td>
					<td>${userx.password}</td>
					<td>${userx.salt}</td>				
		 			<td>${userx.person_group_id}</td>  	
		  							
					<td><a href="useredit?id=${userx.id}"><span class="edit">edit</span></a></td>
					<td><a href="userdelete?id=${userx.id}"><span class="delete">delete</span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<h2>Zadania - Exercises</h2>
<h3><a href="./exerciseadd" class="add">Add new exercise</a></h3>
	<table>
		<thead>
			<tr>
				<td><strong>id:</strong></td>
				<td><strong>title:</strong></td>
				<td><strong>description:</strong></td>							
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${exerciseAll}" var="exercisex">
				<tr>
					<td>${exercisex.id}</td>
					<td>${exercisex.title}</td>
					<td>${exercisex.description}</td>			
					<td><a href="exerciseedit?id=${exercisex.id}"><span class="edit">edit</span></a></td>
					<td><a href="exercisedelete?id=${exercisex.id}"><span class="delete">delete</span></a></td>
					<td><a href="solutionadd?id=${exercisex.id}"><span class="addsolution">add solution</span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>