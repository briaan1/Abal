<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" >
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
                            <a class="dropdown-item" href="/categoria">Categoria 1</a>
                            <a class="dropdown-item" href="/categoria">Categoria 2</a>
                            <a class="dropdown-item" href="/categoria">Categoria 3</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contacto</a>
                </li>
            </ul>
            <ul class="navbar-nav mr-4 mt-2 mt-lg-0">
                <li class="nav-item active">
                 <a href="/carrito"><button type="button" class="btn btn-primary">Carrito <span class="badge badge-light badge-pill">0</span></button> </a>    
                </li></ul>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle"
                        type="button" id="dropdownMenu1" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    Usuario
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <a class="dropdown-item" href="#!">Perfil</a>
                    <a class="dropdown-item" href="#!">Pedidos</a>
                    <a class="dropdown-item" href="#!">Favoritos</a>
                </div>
            </div>
            <a href="/login"><button type="button" class="btn btn-dark">Iniciar</button></a>
            <a href="/registrarse"><button type="button" class="btn btn-dark">Registrarse</button></a>
        </div>
    </div>
</nav>