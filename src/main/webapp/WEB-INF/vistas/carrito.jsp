<%@include file="header.jsp"%>
<div class = "container"><br>
	<div class="modal-body">
		<h1>Carrito</h1><br>
		<table class="table table-hover border">
			<thead class="thead-light">
			<tr>
				<th>Imagen</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>SubTotal</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>Nombre</td>
				<td>$Precio</td>
				<td><div class="input-group" style="width:200px;">
					<input type="number" class="form-control text-center" value="1">
					<div class="input-group-append">
						<span class="input-group-text">Cantidad</span>
					</div>
				</div></td>
				<td>$SubTotal</td>
				<td><button type="button" class="btn btn-outline-danger">Eliminar</button></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>Nombre</td>
				<td>$Precio</td>
				<td><div class="input-group" style="width:200px;">
					<input type="number" class="form-control text-center" value="1">
					<div class="input-group-append">
						<span class="input-group-text">Cantidad</span>
					</div>
				</div></td>
				<td>$SubTotal</td>
				<td><button type="button" class="btn btn-outline-danger">Eliminar</button></td>
			</tr>
			<tr>
				<td><img style="width: 100px;" class="card-img-top" src="img/clasica.jpg" alt="Card image cap"></td>
				<td>Nombre</td>
				<td>$Precio</td>
				<td><div class="input-group" style="width:200px;">
					<input type="number" class="form-control text-center" value="1">
					<div class="input-group-append">
						<span class="input-group-text">Cantidad</span>
					</div>
				</div></td>
				<td>$SubTotal</td>
				<td><button type="button" class="btn btn-outline-danger">Eliminar</button></td>
			</tr>
			</tbody>
		</table>
		<br>
		<div>
			<h4 class="float-left">Total $Precio</h4><a href="/detalle-de-pedido"><button type="button" class="btn btn-primary float-right">Realizar pedido</button></a> 
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>