<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/cerulean/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-LV/SIoc08vbV9CCeAwiz7RJZMI5YntsH8rGov0Y2nysmepqMWVvJqds6y0RaxIXT"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

<head>
<meta charset="ISO-8859-1">
<title>Add New User</title>
</head>
<body>
	<h1></h1>
	<form action="/confirm">
		<fieldset>
			<legend>Contact Information</legend>
			<p class="display">
				First Name: <input type="text" name="first_name"
					pattern="[A-Z][a-z]+" required minlength="2" maxlength="18" />
			</p>
			<p class="display">
				Last Name: <input type="text" name="last_name" pattern="[A-Z][a-z]+"
					required minlength="2" maxlength="18" />
			</p>
			<p class="display">
				Email: <input type="email" name="email" />
			</p>
			<p class="display">
				Phone Number: <input type="text" name="phone_number" />
			</p>
			<p class="display">
				Password: <input type="password" name="password" />
			</p>
		</fieldset>
		<button type="submit">Submit</button>
	</form>
</body>
</html>