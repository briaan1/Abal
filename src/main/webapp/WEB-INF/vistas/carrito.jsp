<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>

<div class = "container py-3 mb-5">

		<h2 class="h2-titulo">Carrito</h2>

		<c:choose>
			<c:when test="${not empty msg}">
				<div class="alert alert-warning"><h4>${msg}</h4></div>
			</c:when>
		</c:choose>

		<table class="table table-hover border text-center">

			<thead class="thead-light">
			<c:if test="${listaDeProductosDelCarrito != null}">
				<tr>
					<th>Imagen</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Cantidad</th>
					<th>Subtotal</th>
					<th></th>
				</tr>
			</c:if>
			</thead>
			<tbody>

			<c:forEach var="lista" items="${listaDeProductosDelCarrito}" varStatus="listaIndex"  >
				<c:if test="${lista.producto!=null}">
					<tr>
						<td><img class="card-img-top" style="width: 90px;height:80px;" src="img/${lista.producto.categoria.nombre}/${lista.producto.imagen}" alt="Card image cap"></td>
						<td>${lista.producto.nombre}</td>
						<td>$${lista.producto.precio}</td>
						<td>${lista.cantidad}</td>
						<td>$${lista.cantidad * lista.producto.precio }</td>
						<td>
							<button type="submit" class="btn btn-danger btn-sm text-center" form="form-carrito" value="${lista.id}" name="idCarrito" style="width: 135px;height:40px;">
								${eliminarDelCarrito}
							</button>
						</td>
					</tr>
				</c:if>
				<c:if test="${lista.productoPersonalizado!=null}">
					<tr>
						<td><img class="card-img-top" style="width: 90px;height:80px;" src="img/pizza/pizza_porcion8.svg" alt="Card image cap"></td>
						<td>${lista.productoPersonalizado.nombre}</td>
						<td>$${lista.productoPersonalizado.precioTotal}</td>
						<td>${lista.productoPersonalizado.cantPerzonalizada}</td>
						<td>$${lista.productoPersonalizado.cantPerzonalizada* lista.productoPersonalizado.precioTotal }</td>
						<td>
							<button type="submit" class="btn btn-danger btn-sm text-center" form="form-carrito" value="${lista.id}" name="idCarrito" style="width: 135px;height:40px;">
								${eliminarDelCarrito}
							</button>
						</td>
					</tr>
				</c:if>
			</c:forEach>
			<form action="/eliminar-del-carrito" id="form-carrito" method="post"> </form>
			</tbody>

		</table>
		
		<div>
			<c:if test="${listaDeProductosDelCarrito != null}">
				<div>
					<h4 class="text-right" style="margin-right:300px;">Total: $${total} </h4>
				</div>
				<div>
					<a href="/detalle-de-pedido">
						<button type="button" class="btn float-right" style="background-color:#ff9c00;margin-right:70px;color:#fff;">Realizar pedido</button>
					</a>
				</div>
			</c:if>
		</div>

</div>
<%@include file="footer.jsp"%>