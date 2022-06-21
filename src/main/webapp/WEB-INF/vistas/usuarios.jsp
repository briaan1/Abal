<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	<br>
	<br>
	<div class="mt-3 text-center">
		<h2 class="alert-heading">${usuario}</h2>
	</div>

<form action="/cambiar-usuario" method="POST">
	<div class="w-75 mx-auto mt-5">
		<select name="idUsuario" class="custom-select" required>
			<option value="">Usuarios</option>
			<c:forEach var="lista" items="${listaDeUsuarios}">
				<option value="${lista.id}">${lista.nombre}</option>
			</c:forEach>
		</select>
		<br><br>
		<button type="submit" class="btn btn-primary float-right">Ingresar</button>
		</form>
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