package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioCarrito {
    List<Carrito> getListaDeProductosDelCarrito( Usuario usuario);

  

    Carrito validarExistenciaProductoPor(int idCarrito);

    boolean agregarProductoAlCarrito(Usuario usuario, Producto producto,int cantidadProducto);

    boolean agregarProductoAlCarrito1(Carrito carrito);


    void eliminarDelCarrito(Carrito carrito);

    Double sumarElTotalDeLosProductos(List<Carrito> listaDeProductosDelCarrito);

    int sumarCantidadDeProductosProductos(List<Carrito> listaDeProductosDelCarrito);

    
    void eliminarProductosDelCarrito(List<Carrito> listaDeProductosDelCarrito);



	boolean agregarProductoPersonalizadoAlCarrito(Usuario usuario, TipoPersonalizado productoPersonalizado,
			int cantidadPersonalizado);

	//Double sumarElTotalDeLosProductosPersonalizados(List<Carrito> listaDeCarrito);

}
