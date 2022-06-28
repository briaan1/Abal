<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" >
     <link href="css/estilosPerfil.css" rel="stylesheet">
    <!-- Bootstrap theme -->
</head>
<body class="d-flex flex-column min-vh-100">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="/home">Abal</a>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle"
                                type="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            Categoria
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <a class="dropdown-item" href="/pizza">Pizza</a>
                            <a class="dropdown-item" href="/categoria">Combos</a>
                            <a class="dropdown-item" href="/categoria">Categoria 3</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/personalizar-pizza">Personalizado</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contacto</a>
                </li>
            </ul>
            <ul class="navbar-nav mr-4 mt-2 mt-lg-0">
                <li class="nav-item active">
                 <a href="/carrito"><button type="button" class="btn btn-primary">Carrito <span class="badge badge-light badge-pill">3</span></button> </a>    
                </li></ul>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle"
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
        </div>
    </div>
</nav>
