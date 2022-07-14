<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h2 class="h2-titulo--margin">Resumen del pedido ${pedido.id}</h2>


<ul class="list-group w-75 mx-auto mt-5">
Fecha: ${pedido.fecha}<br>
Nombre: ${pedido.nombre}<br>
Apellido: ${pedido.apellido}<br>
Telefono: ${pedido.telefono}<br>
Email: ${pedido.email}<br>
Direccion: ${pedido.direccion}<br>
Localidad: ${pedido.localidad}<br>
Codigo postal: ${pedido.codigoPostal}<br><br>
<c:forEach var="lista" items="${listaDeProductosDelPedido}">
  <li class="list-group-item d-flex justify-content-between align-items-center"> 
    ${lista.productoDetalle.nombre}
    <span><span class="badge badge-primary badge-pill">${lista.cantidad} </span> $${lista.cantidad * lista.productoDetalle.precio}</span> 
  </li>
  </c:forEach>
  <c:forEach var="lista" items="${listaDeTipoPersonalizado}">
  <li class="list-group-item d-flex justify-content-between align-items-center"> 
    ${lista.nombre}
    <span><span class="badge badge-primary badge-pill">${lista.cantPerzonalizada} </span> $${lista.precioTotal}</span> 
  </li>
  </c:forEach>
  
  <li class="list-group-item d-flex justify-content-between align-items-center">
  Total:
    <span class=""><span>$${total}</span></span> 
  </li>
</ul><br><br><br><br>

<%@include file="footer.jsp"%>




