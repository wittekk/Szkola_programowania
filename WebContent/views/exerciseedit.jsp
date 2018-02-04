<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ExerciseEdit</title>
</head>
<body>

	<div class="beforeEdit">
		<b>Exercise id: </b> ${exercisetoedit.id}</br>		
		<b>Exercise title: </b>${exercisetoedit.title}</br>
		<b>Exercise description: </b>${exercisetoedit.description}</br>
		<b>Exercise: </b>
	</div>
	<div class="formdiv">
		<form method="POST" action='./exerciseedit'>			 
			<input name="exercisetitle" type="TEXT" placeholder="new exercise title"
				onfocus="this.placeholder=''; this.value='${exercisetoedit.title}'" onblur="this.placeholder='new exercise title'" /></br>
			<input name="exercisedescription" type="TEXT" placeholder="new exercise description"
				onfocus="this.placeholder=''; this.value='${exercisetoedit.description}'" onblur="this.placeholder='new exercise description'" /></br>						
			<input type="SUBMIT" value="Edit"/>
		</form>
	</div>

</body>
</html>