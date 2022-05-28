<%@include file="header.jsp"%>

<div class="contenedor">
	<p class="p-img">
	<img src="img/user-image.png" class="img" alt="imagen-perfil-de-usuario">
	</p>
 
 	<h2 class="h2-titulo">Nombre de usuario</h2>
 	<p class="etiqueta-usuario">@usuario</p>
 	
</div>

<div class="card text-center w-75 mx-auto  mb-5 ">
  <div class="card-header">
    <ul class="nav nav-tabs card-header-tabs">
      <li class="nav-item">
        <a class="nav-link active" href="#">Mis datos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Mis pedidos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/favorito">Mis favoritos</a>
      </li>
    </ul>
  </div>
  
  <div class="card-body w-75 mx-auto">
    <h5 class="card-title">Modificar datos</h5>
    
	<form>
	  <div class="form-row">
	    <div class="col-md-6 mb-3">
	      <label for="validationDefault01">Nombre</label>
	      <input type="text" class="form-control" id="validationDefault01" value="Nombre" required>
	    </div>
	    <div class="col-md-6 mb-3">
	      <label for="validationDefault02">Apellido</label>
	      <input type="text" class="form-control" id="validationDefault02" value="Apellido" required>
	    </div>
	  </div>
	  <div class="form-row">
	    <div class="col-md-6 mb-3">
	      <label for="validationDefault03">Direccion</label>
	      <input type="text" class="form-control" id="validationDefault03" required>
	    </div>
	    <div class="col-md-3 mb-3">
	      <label for="validationDefault04">Localidad</label>
	      <select class="custom-select" id="validationDefault04" required>
	        <option selected disabled value="">Seleccione una</option>
	        <option>...</option>
	      </select>
	    </div>
	    <div class="col-md-3 mb-3">
	      <label for="validationDefault05">Código postal</label>
	      <input type="text" class="form-control" id="validationDefault05" required>
	    </div>
	    
	     <div class="col-md-6 mb-3">
	      <label for="validationDefault02">Correo electrónico</label>
	      <input type="text" class="form-control" id="validationDefault02" value="correo@mail.com" required>
	    </div>
	  </div>
	 
	  <button class="btn btn-outline-primary mt-5" type="submit">Guardar</button>
	</form>

  </div>
</div>

<%@include file="footer.jsp"%>

