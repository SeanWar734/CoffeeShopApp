<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/cerulean/bootstrap.min.css" rel="stylesheet" integrity="sha384-LV/SIoc08vbV9CCeAwiz7RJZMI5YntsH8rGov0Y2nysmepqMWVvJqds6y0RaxIXT" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<div class=container>
		<h1>Welcome to the Coffee Shop</h1>
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
						<td><a href="/product/update?id=${product.id}">Edit</a></td>
						<td><a href="/product/delete?id=${product.id}">Delete</a></td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/addItem" class="btn btn-secondary">Add Item</a>
		<a href="/" class="btn btn-secondary">Quit Out of Admin</a>
	</div>
</body>
</html>