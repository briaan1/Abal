<%@include file="header.jsp"%>

<div class="container mt-5 mb-5">
	<h2 class="h2-titulo">Mis Favoritos</h2>

	<c:choose>
		<c:when test="${not empty mensaje}">
			<div class="alert alert-primary"><h4>${mensaje}</h4></div>
		</c:when>
	</c:choose>
	<c:forEach var="lista" items="${listaDePizzaFavoritas}">
		<div class="col-lg-3 col-md-4 mb-4">
			<div class="card">
				<img class="card-img-top" src="img/pizza/${listaDePizzaFavoritas.imagen}" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">${listaDePizzaFavoritas.id}</h5>
					<h5>$${lista.precio}</h5>
					<p class="card-text">${lista.descripcion}</p>
					<div class="input-group" style="width:200px;">
						<input type="number" class="form-control text-center" value="1">

					</div>

				</div>
			</div>
		</div>
	</c:forEach>

	<div class="row row-cols-1 row-cols-md-3 mt-5 w-75">
	  <div class="col mb-4">
	    <div class="card h-100">
	      <img src="img/clasica.jpg" class="card-img-top" alt="...">
	      <div class="card-body">
	        <h5 class="card-title">Nombre pizza</h5>
	        <p class="card-text">Descripción/Ingredientes</p>
	      </div>
	    </div>
	  </div>
	  <div class="col mb-4">
	    <div class="card h-100">
	      <img src="img/clasica.jpg" class="card-img-top" alt="...">
	      <div class="card-body">
	        <h5 class="card-title">Nombre pizza</h5>
	        <p class="card-text">Descripción/Ingredientes</p>
	      </div>
	    </div>
	  </div>
	  <div class="col mb-4">
	    <div class="card h-100">
	      <img src="img/clasica.jpg" class="card-img-top" alt="...">
	      <div class="card-body">
	        <h5 class="card-title">Nombre pizza</h5>
	        <p class="card-text">Descripción/Ingredientes.</p>
	      </div>
	    </div>
	  </div>
	 
	</div>

</div>


<%@include file="footer.jsp"%>

