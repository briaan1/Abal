<%@include file="header.jsp"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div class="container">
		<h1 class="text-center m-4" >Bienvenidos a Pizzeria ABAL</h1>
  <div class="row">
    <div class="col-sm">
      <div class="card" style="width: 18rem;">
      <a href="/pizza" class="text-center text-decoration-none text-dark">
  <img class="card-img-top" src="img/pizza.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">PIZZA</h5>
  </div>
  </a>
			</div>
    </div>
    <div class="col-sm">
      <div class="card" style="width: 18rem;">
      <a href="/categoriaCombos" class="text-center text-decoration-none text-dark">
  <img class="card-img-top" src="img/combos.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">COMBOS</h5>
  </div>
  </a>
</div>
		</div>
    <div class="col-sm">
      <div class="card" style="width: 18rem;">
      <a href="/personalizar-pizza" class="text-center text-decoration-none text-dark">
  <img class="card-img-top" src="img/personalizada.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">PERSONALIZADAS</h5>
  </div>
  </a>
</div>
    </div>
  </div>
</div>

<br>
<div class="container mt-4">
<h2 class="mb-4">Comentarios</h2>
<ul class="list-unstyled">
<c:forEach var="lista" items="${listaDeComentarios}">
  <li class="media">
    <img class="mr-3" src="img/usuario.jpg" alt="Generic placeholder image" style="width:100px">
    <div class="media-body">
      <h5 class="mt-0 mb-1">
      ${lista.comentario}
      </h5>
    </div>
  </li>
   </c:forEach>
</ul>
</div>

<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
<%@include file="footer.jsp"%>
