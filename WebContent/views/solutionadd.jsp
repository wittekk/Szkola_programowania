<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>solution-add</title>
</head>
<body>

<h3>Grupa coby dodać do niej solution : ${exercisetoaddsolution}</h3>

	<form method="POST" action='./solutionadd'>
		
		<input name="description" type="TEXT" placeholder="description"
			onfocus="this.placeholder=''" onblur="this.placeholder='description'" /></br>
		<label>solution użytkownika:
			<select name="selecteduser">
			<optgroup label="all - users">			
				<c:forEach items="${usersAll}" var="userx">
					<option value="${userx.id}">${userx.username}</option>
				</c:forEach>			
			</optgroup>
			</select>
		</label>		
		<input type="SUBMIT" value="Add"/>
	</form>
	
</body>
</html>