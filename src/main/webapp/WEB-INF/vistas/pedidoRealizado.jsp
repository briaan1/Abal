<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mb-5">
    <h2 class="h2-titulo py-5">Resumen del pedido </h2>



<div class="contenedor-flex">
  <div class="contenedor-child">
    <table class="table text-center">
      <thead>
      <tr>
      <th scope="col">Producto</th>
        <th scope="col">Cantidad</th>
        <th scope="col">Subtotal</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="lista" items="${listaDeProductosDelPedido}">
          <tr>
            <td>${lista.pedido.nombre}</td>
            <td>${lista.cantidad} </td>
            <td>$${lista.cantidad * lista.productoDetalle.precio}</td>
          </tr>

      </c:forEach>
      <c:forEach var="lista" items="${listaDeTipoPersonalizado}">
        <tr>
          <td>${lista.nombre}</td>
          <td>${lista.cantPerzonalizada}</td>
          <td>$${lista.cantPerzonalizada * lista.precioTotal}</td>
        </tr>
      </c:forEach>

      </tbody>
    </table>
    <div><h4 class="text-right">Total:<span class="mx-3">$${total}</span></h4></div>

  </div>

  <div class="contenedor-child">
    <ul class="list-group list-group-flush">
      <li class="list-group-item"> <b>Nombre y apellido:</b>   ${pedido.nombre} ${pedido.apellido}</li>
      <li class="list-group-item"><b>Fecha de pedido:</b>  ${pedido.fecha}</li>
      <li class="list-group-item"><b>Email:</b>  ${pedido.email}</li>
      <li class="list-group-item"><b>Direccion:</b>  ${pedido.direccion} </li>
      <li class="list-group-item"><b>Codigo Postal:</b>  ${pedido.codigoPostal}</li>
    </ul>
  </div>
</div>


</div>
<%@include file="footer.jsp"%>


