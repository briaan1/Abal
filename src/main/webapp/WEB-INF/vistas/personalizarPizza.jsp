<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<div class = "container">
	<div class="modal-body"></div>

	<h1 class="my-4">${titulo}</h1>

	<c:choose>
		<c:when test="${not empty msg}">
			<div class="alert alert-primary"><h4>${msg}</h4></div>
		</c:when>
	</c:choose>

	
<form:form action="/agregar-personalizar-pizza" method="POST" modelAttribute="datosPizzaPersonalizada" id="form-personalizado">



	<div class="w-75 mx-auto mt-5">
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">1
					Porci�n</label>
			</div>	
		<form:select path="porcion1" class="custom-select">
			<c:forEach var="lista" items="${listaDePizza}" >
				<option value="${lista.id}" >${lista.nombre}</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">2
					Porci�n</label>
			</div>	
		<form:select path="porcion2" class="custom-select">
			
			<c:forEach var="lista" items="${listaDePizza}">
				<option value="${lista.id}" >${lista.nombre}</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">3
					Porcion</label>
			</div>	
		<form:select path="porcion3" class="custom-select">
			
			<c:forEach var="lista" items="${listaDePizza}">
				<option value="${lista.id}" >${lista.nombre}</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">4
					Porci�n</label>
			</div>	
		<form:select path="porcion4" class="custom-select">
			
			<c:forEach var="lista" items="${listaDePizza}">
				<option value="${lista.id}" >${lista.nombre}</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">5
					Porci�n</label>
			</div>	
		<form:select path="porcion5" class="custom-select">
			
			<c:forEach var="lista" items="${listaDePizza}">
				<option value="${lista.id}" >${lista.nombre}</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">6
					Porci�n</label>
			</div>	
		<form:select path="porcion6" class="custom-select">
			
			<c:forEach var="lista" items="${listaDePizza}">
				<option value="${lista.id}" >${lista.nombre}</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">7
					Porci�n</label>
			</div>	
		<form:select path="porcion7" class="custom-select">
			
			<c:forEach var="lista" items="${listaDePizza}">
				<option value="${lista.id}" >${lista.nombre}</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">8
					Porci�n</label>
			</div>	
			<form:select path="porcion8" class="custom-select">
				
				<c:forEach var="lista" items="${listaDePizza}">
					<option value="${lista.id}" >${lista.nombre}</option>
				</c:forEach>
			</form:select>
		</div>
		
		<div class="input-group">
           <!-- <form action="/agregar-personalizar-pizza" id="form-carrito-personalizado${listaIndex.index}" method="POST" >  </form>   --> 
            <input type="number" class="form-control text-center"  value="1"   name="cantDeProducto" style="width:80px;">
                                 
            <div class="input-group-append">
            	<span class="input-group-text">Cantidad</span>
         	</div>
    	</div>

		<!-- ${listaIndex.index} -->
		<button type="submit" class="btn btn-primary btn-sm" form="form-personalizado" value="${lista.id}" name="idProductoParaCarrito"><img  src="img/shopping-cart.png" class="px-1 py-1">Agregar a carrito</button>
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