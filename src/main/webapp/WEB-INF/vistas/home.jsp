<%@include file="header.jsp"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="inicio">
	<h1>Pizzería Abal</h1>
	<h4>Las mejores pizzas</h4>
</div>

<div class="container">
<h2 class="titulo">Encontrá lo que mejor se adapte a vos</h2>
<h3 class="subtitulo">Nuestras categorías</h3>
  <div class="row">
    <div class="col-sm">
      <div class="card" style="width: 18rem;">
	      <a href="/pizza" class="text-center text-decoration-none text-dark">
		  		<img class="card-img-top" src="img/pizza-cat.jpg" alt="Card image cap">
		  		<div class="card-body">
					<h5 class="card-title">Pizzas</h5>
		  		</div>
	  		</a>
	 </div>
    </div>
    <div class="col-sm">
      <div class="card" style="width: 18rem;">
      <a href="/categoriaCombos" class="text-center text-decoration-none text-dark">
  <img class="card-img-top" src="img/combos.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Combos</h5>
  </div>
  </a>
</div>
		</div>
    <div class="col-sm">
      <div class="card" style="width: 18rem;">
      <a href="/personalizar-pizza" class="text-center text-decoration-none text-dark">
  <img class="card-img-top" src="img/personalizada.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Personalizadas</h5>
  </div>
  </a>
</div>
    </div>
  </div>
</div>

<div class="container mt-4">
<h2 class="titulo">Comentarios</h2>
<h3 class="subtitulo">Opiniones de nuestros clientes</h3>
<c:forEach var="lista" items="${listaDeComentarios}">
<div class="card mb-3 mx-auto" style="width: 60%;">
  <div class="row">
    <div class="col-md-2">
    	<img class="img-fluid rounded-start" src="img/user-image.png" alt="Imagen de perfil usuario" style="width:80px; height:80px;">
    </div>
    <div class="col-md-10">
      <div class="card-body  text-left">
        <p class="card-text">${lista.comentario}</p>
      </div>
    </div>
  </div>
</div>
</c:forEach>
</div>

<div id="nosotros" class="container">
	<h2 class="titulo">Sobre nosotros</h2>
	<h3 class="subtitulo">Nuestra historia</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sagittis dui in lorem rutrum, id luctus nibh congue. Integer 		facilisis libero turpis, ut dignissim quam semper eu. Quisque lacus tortor, gravida quis ante nec, maximus accumsan justo. 		Suspendisse luctus sem eget dui auctor finibus. Cras accumsan libero ut velit auctor, ut eleifend mi tristique. Nullam sit amet 		auctor ex. Duis gravida sagittis nisl ut dictum. Maecenas scelerisque aliquam volutpat. Nulla ac vulputate elit. Donec auctor 		varius orci a bibendum. Praesent commodo augue nec tellus hendrerit, vitae iaculis dolor ornare. Integer in lacus sagittis justo 		ornare pretium. Maecenas at accumsan purus. Aenean rhoncus urna vitae convallis consequat. Nunc eget lectus mauris.
		<br><br>
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sagittis dui in lorem rutrum, id luctus nibh congue. Integer 		facilisis libero turpis, ut dignissim quam semper eu. Quisque lacus tortor, gravida quis ante nec, maximus accumsan justo. 		Suspendisse luctus sem eget dui auctor finibus. Cras accumsan libero ut velit auctor, ut eleifend mi tristique. Nullam sit amet 		auctor ex. Duis gravida sagittis nisl ut dictum. Maecenas scelerisque aliquam volutpat. Nulla ac vulputate elit. Donec auctor 		varius orci a bibendum. Praesent commodo augue nec tellus hendrerit, vitae iaculis dolor ornare. Integer in lacus sagittis justo 		ornare pretium. Maecenas at accumsan purus. Aenean rhoncus urna vitae convallis consequat. Nunc eget lectus mauris.
	</p>
</div>

<div id="contacto" class="container">
	<h2 class="titulo">Contacto</h2>
	
	<!-- style="width:100px" -->
	
	<div class="contenedor-redes">
		<div>
		<h3 class="subtitulo">Encontranos en:</h3>
			<p>
	 			<a href="https://www.instagram.com"><img class="mr-3" src="img/instagram.png" alt="Logo de aplicacion instagram" 				style="width:75px;height:75px" target="_blank">Nuestro Instagram</a>
	 		</p>
	 		<p>
	 			<a href="https://www.google.com/intl/es/gmail/about/"><img class="mr-3" src="img/email.png" alt="Logo de email" 				style="width:75px;height:75px" target="_blank">Correo electrónico</a>
	 		</p>
		</div>
		<div>
		<h3 class="subtitulo">Y también en...</h3>
			<p>
	 			<a href="https://www.google.com/maps"><img class="mr-3" src="img/location.png" alt="Simbolo de ubicacion" 				style="width:75px;height:75px" target="_blank">Nuestros locales</a>
	 		</p>
		</div>
	</div>

</div>
<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
<%@include file="footer.jsp"%>