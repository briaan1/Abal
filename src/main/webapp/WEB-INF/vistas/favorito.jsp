<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-5 mb-5">
	<h2 class="h2-titulo">Mis Favoritos</h2>
	
	<c:choose>
<c:when test="${not empty msg}">
     <div class="alert alert-primary"><h4>${msg}</h4></div>
</c:when>
</c:choose>

	<div class="row row-cols-1 row-cols-md-3 mt-5 w-75">
	<c:forEach var="lista" items="${listaDeFavoritos}">
	  <div class="col mb-4">
	    <div class="card h-100">
	      <img src="img/pizza/${lista.imagen}" class="card-img-top" alt="${lista.nombre}">
	      <div class="card-body">
	        <h5 class="card-title">${lista.nombre}</h5>
	        <p class="card-text">${lista.descripcion}</p>
	        <button type="submit" class="btn btn-light float-left" form="form-favorito" value="${lista.id}" name="idFavorito" style="width: 100px;">${eliminarDeFavoritos}</button>
	      </div>
	    </div>
	  </div>
	  </c:forEach>
	  <form action="/eliminar-favorito" id="form-favorito" method="POST">
	</div>
</div>


<%@include file="footer.jsp"%>

