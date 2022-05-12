<%@include file="header.jsp"%>

<h2 class="h2-titulo--margin">Resumen del pedido</h2>

<ul class="list-group w-75 mx-auto mt-5">
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Pizza personalizada
    <span class="badge badge-primary badge-pill">2</span>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Pizza Napolitana
    <span class="badge badge-primary badge-pill">2</span>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Otro
    <span class="badge badge-primary badge-pill">1</span>
  </li>
</ul>
<p class="p-total">Total: <span>$</span></p>
<a class="btn btn-info w-25 mx-auto mt-5" href="/historial-de-pedidos" role="button">Confirmar</a>

<%@include file="footer.jsp"%>


