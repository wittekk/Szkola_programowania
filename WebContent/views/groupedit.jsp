<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GroupEdit</title>
</head>
<body>

	<div class="beforeEdit">
		<b>Group id: </b> ${grouptoedit.id}</br>		
		<b>Group name: </b>${grouptoedit.name}</br>
		<b>Group: </b>
	</div>
	<div class="formdiv">
		<form method="POST" action='./groupedit'>			 
			<input name="groupname" type="TEXT" placeholder="new group name"
				onfocus="this.placeholder=''; this.value='${grouptoedit.name}'" onblur="this.placeholder='new username'" /></br>						
			<input type="SUBMIT" value="Edit"/>
		</form>
	</div>

</body>
</html>