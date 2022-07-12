<%@include file="header.jsp"%>

<h2 class="h2-titulo--margin">Estado del pedido</h2>

<div class="alert alert-success w-50 mx-auto mt-3 mb-5" role="alert">
  <h4 class="alert-heading">Pago procesado</h4>
  <p>Su pago ha sido procesado. Revise su email para obtener el comprobante de confirmación.</p>
  <hr>
  <p class="mb-0">Recuerde que puede ver y hacer un seguimiento de su pedido desde esta misma solapa.</p>
</div>

<p class="p-descripcion">Gracias por confiar en nuestro equipo</p>

<div class="container w-75 mx-auto">
<div class="progress">
  <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">Preparando pedido...</div>
</div></div>

<script type="text/javascript">

  for (let i = 0; i < 500; i++) {
    const el = document.querySelector(".number");
    const elValue = Number(el.getAttribute("data-value"));
    let counter = 0;

    setInterval(() => {
      if (counter !== elValue) {
        counter++;
        el.innerHTML = `${counter}%`;
      }
      if (counter == 100) {
        counter = 0;
        el.setAttribute("data-value", 0);
      }
    }, 80);
  }

</script>



<%@include file="footer.jsp"%>