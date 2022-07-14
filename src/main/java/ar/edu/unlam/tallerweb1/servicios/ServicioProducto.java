package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Producto;

public interface ServicioProducto {

	List<Producto> getListaDeProductos(String categoria);

	Producto validarExistenciaProductoPor(int idProducto);

	Double calcularPrecioPorUnidad(List<Producto> listaProductos);
	
}
