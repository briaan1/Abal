
<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class = "container"><br>
  <div class="modal-body">
    <h1>${titulo}</h1><br>

<c:choose>
<c:when test="${not empty msg}">
     <div class="alert alert-primary"><h4>${msg}</h4></div>
</c:when>
</c:choose>
    
    <div class="row mb-5">
      <c:forEach var="lista" items="${listaDeProductos}">
    <div class="col-lg-3 col-md-4 mb-4">
        <div class="card">
          <img class="card-img-top" src="img/pizza/${lista.imagen}" alt="Card image cap">
          <div class="card-body">
            <h5 class="card-title">${lista.nombre}</h5>
            <h5>$${lista.precio}</h5>
            <p class="card-text">${lista.descripcion}</p>
            <div class="input-group" style="width:200px;">
              <input type="number" class="form-control text-center" value="1">
              <div class="input-group-append">
                <span class="input-group-text">Cantidad</span>
              </div>
            </div>
            <div class="mt-4 overflow-auto p-1">
              <button type="submit" class="btn btn-light float-left" form="form-favorito" value="${lista.id}" name="idFavorito" style="width: 100px;">Agregar a favoritos</button>
              <button type="button" class="btn btn-primary float-right" style="width: 90px;">Agregar al carrito</button>
            </div>
          </div>
        </div>
      </div>
</c:forEach>
<form action="/agregar-favorito" id="form-favorito" method="POST">
	
</form>
    </div>
    
    
  </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>

<%@include file="footer.jsp"%>