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
	      <img src="img/clasica.jpg" class="card-img-top" alt="...">
	      <div class="card-body">
	        <h5 class="card-title">${lista.nombre}</h5>
	        <p class="card-text">${lista.descripcion}</p>
	      </div>
	    </div>
	  </div>
	  </c:forEach>
	</div>

</div>


<%@include file="footer.jsp"%>

