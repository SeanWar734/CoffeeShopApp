<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/cerulean/bootstrap.min.css" rel="stylesheet" integrity="sha384-LV/SIoc08vbV9CCeAwiz7RJZMI5YntsH8rGov0Y2nysmepqMWVvJqds6y0RaxIXT" crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" /> 

<head>
<meta charset="ISO-8859-1">
<title>Add item</title>
</head>
<body>
	<main class="container">
		<h1>New Item</h1>

		<!-- A form without an action submits back to the same URL, which is what we want here. -->
		<form action="/product/add" method="post">
			<!-- We need to keep the ID and submit it with the form, but we don't want the user to have to see it. -->
			<input type="hidden" name="id" value="${product.id}" />
			
			
			<div class="form-group">
				<label for="name">Name</label>
				<input class="form-control" id="name" name="name" placeholder="Name" required minlength="2" autocomplete="off">
			</div>
			
			
			<div class="form-group">
				<label for="description">Description</label> 
				<input class="form-control" id="description" name="description" placeholder="Description" required>
			</div>
			
			
			<div class="form-group">
				<label for="price">Price</label> 
				<input class="form-control" id="price" name="price" placeholder="Price" required>
			</div>
			
			
			<div class="form-group">
				<label for="quantity">Quantity</label> 
				<input class="form-control" id="quantity" name="quantity" placeholder="Quantity" required>
			</div>
			
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/admin" class="btn btn-link">Cancel</a>
		</form>
	</main>
</body>
</html>