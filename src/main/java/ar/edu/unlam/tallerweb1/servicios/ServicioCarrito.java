package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioCarrito {
    List<Carrito> getListaDeProductosDelCarrito();

  

    Carrito validarExistenciaProductoPor(Usuario usuario, Producto producto);

    boolean agregarProductoAlCarrito(Usuario usuario, Producto producto);

    boolean agregarProductoAlCarrito1(Carrito carrito);
}
