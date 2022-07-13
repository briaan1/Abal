<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	<br>
	<br>
	<div class="mt-3 text-center">
		<h2 class="alert-heading">Personalizar Pizza</h2>
		<p>Seleccione el tipo de pizza que desee por cada porción.</p>
	</div>

<%-- <form:form action="agregar-personalizar-pizza" method="POST" modelAttribute="datosPizzaPersonalizada"> --%>
<!-- 	<div class="w-75 mx-auto mt-5"> -->
<!-- 		<div class="input-group mb-3">	 -->
<!-- 			<div class="input-group-prepend"> -->
<!-- 				<label class="input-group-text" for="inputGroupSelect01">1 -->
<!-- 					Porción</label> -->
<!-- 			</div>	 -->
<%-- 		<form:select path="porcion1" class="custom-select"> --%>
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> --%>
<%-- 			</c:choose> --%>
<%-- 			<c:forEach var="lista" items="${listaDePizza}"> --%>
<%-- 				<option value="${lista.id}" >${lista.nombre}</option> --%>
<%-- 			</c:forEach> --%>
<%-- 			</form:select> --%>
<!-- 		</div> -->
<!-- 		<div class="input-group mb-3">	 -->
<!-- 			<div class="input-group-prepend"> -->
<!-- 				<label class="input-group-text" for="inputGroupSelect01">2 -->
<!-- 					Porción</label> -->
<!-- 			</div>	 -->
<%-- 		<form:select path="porcion2" class="custom-select"> --%>
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> --%>
<%-- 			</c:choose> --%>
<%-- 			<c:forEach var="lista" items="${listaDePizza}"> --%>
<%-- 				<option value="${lista.id}" >${lista.nombre}</option> --%>
<%-- 			</c:forEach> --%>
<%-- 			</form:select> --%>
<!-- 		</div> -->
<!-- 		<div class="input-group mb-3">	 -->
<!-- 			<div class="input-group-prepend"> -->
<!-- 				<label class="input-group-text" for="inputGroupSelect01">3 -->
<!-- 					Porción</label> -->
<!-- 			</div>	 -->
<%-- 		<form:select path="porcion3" class="custom-select"> --%>
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> --%>
<%-- 			</c:choose> --%>
<%-- 			<c:forEach var="lista" items="${listaDePizza}"> --%>
<%-- 				<option value="${lista.id}" >${lista.nombre}</option> --%>
<%-- 			</c:forEach> --%>
<%-- 			</form:select> --%>
<!-- 		</div> -->
<!-- 		<div class="input-group mb-3">	 -->
<!-- 			<div class="input-group-prepend"> -->
<!-- 				<label class="input-group-text" for="inputGroupSelect01">4 -->
<!-- 					Porción</label> -->
<!-- 			</div>	 -->
<%-- 		<form:select path="porcion4" class="custom-select"> --%>
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> --%>
<%-- 			</c:choose> --%>
<%-- 			<c:forEach var="lista" items="${listaDePizza}"> --%>
<%-- 				<option value="${lista.id}" >${lista.nombre}</option> --%>
<%-- 			</c:forEach> --%>
<%-- 			</form:select> --%>
<!-- 		</div> -->
<!-- 		<div class="input-group mb-3">	 -->
<!-- 			<div class="input-group-prepend"> -->
<!-- 				<label class="input-group-text" for="inputGroupSelect01">5 -->
<!-- 					Porción</label> -->
<!-- 			</div>	 -->
<%-- 		<form:select path="porcion5" class="custom-select"> --%>
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> --%>
<%-- 			</c:choose> --%>
<%-- 			<c:forEach var="lista" items="${listaDePizza}"> --%>
<%-- 				<option value="${lista.id}" >${lista.nombre}</option> --%>
<%-- 			</c:forEach> --%>
<%-- 			</form:select> --%>
<!-- 		</div> -->
<!-- 		<div class="input-group mb-3">	 -->
<!-- 			<div class="input-group-prepend"> -->
<!-- 				<label class="input-group-text" for="inputGroupSelect01">6 -->
<!-- 					Porción</label> -->
<!-- 			</div>	 -->
<%-- 		<form:select path="porcion6" class="custom-select"> --%>
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> --%>
<%-- 			</c:choose> --%>
<%-- 			<c:forEach var="lista" items="${listaDePizza}"> --%>
<%-- 				<option value="${lista.id}" >${lista.nombre}</option> --%>
<%-- 			</c:forEach> --%>
<%-- 			</form:select> --%>
<!-- 		</div> -->
<!-- 		<div class="input-group mb-3">	 -->
<!-- 			<div class="input-group-prepend"> -->
<!-- 				<label class="input-group-text" for="inputGroupSelect01">7 -->
<!-- 					Porción</label> -->
<!-- 			</div>	 -->
<%-- 		<form:select path="porcion7" class="custom-select"> --%>
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> --%>
<%-- 			</c:choose> --%>
<%-- 			<c:forEach var="lista" items="${listaDePizza}"> --%>
<%-- 				<option value="${lista.id}" >${lista.nombre}</option> --%>
<%-- 			</c:forEach> --%>
<%-- 			</form:select> --%>
<!-- 		</div> -->
<!-- 		<div class="input-group mb-3">	 -->
<!-- 			<div class="input-group-prepend"> -->
<!-- 				<label class="input-group-text" for="inputGroupSelect01">8 -->
<!-- 					Porción</label> -->
<!-- 			</div>	 -->
<%-- 		<form:select path="porcion8" class="custom-select"> --%>
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> --%>
<%-- 			</c:choose> --%>
<%-- 			<c:forEach var="lista" items="${listaDePizza}"> --%>
<%-- 				<option value="${lista.id}" >${lista.nombre}</option> --%>
<%-- 			</c:forEach> --%>
<%-- 			</form:select> --%>
<!-- 		</div> -->

