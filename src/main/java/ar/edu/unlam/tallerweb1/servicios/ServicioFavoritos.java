package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioFavoritos {

	List <Favorito> getListaDeFavoritos(int idUsuario);

	boolean agregarAFavorito(Usuario usuario, Producto producto);

	Favorito validarExistenciaProductoPor(Usuario usuario, Producto producto);
	
	List <Favorito> getListaDeFavoritos();
	
	List<Producto> listarFavoritos(Usuario usuario);

	List<Producto> listarFavoritos(Usuario usuario, String categoria);

	List<Producto> listarProductosSinFavoritos(Usuario usuario, String string);

	boolean eliminarFavorito(Favorito favorito);
}
