package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Producto;

public interface ServicioTipoPersonalizada {

	void setProductoPersonalizado(Producto producto);

	boolean agregarProductoPersonalizado(List<Producto> listaProductos);

}
