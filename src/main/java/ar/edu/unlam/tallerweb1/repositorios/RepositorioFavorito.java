package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;

public interface RepositorioFavorito {



	List<Favorito> listarFavoritosPorIdUsuario(int i);


	Favorito buscarFavorito( int idProducto);
}
