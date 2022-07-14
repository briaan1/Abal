<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="contenedor">
	<p class="p-img">
	<img src="img/personas-fotos/persona2.jpg" class="img" alt="imagen-perfil-de-usuario">
	</p>
 
 	<h2 class="h2-titulo">${nombre}  ${apellido}</h2>
	<span> </span>	<p class="etiqueta-usuario">@Abal</p>
 	
</div>

<div class="card text-center w-75 mx-auto  mb-5 ">
  <div class="card-header">
    <ul class="nav nav-tabs card-header-tabs">
      <li class="nav-item">
        <a class="nav-link active" href="/perfil">Mis datos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/historial-de-pedidos">Mis pedidos</a>
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
	      <input type="text" class="form-control" id="validationDefault01" value="${nombre}" disabled >
	    </div>
	    <div class="col-md-6 mb-3">
	      <label for="validationDefault02">Apellido</label>
	      <input type="text" class="form-control" id="validationDefault02" value="${apellido}" disabled>
	    </div>
	  </div>
	  <div class="form-row">
	    <div class="col-md-6 mb-3">
	      <label for="validationDefault03">Direccion</label>
	      <input type="text" class="form-control" id="validationDefault03" value="${domicilio}" disabled>
	    </div>
	    <div class="col-md-3 mb-3">
	      <label for="validationDefault04">Localidad</label>
	      <input type="text" class="form-control" id="validationDefault03" value="${localidad}" disabled>
	    </div>
	    <div class="col-md-3 mb-3">
	      <label for="validationDefault05">Código postal</label>
	      <input type="text" class="form-control" id="validationDefault05" value="${codPostal}" disabled>
	    </div>
	    
	     <div class="col-md-6 mb-3">
	      <label for="validationDefault02">Correo electrónico</label>
	      <input type="text" class="form-control" id="validationDefault02" value="${email}" disabled>
	    </div>
	  </div>
	</form>

  </div>
</div>

<%@include file="footer.jsp"%>

