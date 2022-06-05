package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;

public interface ServicioFavoritos {

	List <Favorito> getListaDeFavoritos(int idUsuario);

	Boolean agregarAFavorito(int idProducto);

	Producto validarExistenciaProductoPor(int idProducto);

}
