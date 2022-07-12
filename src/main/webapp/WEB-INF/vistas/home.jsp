<%@include file="header.jsp"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!-- Carousel -->
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="img/img-pizza-principal.jpg" alt="First slide" style="height:500px;">
      <div class="carousel-caption d-none d-md-block">
	    	<h1 style="font-family: 'Yellowtail', cursive;padding-bottom:20%;text-shadow: 4px 4px 2px rgba(0,0,0,0.6);font-size:3rem;">Descubr� las mejores pizzas ac�</h1>
  	  </div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/img-slider-2.jpg" alt="Second slide" style="height:500px;">
      <div class="carousel-caption d-none d-md-block">
	    	<!-- <h1 style="font-family: 'Dancing Script', cursive;background-color: black;color:white;width:46%;">La especialidad de la casa...</h1>-->
  	  </div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/img-slider-3.jpg" alt="Third slide" style="height:500px;">
      <div class="carousel-caption d-none d-md-block">
	    	<!-- <h1 style="font-family: 'Dancing Script', cursive;background-color: black;color:white;width:75%;">Porque no queremos que nadie se quede afuera...</h1> -->
  	  </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>


<div class="container">
<h2 class="titulo">Encontr� lo que mejor se adapte a vos</h2>
<h3 class="subtitulo">Nuestras categor�as</h3>
<p class="img-separador"><img src="img/rolling-pin.png" alt=""></p>
  <div class="row">
    <div class="col-sm">
      <div class="card" style="width: 18rem;">
	      <a href="/pizza" class="text-center text-decoration-none text-dark">
		  		<img class="card-img-top" src="img/pizza.jpg" alt="Card image cap">
		  		<div class="card-body">
					<h5 class="card-title">Pizzas</h5>
					<p class="categoria-p">Ver mas</p>
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
    <p class="categoria-p">Ver mas</p>
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
    <p class="categoria-p">Ver mas</p>
  </div>
  </a>
</div>
    </div>
  </div>
</div>

<!-- Desde el HttpSession
<h1>Contador: ${contadorPrueba}</h1> -->

<div class="div-frase">
<h4>Nos encanta que seas parte de nosotros...</h4>
<p>-Pizzer�a Abal</p></div>

<div class="container mt-4">
<h2 class="titulo">Comentarios</h2>
<h3 class="subtitulo">Opiniones de nuestros clientes</h3>
<p class="img-separador"><img src="img/rolling-pin.png" alt=""></p>

<section id="testimonial_area" class="section_padding">
	<div class="container">
     	<div class="row">
        	<div class="col-md-12">
            	<div class="testmonial_slider_area text-center owl-carousel">
                	<c:forEach var="lista" items="${listaDeComentarios}">
                    	<div class="box-area">	
                        	<div class="img-area">
                                <img src="img/user-image.png" alt="">
                            </div>	
                            <h5>Person's name</h5>
                            <span>Cliente</span>									
                            <p class="content">
                                ${lista.comentario}
                    		</p>
                        </div> 
 					</c:forEach>
 				</div>
 			</div>
		</div>
	</div>
</section>

</div>


<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
<%@include file="footer.jsp"%>