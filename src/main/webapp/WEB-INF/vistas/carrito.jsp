<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>
<div class = "container"><br>
	<div class="modal-body">
		<h1>Carrito</h1><br>

		<c:choose>
			<c:when test="${not empty msg}">
				<div class="alert alert-primary"><h4>${msg}</h4></div>
			</c:when>
		</c:choose>

		<table class="table table-hover border">

			<thead class="thead-light">
			<tr>
				<th>Imagen</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>SubTotal</th>
				<th></th>
			</tr>
			</thead>
			<tbody>

			<c:forEach var="lista" items="${listaDeProductosDelCarrito}" varStatus="listaIndex"  >
				<c:if test="${lista.producto!=null}">
				<tr>
					<td><img style="width: 100px;" class="card-img-top" src="img/${lista.producto.categoria.nombre}/${lista.producto.imagen}" alt="Card image cap"></td>
					<td>${lista.producto.nombre}</td>
					<td>${lista.producto.precio}</td>

					<td><div class="input-group" style="width:200px;">
							${lista.cantidad}
					</div></td>
					<td>$${lista.cantidad * lista.producto.precio }</td>
					<td>
						<button type="submit" class="btn btn-danger btn-sm text-center" form="form-carrito" value="${lista.id}" name="idCarrito" style="width: 100px;">${eliminarDelCarrito}</button>
				</tr>
			</c:if>
				<c:if test="${lista.productoPersonalizado!=null}">
					<tr>
						<td><img style="width: 100px;" class="card-img-top" src="img/pizza/pizza_porcion8.svg" alt="Card image cap"></td>
						<td>${lista.productoPersonalizado.nombre}</td>
						<td>${lista.productoPersonalizado.precioTotal}</td>

						<td><div class="input-group" style="width:200px;">
								${lista.productoPersonalizado.cantPerzonalizada}
						</div></td>
						<td>$${lista.productoPersonalizado.cantPerzonalizada* lista.productoPersonalizado.precioTotal }</td>
						<td>
							<button type="submit" class="btn btn-danger btn-sm text-center" form="form-carrito" value="${lista.id}" name="idCarrito" style="width: 100px;">${eliminarDelCarrito}</button>
					</tr>
				</c:if>
			</c:forEach>
			<form action="/eliminar-del-carrito" id="form-carrito" method="post"> </form>
			</tbody>

		</table>
		<br>
		<div>
			<h4 class="float-left">Total $${total} </h4>

			<a href="/detalle-de-pedido">
				<div><button type="button" class="btn btn-primary float-right">Realizar pedido</button></div></a>

	</div>
</div>
</div>
<%@include file="footer.jsp"%>