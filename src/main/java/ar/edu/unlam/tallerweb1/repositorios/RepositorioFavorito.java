package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioFavorito {

	List<Favorito> listarFavoritos();

	boolean agregarAFavorito(Favorito favorito);

	Favorito buscarFavorito(int idUsuario, int idProducto);

	List<Producto> listarFavoritos(Usuario usuario);
}
