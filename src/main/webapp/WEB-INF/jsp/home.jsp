<%@page import="com.att.onlinestore.util.ProductUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Store</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/util.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">

</head>
<body>
	<font color="red">${errorMessage}</font>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">

				<form id="productForm" accept-charset=utf-8 method=post action="/add" ENCTYPE="multipart/form-data">
					<label for="id" style="margin-bottom: 5px;">Product ID:</label>
					<%
						String pid = ProductUtil.getUniqueIdForProduct();
					%>
					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="text" name="id" value=<%=pid%>>
					</div>

					<label for="name" style="margin-bottom: 5px;">Product
						Name:</label>
					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="text" id="name" name="name"
							placeholder="Enter Product Name" required>
					</div>

					<label for="name" style="margin-bottom: 5px;">Product
						Description:</label>
					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="text" id="name" name="descr"
							placeholder="Enter Product Description" required>
					</div>

					<label for="name" style="margin-bottom: 5px;">Product Image</label>
					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="file" id="url" name="url" required>
					</div>
					<br>
					<div class="container-login100-form-btn m-t-17">
						<input type="submit" class="login100-form-btn" value="Add Product">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>