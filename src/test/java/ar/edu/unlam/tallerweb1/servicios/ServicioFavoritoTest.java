package ar.edu.unlam.tallerweb1.servicios;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoriaPizza;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFavorito;

import static org.assertj.core.api.Assertions.*;

public class ServicioFavoritoTest {
	private RepositorioFavorito repositorioFavorito=mock(RepositorioFavorito.class);
	private ServicioFavoritos servicioFavoritos = new ServicioFavoritosImpl(repositorioFavorito);



	/*@Test
	public void alPedirLosFavoritoDeUnUsuarioLoDevuelvo() {
		dadoQueHayFavoritos(5);
		List<Favorito> listaDeFavoritos = cuandoPidoLaListaDeFavoritosDeUnUsuario(5);
		entoncesObtengoLaListaDeFavoritos(listaDeFavoritos,2);
	}

	private void dadoQueHayFavoritos() {
		when(repositorioFavorito.listarFavoritosPorIdUsuario()).thenReturn(new Producto());

	}

*/}
