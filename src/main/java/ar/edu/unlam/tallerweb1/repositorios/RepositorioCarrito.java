package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public  interface RepositorioCarrito {
    List<Carrito> listarLosProductosDelCarrito(Usuario usuario);

    boolean agregarUnProductoAlCarrito(Carrito carrito);

    Carrito buscarCarrito(int idCarrito );


    void eliminarCarrito(Carrito carrito);
}
