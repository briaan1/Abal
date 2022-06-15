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
	
	@Test
	public void devolverUnaListaVaciaSiNoHayFavoritos() {
		dadoQueNoHayFavoritos();
		List<Favorito> listaDeFavoritos = cuandoPidoLaListaDeFavoritos();
		entoncesLaListaDeFavoritosEstaVacia(listaDeFavoritos,0);
	}

private void entoncesLaListaDeFavoritosEstaVacia(List<Favorito> listaDeFavoritos, int cantidadFavoritos) {
		assertThat(listaDeFavoritos).hasSize(cantidadFavoritos);
		
	}

private List<Favorito> cuandoPidoLaListaDeFavoritos() {
		
		return servicioFavoritos.getListaDeFavoritos();
	}

private void dadoQueNoHayFavoritos() {
	when(repositorioFavorito.listarFavoritos()).thenReturn(new ArrayList<Favorito>());
	
}
}
