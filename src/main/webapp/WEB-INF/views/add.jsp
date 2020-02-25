<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New User</title>
</head>
<body>
	<h1></h1>
	<form method="post" action="/confirm">
		<fieldset>
			<legend>Contact Information</legend>
			<p>
				First Name: <input type="text" name="first_name" pattern="[A-Z][a-z]+"
					required minlength="2" maxlength="18" />
			</p>
			<p>
				Last Name: <input type="text" name="last_name" pattern="[A-Z][a-z]+"
					required minlength="2" maxlength="18" />
			</p>
			<p>
				Email: <input type="email" name="email" />
			</p>
			<p>
				Phone Number: <input type="number" name="phone-number" />
			</p>
			<p>
				Password: <input type="password" name="password" />
			</p>
		</fieldset>
		<button type="submit">Submit</button>
	</form>
</body>
</html>