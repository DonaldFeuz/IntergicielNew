<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Transaction Form by MA</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<input type = "hidden" id="status" value="<%=request.getAttribute("status")%>">


	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Transaction</h2>
					
						<form method="post" action="transaction" class="register-form"
							id="register-form">
							
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="emetteur" id="emetteur" placeholder="Emetteur" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="recepteur" id="recepteur" placeholder="recepteur" />
							</div>
							<div class="form-group">
								<label for="name">
									</label> <input
									type="text" name="montant" id="montant" placeholder="montant" />
							</div>
							<div class="form-group">
								<label for="name">
									</label> <input
									type="text" name="devise" id="devise" placeholder="devise" />
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="envoyer" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">

var status = document.getElementById("status").value;
if(status == "success"){
	swal("Congrats", "transaction Created Successfully", "success");
}
</script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>