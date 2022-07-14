<%@include file="header.jsp"%>

<div class="alert alert-success w-50 mx-auto mt-3" role="alert">
  <h4 class="alert-heading">Pago procesado</h4>
  <p>Su pago ha sido procesado.</p>
  <hr>
  <p class="mb-0">Gracias por confiar en nuestro equipo.</p>
</div>

<div class="container">
<h2 class="titulo">Comentarios</h2>
<h3 class="subtitulo">Opiniones de nuestros clientes</h3>
<p class="img-separador"><img src="img/rolling-pin.png" alt=""></p>
	<div class="container">       	
             <div class="box-area" style="height: 300px;">
             <div class="img-area">
             <img class="foto-img" src="img/personas-fotos/persona1.jpg" alt="">
             </div>	
             <h5>${usuario}</h5>								
           
        <form action="/enviar-comentario" method="post">     
    	<label for="exampleFormControlTextarea1"></label>
    	<textarea placeholder="Comentario" name="comentario" autofocus class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea><br>
    	<button type="submit" class="btn btn-primary float-right">Enviar comentario</button>
    	<a href="/historial-de-pedidos"><button type="button" class="btn btn-light float-right mr-2">Omitir</button></a>
    	</form>
         </div>
	</div>
</div><br><br><br>

<%@include file="footer.jsp"%>