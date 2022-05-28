<%@include file="header.jsp"%>

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
    <tr>
      <th scope="row">1</th>
      <td>Pedido 1</td>
      <td>$Total</td>
      <td>Fecha</td>
      <td class="text-primary">En proceso</td>
      <td><a href="/estado-de-pedido"><button type="button" class="btn btn-outline-info">Ver pedido</button></a></td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Pedido 2</td>
      <td>$Total</td>
      <td>Fecha</td>
      <td><span class="text-success">Entregado</span></td>
      <td><a href="/pedido-realizado"><button type="button" class="btn btn-outline-info">Ver pedido</button></a></td>
    </tr>
  </tbody>
</table>

</div>


<%@include file="footer.jsp"%>

