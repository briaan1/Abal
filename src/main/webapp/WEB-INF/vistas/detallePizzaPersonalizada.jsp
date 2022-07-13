<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<h2 class="h2-titulo--margin">ID Porciones de pizza</h2> 

<c:choose>
		<c:when test="${not empty msg}">
			<div class="alert alert-primary"><h4>${msg}</h4></div>
		</c:when>
	</c:choose>

<ul class="list-group w-75 mx-auto mt-5">
  <li class="list-group-item justify-content-betweenalign-items-center ">
    <c:forEach var="lista" items="${datosPizzaPersonalizada}" varStatus="i">
		<p>${i.index+1} Porción id = <b>${lista}</b></p>
	</c:forEach>
  </li>
</ul>

<h1>Datos de prueba</h1>
	<c:forEach var="lista" items="${listaDeProductosPrueba}" varStatus="i">
		<p>${lista.nombre}</p>
		<p>${lista.precioUnitario}</p>
		
	</c:forEach>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
<%@include file="footer.jsp"%>