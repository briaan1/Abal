<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-5 mb-5">
	<h2 class="h2-titulo">Mis Pedidos</h2><br>

	<table class="table table-hover border">
  <thead class="thead-light">
    <tr>
      <th>id</th>
      <th>Pedido</th>
      <th>Total</th>
      <th>Fecha</th>
      <th>Estado de envio</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="lista" items="${listaDePedidos}">
    <tr>
      <th scope="row">${lista.id}</th>
      <td>Pedido</td>
      <td>$Total</td>
      <td>Fecha</td>
      <td class="text-primary">En proceso</td>
      <td><a href="/estado-de-pedido"><button type="button" class="btn btn-outline-info">Ver pedido</button></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

</div>


<%@include file="footer.jsp"%>

