package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioFavorito {

<<<<<<< Updated upstream
	List<Favorito> listarFavoritos();

	boolean agregarAFavorito(Favorito favorito);
=======
	Producto buscarFavoritoPorId(int idProducto);
>>>>>>> Stashed changes

	Favorito buscarFavorito(int idUsuario, int idProducto);

<<<<<<< Updated upstream
	List<Producto> listarFavoritos(Usuario usuario);
}
=======
	List<Favorito> listarFavoritosPorId(int id);

	List<Favorito> listarFavoritos();
}
>>>>>>> Stashed changes
