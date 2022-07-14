<%@include file="header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/simulado.css" rel="stylesheet">
<h2 class="h2-titulo--margin">Detalle del pedido</h2>


<ul class="list-group w-75 mx-auto mt-5">
<c:forEach var="lista" items="${listaDeProductosDelCarrito}">
  <c:if test="${lista.producto!=null}">
  <li class="list-group-item d-flex justify-content-between align-items-center">
    ${lista.producto.nombre}

    <span><span >${lista.cantidad} </span> $${lista.cantidad * lista.producto.precio}</span>
  </li>
</c:if >
  <c:if test="${lista.productoPersonalizado!=null}">
    <li class="list-group-item d-flex justify-content-between align-items-center">
        ${lista.productoPersonalizado.nombre}

      <span><span >${lista.productoPersonalizado.cantPerzonalizada} </span> $${lista.productoPersonalizado.cantPerzonalizada * lista.productoPersonalizado.precioTotal}</span>
    </li>
  </c:if >
  </c:forEach>
  
  <li class="list-group-item d-flex justify-content-between align-items-center">
  Total:
    <span class=""><span>$${total}</span></span> 
  </li>
</ul>
<div class="container mt-5 mb-5 d-flex justify-content-center">
 <div class="card p-5"> <div>
 <h4 class="heading mb-3">Datos de envio</h4>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Nombre</span>
  </div>
  <input type="text" name="nombre" value="${usuario}" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Apellido</span>
  </div>
  <input type="text" value="${apellido}" name="apellido" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Telefono</span>
  </div>
  <input type="tel" name="telefono" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Email</span>
  </div>
  <input type="email" name="email" value="${email}" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Direccion</span>
  </div>
  <input type="text" name="direccion" value="${direccion}" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Localidad</label>
  </div>
  <select name="localidad" class="custom-select" id="inputGroupSelect01" required form="form-pedido">
    <option value="">Localidad</option>
    <option>San justo</option>
	<option>Ramos Mejia</option>
	<option>Belgrano</option>
  </select>
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Codigo postal</span>
  </div>
  <input type="text" name="codigoPostal" value="${codigoPostal}" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
</div>
  </div> <div class="pricing p-3 rounded mt-4 d-flex justify-content-between">
   <div class="d-flex flex-row"><h4>Total: $${total}</h4><input type="hidden" name="total" form="form-pedido" value="${total}"></div>
    <!-- /pricing table--> </div>
    <div class="credit rounded mt-4 d-flex justify-content-between align-items-center">
    <div class="d-flex flex-row align-items-center">
    <img src="https://i.imgur.com/qHX7vY1.png" class="rounded" width="70">
    <div class="d-flex flex-column ml-3"> <span class="business">Credit Card</span>
    <span class="plan">1234 XXXX XXXX 2570</span> </div>
    </div> <div> <input type="text" class="form-control cvv" placeholder="CVC" required> </div>
     </div> <div class="credit rounded mt-2 d-flex justify-content-between align-items-center"> 
      
     <div>
     </div> </div>
     <div class="mt-3"><button type="submit" class="btn btn-primary btn-block payment-button" form="form-pedido">Pagar <i class="fa fa-long-arrow-right"></i></button>
     <form action="/pagar-pedido" id="form-pedido" method="POST"></form>
     </div> </div> </div>
<%@include file="footer.jsp"%>

