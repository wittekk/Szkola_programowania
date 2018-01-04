<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Groups</title>
</head>
<body>

<%@ include file="header.jsp"%>

<h1>Grupy Witka</h1>

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