<%@include file="header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mb-5">

	<h2 class="h2-titulo py-5">Detalle del pedido</h2>
	
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
			  <c:forEach var="lista" items="${listaDeProductosDelCarrito}">
				  <c:if test="${lista.producto!=null}">
				    <tr>
				      <td>${lista.producto.nombre}</td>
				      <td>${lista.cantidad} </td>
				      <td>$${lista.cantidad * lista.producto.precio}</td>
				    </tr>
				   </c:if>
				   <c:if test="${lista.productoPersonalizado!=null}">
				   	<tr>
				      <td>${lista.productoPersonalizado.nombre}</td>
				      <td>${lista.productoPersonalizado.cantPerzonalizada}</td>
				      <td>$${lista.productoPersonalizado.cantPerzonalizada * lista.productoPersonalizado.precioTotal}</td>
				    </tr>
				   </c:if >
			   </c:forEach>
			  </tbody>
			</table>
			<div><h4 class="text-right">Total:<span class="mx-3">$${total}</span></h4></div>
		</div>
		
		<div class="contenedor-child">
			<div class="card p-3"> 
			<div>
		 	<h4 class="heading mb-3 text-center">Datos de envio</h4>
		 	
			<div class="input-group mb-3 ">
		  		<div class="input-group-prepend">
		    		<span class="input-group-text" id="basic-addon1">Nombre</span>
		  		</div>
		  		<input type="text" name="nombre" value="${usuario}" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
				
				<div class="input-group-prepend ml-5">
		    		<span class="input-group-text" id="basic-addon1">Apellido</span>
		  		</div>
		  		<input type="text" value="${apellido}" name="apellido" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
			</div>
			
			<div class="input-group mb-3">
		 		<div class="input-group-prepend">
		    		<span class="input-group-text" id="basic-addon1">Direccion</span>
		  		</div>
		  		<input type="text" name="direccion" value="${direccion}" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
			
				<div class="input-group-prepend ml-5">
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
			
				<div class="input-group-prepend ml-3">
		    		<span class="input-group-text" id="basic-addon1">Email</span>
		  		</div>
		  		<input type="email" name="email" value="${email}" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
			</div>
		
			<div class="input-group mb-3 w-50">
		  		<div class="input-group-prepend">
		    		<span class="input-group-text" id="basic-addon1">Telefono</span>
		  		</div>
		  		<input type="tel" name="telefono" class="form-control" aria-describedby="basic-addon1" required form="form-pedido">
			</div>
		  	</div> 
		  	
		   	<div class="text-right">
			   		<input type="hidden" name="total" form="form-pedido" value="${total}">
		    </div>
		    	
			<div class="credit rounded mt-4 d-flex justify-content-between align-items-center">
			    <div class="d-flex flex-row align-items-center">
			    	<img src="https://i.imgur.com/qHX7vY1.png" class="rounded" width="70">
			    		<div class="d-flex flex-column ml-3"> <span class="business">Credit Card</span>
			    			<span class="plan">1234 XXXX XXXX 2570</span> 
			    		</div>
			    </div> 
			   	<div> <input type="text" class="form-control cvv" placeholder="CVC" required> </div>
			 </div> 
			 
			 <div class="credit rounded mt-2 d-flex justify-content-between align-items-center"> </div>
			    <div class="mt-3">
			     	<button type="submit" class="btn btn-block payment-button w-25 mx-auto" style="background-color:#ff9c00;color:#fff;" form="form-pedido">Pagar</button>
			     	<form action="/pagar-pedido" id="form-pedido" method="POST"></form>
			    </div> 
			 </div> 
		</div>
		
	<!-- Fin contenedor flex -->	
	</div>
	
</div>



<%@include file="footer.jsp"%>

