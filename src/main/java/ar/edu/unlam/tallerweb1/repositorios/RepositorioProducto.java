package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Producto;

public interface RepositorioProducto {
	List<Producto> listar(String categoria);

	Producto validarExistenciaProductoPor(int idProducto);
}
