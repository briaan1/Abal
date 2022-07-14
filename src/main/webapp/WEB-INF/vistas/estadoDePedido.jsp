<%@include file="header.jsp"%>

<div class="alert alert-success w-50 mx-auto mt-3" role="alert">
  <h4 class="alert-heading text-center">Tu pago se proceso con exito</h4>

  <hr>
  <p class="mb-0 text-center" >Gracias por confiar en nosotros.</p>
</div>

<div class="container">
<h2 class="titulo">Comentarios</h2>
<h3 class="subtitulo">Dejanos tu comentario</h3>
<p class="img-separador"><img src="img/rolling-pin.png" alt=""></p>
	<div class="container">       	
             <div class="box-area" style="height: 300px;">
             <div class="img-area">
             <img class="foto-img" src="img/personas-fotos/persona1.jpg" alt="">
             </div>	
             <h5 class="text-center">${usuario}</h5>
           
        <form action="/enviar-comentario" method="post">     
    	<label for="exampleFormControlTextarea1"></label>
    	<textarea placeholder="Danos tu opinion " name="comentario" autofocus class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea><br>
    	<button type="submit" class="btn btn-primary float-right">Enviar comentario</button>
    	<a href="/historial-de-pedidos"><button type="button" class="btn btn-light float-right mr-2">Omitir</button></a>
    	</form>
         </div>
	</div>
</div><br><br><br>

<%@include file="footer.jsp"%>