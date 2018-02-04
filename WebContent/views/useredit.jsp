<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Useredit</title>
</head>
<body>

	<div class="beforeEdit">
		<b>User id: </b> ${usertoedit.id}</br>
		<b>Email: </b>${usertoedit.email}</br> 
		<b>Username: </b>${usertoedit.username}</br>
		<b>Group: </b>
	</div>
	<div class="formdiv">
		<form method="POST" action='./useredit'>			 
			<input name="username" type="TEXT" placeholder="new username"
				onfocus="this.placeholder=''; this.value='${usertoedit.username}'" onblur="this.placeholder='new username'" /></br>
			<input name="email" type="TEXT" value="" placeholder="new email"
				onfocus="this.placeholder=''; this.value='${usertoedit.email}'" onblur="this.placeholder='new email'" /></br>
			<input name="password" type="PASSWORD" placeholder="new password"
				onfocus="this.placeholder=''" onblur="this.placeholder='new password'" /></br>			
			<input type="SUBMIT" value="Edit"/>
		</form>
	</div>

</body>
</html>