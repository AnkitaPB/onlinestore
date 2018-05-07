<!DOCTYPE html>
<html lang="en">
<head>
	<title>Online Store</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="resources/css/util.css" >
	<link rel="stylesheet" type="text/css" href="resources/css/main.css" media="screen">
</head>
<body>

	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<form  method="post">
					<span class="login100-form-title p-b-51">
						Login
					</span>

				   <font color="red" >${errorMessage}</font> 
					<br>
					<div class="wrap-input100 validate-input m-b-16" >
						<input class="input100" type="text" name="name" placeholder="Username" required>
						</div>
					
					
					<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="password" name="password" placeholder="Password" required>
						
					</div>
					
					
					<br>
					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn">
							Login
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	

	
</body>
</html>