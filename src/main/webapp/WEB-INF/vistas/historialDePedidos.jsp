<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container py-3 mb-5">
	<h2 class="h2-titulo py-5">Mis Pedidos</h2>



	<c:if test="${listaDePedidos == null}">
		<div class="alert alert-warning"><h4>No tiene pedidos realizados</h4></div>
	</c:if>
	
	<table class="table table-hover border text-center">
	  <thead class="thead-light">
	  <c:if test="${listaDePedidos != null}">
	    <tr>
	      <th>Numero</th>
	      <th>Fecha</th>
	      <th>Total</th>
	      <th>Estado de envio</th>
	      <th></th>
	    </tr>
	  </c:if>
	  </thead>
	  <tbody>
	  <c:forEach var="lista" items="${listaDePedidos}">
	    <tr>
	      <th scope="row">${lista.id}</th>
	      <td>${lista.fecha}</td>
	      <td>$${lista.total}</td>
	      <td class="text-primary">En proceso</td>
	      <td><a href="/pedido-realizado?idPedido=${lista.id}"><button type="button" class="btn btn-outline-info">Ver pedido</button></a></td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>

</div>


<%@include file="footer.jsp"%>

