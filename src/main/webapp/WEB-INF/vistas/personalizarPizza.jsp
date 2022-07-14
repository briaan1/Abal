<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<div class = "container">
	<div class="modal-body"></div>

	<h1 class="my-4">${titulo}</h1>

<!--	<div class="mt-3 text-center">-->
	<h2 class="h2-titulo py-5">Dale el estilo que mas te gusta </h2>

	<p class="text-center"><b>Ponele nombre a tu pizza</b></p>

	<c:choose>
		<c:when test="${not empty msg}">
			<div class="alert alert-primary"><h4>${msg}</h4></div>
		</c:when>
	</c:choose>

	
<form:form action="/agregar-personalizar-pizza" method="POST" modelAttribute="datosPizzaPersonalizada" id="form-personalizado">

	<div class="input-group w-50 mx-auto my-3">
		<input type="text" class="form-control text-center w-50 " placeholder="Ingresa un nombre para tu pizza"   name="nombre"  required="required">

	</div>


		<table class="table table-hover border">
			<thead class="thead-light">
			<tr>
				<th>Imagen</th>
				<th>Nombre</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/pizza/pizza_porcion1.svg" alt="Card image cap"></td>
				<td><form:select path="porcion1" class="custom-select"> 
 			<c:choose> 
			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> 
 			</c:choose> 
 			<c:forEach var="lista" items="${listaDePizza}"> 
 				<option value="${lista.id}" >${lista.nombre} $${lista.precio/8}</option> 
 			</c:forEach> 
 			</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/pizza/pizza_porcion2.svg" alt="Card image cap"></td>
				
				<td>		
					<form:select path="porcion2" class="custom-select">
			<c:choose>
			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
			</c:choose>
			<c:forEach var="lista" items="${listaDePizza}">
				<option value="${lista.id}" >${lista.nombre} $${lista.precio/8}</option>
			</c:forEach>
			</form:select></td>
			</tr>
			<tr>
			<td><img style="width: 100px;" class="card-img-top" src="img/pizza/pizza_porcion3.svg" alt="Card image cap"></td>
				
			<td>
				<form:select path="porcion3" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre} $${lista.precio/8}</option>
					</c:forEach>
				</form:select>
			</td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/pizza/pizza_porcion4.svg" alt="Card image cap"></td>
				
			<td>
				<form:select path="porcion4" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre} $${lista.precio/8}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/pizza/pizza_porcion5.svg" alt="Card image cap"></td>
				
			<td>
				<form:select path="porcion5" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre} $${lista.precio/8}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/pizza/pizza_porcion6.svg" alt="Card image cap"></td>
				
			<td>
				<form:select path="porcion6" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre} $${lista.precio/8}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/pizza/pizza_porcion7.svg" alt="Card image cap"></td>
				
			<td>
				<form:select path="porcion7" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre} $${lista.precio/8}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/pizza/pizza_porcion8.svg" alt="Card image cap"></td>
				
			<td>
				<form:select path="porcion8" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre} $${lista.precio/8}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			</tbody>
		</table>
		<br>

		
		<div class="input-group w-50 mx-auto">

            <input type="number" class="form-control text-center w-50"  value="1"   name="cantDeProducto" >

			<div class="input-group-append">
            	<span class="input-group-text">Cantidad</span>
         	</div>
    	</div>

		<!-- ${listaIndex.index} -->
		<br><button type="submit" class="btn btn-primary btn-sm float-right" form="form-personalizado" value="${lista.id}" name="idProductoParaCarrito"><img  src="img/shopping-cart.png" class="px-1 py-1">Agregar a carrito</button>
		<!-- <button type="submit" class="btn btn-primary float-right">Agregar al carrito</button>  -->
		</form:form>
	</div>
</div>

<br>
<br>
<br>
<br>


<!-- Placed at the end of the document so the pages load faster -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	window.jQuery
			|| document
					.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<%@include file="footer.jsp"%>