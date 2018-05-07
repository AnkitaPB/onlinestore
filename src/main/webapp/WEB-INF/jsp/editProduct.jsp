<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
<title>Online Store</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/util.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
	<div align="center"><b>Edit Product</b></div><br>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">

				<Form method="get" accept-charset=utf-8 action="/updateProduct">

					<label for="id" style="margin-bottom: 5px;">Product Id:</label>
					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="text" id="name" name="id"
							value=<%=request.getAttribute("id")%>>
					</div>

					<label for="name" style="margin-bottom: 5px;">Product Name:</label>
					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="text" id="name" name="pname"
							placeholder="Enter Product Name"required %>
					</div>



					<label for="descr" style="margin-bottom: 5px;">Product Description:</label>
					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="text" id="descr" name="descr"
							placeholder="Enter Product Description"required %>
					</div>

					<label for="name" style="margin-bottom: 5px;">Image url</label>
					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="file" id="url" name="url" required>
					</div>
					<br>
					<div class="container-login100-form-btn m-t-17">
						<input type="submit" class="login100-form-btn" value="Update Product">
					</div>

				</Form>
			</div>
		</div>
	</div>
</body>
</html>




