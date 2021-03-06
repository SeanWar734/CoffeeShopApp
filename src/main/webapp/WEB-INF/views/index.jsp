<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/cerulean/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-LV/SIoc08vbV9CCeAwiz7RJZMI5YntsH8rGov0Y2nysmepqMWVvJqds6y0RaxIXT"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

<head>
<meta charset="ISO-8859-1">
<title>Welcome to the Coffee Shop</title>
</head>
<body>
	<div class=container>
		<h1>Welcome to the Coffee Shop</h1>
		<c:if test="${preference ne null}">
			<h1>Current Favorite is ${preference.getName()}</h1>
		</c:if>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>

						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td>${product.quantity}</td>
						<td><form action="" method="post">
								<input type="hidden" name="preference" value=${product}>
								<input type="hidden" name="name" value=${product.name}>
								<input type="hidden" name="description" value=${product.description}> 
								<input type="hidden" name="price" value=${product.price}> 
								<input type="hidden" name="quantity" value=${product.quantity}>
								<button type="submit">This is the BEST</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<form action="/add">
			<button type="submit" class="btn btn-secondary">Create Account</button>
		</form>
		
		<form action="/admin">
			<button type="submit" class="btn btn-secondary">Admin Page</button>
		</form>
		
		<form action="/clear" method="post">
			<input type="hidden" name="preference" value=${preference}>
			<button type="submit" class="btn btn-secondary">Clear Favorite</button>
		</form>
		
	</div>
</body>
</html>