<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/home.css" rel="stylesheet" >
	</head>
	<body>
		<div class = "container">
			<h1>Bienvenidos a Pizzeria ABAL</h1>
		<div class="imagenes">
			<div class="img-pizza">
				<a href="#"> <img src="img/clasica" class="rounded float-start"
					alt="...">
				</a>
				<h2>CLASICAS</h2>
			</div>
			<div class="img-pizza">
				<a href="#"> <img src="img/combos.jpg" class="rounded float-end">
				</a>
				<h2>COMBOS</h2>
			</div>
			<div class="img-pizza">
				<a href="#"> <img src="img/personalizada.jpg"
					class="rounded float-end" alt="...">
				</a>
				<h2>PERSONALIZADAS</h2>
			</div>
		</div>
		<!-- <div class="texto-pizza">
				<h2>CLASICAS</h2>
				<h2>COMBOS</h2>
				<h2>PERSONALIZADAS</h2>
			</div>	-->			
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
<%@include file="footer.jsp"%>