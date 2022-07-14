<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" >

    <!-- Icono -->
    <link rel="icon" type="image/png" href="img/pizza-logo-color-32.png">
    <script src="https://kit.fontawesome.com/2f22cf7961.js" crossorigin="anonymous"></script>

    <!-- Estilos -->
    <link href="css/estilosPerfil.css" rel="stylesheet">
    <link href="css/home.css" rel="stylesheet">
    <link href="css/estiloFooter.css" rel="stylesheet">

    <!-- Fuentes -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Yellowtail&display=swap" rel="stylesheet">

    <!--Para carousel de comentarios-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="css/carouselEstilos.css">

    <title>Pizzeria Abal</title>
</head>

<body class="d-flex flex-column min-vh-100" style="color:black;">
<nav class="navbar navbar-expand-lg navbar-dark bg-white">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand logo text-dark px-1" href="/home">
            <img class="pb-2" alt="Logo en forma de pizza" src="img/pizza-logo-color-32.png">
            Abal</a>


        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item-active">
                    <a class="nav-link text-dark pb-2" href="/home">Inicio<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-dark pb-2" href="/pizza">Pizzas</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-dark pb-2" href="/categoriaCombos">Combos</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-dark pb-2" href="/personalizar-pizza">Personalizadas</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-dark pb-2" href="/categoriaBebida">Bebidas</a>
                </li>
            </ul>


            <ul class="navbar-nav mr-4 mt-2 mt-lg-0">
                <li class="nav-item active">

                    <a href="/carrito"><button type="button" class="btn btn-primary">
                        <img src="img/shopping-cart.png" class="pb-1 pr-1">$${sumaTotalDelCarrito} <span class="badge badge-light badge-pill">${cantProductos}</span></button> </a>
                </li></ul>

            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle bg-white text-dark border-0 py-2"
                        type="button" id="dropdownMenu1" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    Usuario ${usuario}
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <a class="dropdown-item" href="/perfil">Perfil</a>
                    <a class="dropdown-item" href="/historial-de-pedidos">Pedidos</a>
                    <a class="dropdown-item" href="/favorito">Favoritos</a>
                </div>
            </div>
        </div>
    </div>
</nav>