<!-- 		<button type="submit" class="btn btn-primary float-right">Agregar -->
<!-- 			al carrito</button> -->
<%-- 		</form:form> --%>
		
<!-- 		CARRITO -->
<form:form action="agregar-personalizar-pizza" method="POST" modelAttribute="datosPizzaPersonalizada">
		<div class="modal-body">
		<table class="table table-hover border">
			<thead class="thead-light">
			<tr>
				<th>Imagen</th>
				<th>Precio</th>
				<th>Nombre</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>$Precio</td>
				<td><form:select path="porcion1" class="custom-select"> 
 			<c:choose> 
			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when> 
 			</c:choose> 
 			<c:forEach var="lista" items="${listaDePizza}"> 
 				<option value="${lista.id}" >${lista.nombre}</option> 
 			</c:forEach> 
 			</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>$Precio</td>
				<td>		
					<form:select path="porcion2" class="custom-select">
			<c:choose>
			<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
			</c:choose>
			<c:forEach var="lista" items="${listaDePizza}">
				<option value="${lista.id}" >${lista.nombre}</option>
			</c:forEach>
			</form:select></td>
			</tr>
			<tr>
			<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>$Precio</td>
			<td>
				<form:select path="porcion3" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre}</option>
					</c:forEach>
				</form:select>
			</td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>$Precio</td>
			<td>
				<form:select path="porcion4" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>$Precio</td>
			<td>
				<form:select path="porcion5" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>$Precio</td>
			<td>
				<form:select path="porcion6" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>$Precio</td>
			<td>
				<form:select path="porcion7" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>$Precio</td>
			<td>
				<form:select path="porcion8" class="custom-select">
					<c:choose>
						<c:when test="${not empty mensaje}"><option value="0" >${mensaje}</option></c:when>
					</c:choose>
					<c:forEach var="lista" items="${listaDePizza}">
						<option value="${lista.id}" >${lista.nombre}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			</tbody>
		</table>
		<br>
	</div>
			<button type="submit" class="btn btn-primary float-right">Agregar 
 			al carrito</button>
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