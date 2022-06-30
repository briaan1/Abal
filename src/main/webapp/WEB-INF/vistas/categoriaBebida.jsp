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
    <c:forEach var="lista" items="${listaDeFavoritos}">
    <div class="card-group col-3 mb-3">
        	<div class="card h-100">
          		<img class="card-img-top" src="img/bebida/${lista.imagen}" alt="Imagen de bebida">
          		
          		<div class="card-body">
            		<h5 class="card-title">${lista.nombre}</h5>
            		<h5>$${lista.precio}</h5>
            		<p class="card-text">${lista.descripcion}</p>
            		
            		<div class="input-group" >
              			<input type="number" class="form-control text-center" value="0" style="width:80px;">
              			<div class="input-group-append">
                			<span class="input-group-text">Cantidad</span>
              			</div>
            		</div>
            
            		<div class="card-footer mt-3 text-center">
              			<button type="submit" class="btn btn-danger btn-sm text-center" form="form-favorito" value="${lista.id}" name="idFavorito" style="width: 100px;">${eliminarDeFavoritos}</button>
              
              			<button type="button" class="btn btn-primary btn-sm"><img src="img/shopping-cart.png" class="px-1 py-1"></button>
            		</div>
         	 	</div>
        	</div>
      	</div>
	</c:forEach>
    
    
      <c:forEach var="lista" items="${listaDeProductos}">
      
    	<div class="card-group col-3 mb-3">
        	<div class="card h-100">
          		<img class="card-img-top" src="img/bebida/${lista.imagen}" alt="Imagen de bebida">
          		
          		<div class="card-body">
            		<h5 class="card-title">${lista.nombre}</h5>
            		<h5>$${lista.precio}</h5>
            		<p class="card-text" style="height:80px;">${lista.descripcion}</p>
            		
            		<div class="input-group" >
              			<input type="number" class="form-control text-center" value="0" style="width:80px;">
              			<div class="input-group-append">
                			<span class="input-group-text">Cantidad</span>
              			</div>
            		</div>
            
            		<div class="card-footer mt-3 text-center">
              			<button type="submit" class="btn btn-danger btn-sm text-center" form="form-favorito" value="${lista.id}" name="idFavorito"><img src="img/favorite.png" class="px-1 py-1"></button>
              
              			<button type="button" class="btn btn-primary btn-sm"><img src="img/shopping-cart.png" class="px-1 py-1"></button>
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