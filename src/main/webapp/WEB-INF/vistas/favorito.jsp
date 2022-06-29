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
			<div class="col-lg-3 col-md-4 mb-4">
				<div class="card">
					<img class="card-img-top" src="img/${lista.categoria.nombre}/${lista.imagen}" alt="Card image cap">
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
							<c:choose>
								<c:when test="${not empty eliminarDeFavoritos}">
									<button type="submit" class="btn btn-light float-left" form="form-favorito" value="${lista.id}" name="idFavorito" style="width: 100px;">${eliminarDeFavoritos}</button>
								</c:when>
							</c:choose>


							<button type="button" class="btn btn-primary float-right" style="width: 90px;">Agregar al carrito</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<form action="/eliminar-favorito" id="form-favorito" method="POST"></form>
	</div>
</div>


<%@include file="footer.jsp"%>

