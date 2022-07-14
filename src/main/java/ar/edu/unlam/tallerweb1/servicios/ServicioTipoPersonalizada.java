package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;

public interface ServicioTipoPersonalizada {

	void setProductoPersonalizado(Producto producto);

	TipoPersonalizado agregarProductoPersonalizado(List<Producto> listaProductos,int cantPersonalizada);

	int generarId(List<Producto> listaProductos);

	TipoPersonalizado buscarProductoPersonalizadoPorCodigoGenerado(int id);

	Double sumarTotalDePorciones(List<Producto> listaProducto);

}
