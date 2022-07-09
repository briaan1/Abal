package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;

import java.util.List;

public  interface RepositorioCarrito {
    List<Carrito> listarLosProductosDelCarrito();

    boolean agregarUnProductoAlCarrito(Carrito carrito);

    Carrito buscarCarrito(int idUsuario, int idProducto);
}
