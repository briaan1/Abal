<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" >
    <!-- Icono -->
     <link rel="icon" type="image/png" href="img/logo-pizza.png">
    <!-- Estilos -->
   	<link href="css/estilosPerfil.css" rel="stylesheet">
    <link href="css/home.css" rel="stylesheet">
    
    <!--Fuentes-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script&display=swap" rel="stylesheet">
    
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons"
      rel="stylesheet">
      <link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined"
      rel="stylesheet">
    
    <title>Pizzería Abal</title>
</head>
<body class="d-flex flex-column min-vh-100">

<nav class="navbar navbar-expand-lg navbar-dark bg-light">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
		<a class="navbar-brand logo text-dark px-1" href="/home">
        <img class="pb-2" alt="Logo en forma de pizza" src="img/logo-pizza.png">
  		Abal</a>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link text-dark pb-2" href="/home">Inicio<span class="sr-only">(current)</span></a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link text-dark pb-2" href="#nosotros">Nosotros</a>
                </li>
                
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle bg-light text-dark border-0 py-2"
                                type="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            Categorías
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <a class="dropdown-item" href="/pizza">Pizzas</a>
                            <a class="dropdown-item" href="/categoriaCombos">Combos</a>
                            <a class="dropdown-item" href="/personalizar-pizza">Personalizadas</a>
                            <a class="dropdown-item" href="/categoriaBebida">Bebidas</a>
                        </div>
                    </div>
                </li>
             
                <li class="nav-item">
                    <a class="nav-link text-dark pb-2" href="#contacto">Contacto</a>
                </li>
            </ul>
            <ul class="navbar-nav mr-4 mt-2 mt-lg-0">
                <li class="nav-item active">
                 <a href="/carrito"><button type="button" class="btn btn-primary"><img src="img/shopping-cart.png" class="pb-1 pr-1">Carrito <span class="badge badge-light badge-pill">3</span></button> </a>    
                </li></ul>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle bg-light text-dark border-0 py-2 mr-2"
                        type="button" id="dropdownMenu1" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    Usuario ${usuario}
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <a class="dropdown-item" href="/perfil">Perfil</a>
                    <a class="dropdown-item" href="/historial-de-pedidos">Pedidos</a>
                    <a class="dropdown-item" href="/favorito">Favoritos</a>
                    <a class="dropdown-item border-top" href="/usuarios">Cerrar Sesion</a>
                </div>
            </div>

            <a href="/login"><button type="button" class="btn btn-light bg-light border-0 py-2 mr-2">Iniciar</button></a>
            <a href="/registrarse"><button type="button" class="btn btn-light bg-light border-0 py-2">Registrarse</button></a>

        </div>
    </div>
</nav>