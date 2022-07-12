<%@include file="header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/simulado.css" rel="stylesheet">
<h2 class="h2-titulo--margin">Detalle del pedido</h2>


<ul class="list-group w-75 mx-auto mt-5">
<c:forEach var="lista" items="${listaDeProductosDelCarrito}">
  <li class="list-group-item d-flex justify-content-between align-items-center">
    ${lista.producto.nombre}
    <span><span class="badge badge-primary badge-pill">${lista.cantidad} </span> $${lista.cantidad * lista.producto.precio}</span> 
  </li>
  </c:forEach>
  
  <li class="list-group-item d-flex justify-content-between align-items-center">
  Total:
    <span class=""><span>$${total}</span></span> 
  </li>
</ul>

<p class="p-descripcion">Elija su medio de pago.</p>


<a class="btn btn-primary w-25 mx-auto mt-5" href="/pagar-pedido" role="button">Pagar</a><br><br>





<%@include file="footer.jsp"%>

