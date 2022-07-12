<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<div class="modal-body"></div>
	
	<h1 class="my-4">Mis favoritos</h1>
  
	<c:choose>
<c:when test="${not empty msg}">
     <div class="alert alert-primary"><h4>${msg}</h4></div>
</c:when>
</c:choose>

	 <div class="row row-cols-1 row-cols-md-3 g-4">
		 <c:forEach var="lista" items="${listaDeFavoritos}" varStatus="listaIndex">
			<div class="card-group col-3 mb-3">
				<div class="card h-100">
					<img class="card-img-top" src="img/${lista.categoria.nombre}/${lista.imagen}" alt="Imagen de producto" style="height:180px">
					<div class="card-body">
						<h5 class="card-title">${lista.nombre}</h5>
						<h5>$${lista.precio}</h5>
						<p class="card-text" style="height:80px;">${lista.descripcion}</p>
						
						<div class="input-group">
							<form action="/agregar-carrito-cate-favorito" id="form-carrito-favoritos${listaIndex.index}" method="POST" >
								<input type="number" class="form-control text-center"  value="1"   name="cantDeProducto" style="width:80px;">
							</form>							<div class="input-group-append">
								<span class="input-group-text">Cantidad</span>
							</div>
						</div>
						<div class="card-footer mt-3 text-center">
              			<button type="submit" class="btn btn-danger btn-sm text-center" form="form-favorito" value="${lista.id}" name="idFavorito" style="width: 100px;">${eliminarDeFavoritos}</button>

							<button type="submit" class="btn btn-primary btn-sm" form="form-carrito-favoritos${listaIndex.index}" value="${lista.id}" name="idProductoParaCarrito"><img  src="img/shopping-cart.png" class="px-1 py-1"></button>
            		</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<form action="/eliminar-favorito" id="form-favorito" method="POST"></form>
	</div>
</div>


<%@include file="footer.jsp"%>
