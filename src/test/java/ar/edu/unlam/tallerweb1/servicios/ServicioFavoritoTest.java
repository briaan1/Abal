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
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProducto;
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
	@Test
	public void alAgregarUnFavoritoLoAgrega() {
		Usuario usuario=new Usuario();
		usuario.setId(1);
		Producto producto=dadoQueExisteUnProductoConId(1, usuario);
		boolean productoAgregado=cuandoLoAgregoAFavoritos(producto, usuario);
		entoncesLoAgrega(usuario, producto);
	}
	private void entoncesLoAgrega(Usuario usuario, Producto producto) {
		Favorito favorito=servicioFavoritos.validarExistenciaProductoPor(usuario, producto);
		assertThat(favorito.getUsuario().getId()).isEqualTo(usuario.getId());
		assertThat(favorito.getProducto().getId()).isEqualTo(producto.getId());
	}
	private boolean cuandoLoAgregoAFavoritos(Producto producto, Usuario usuario) {
		return servicioFavoritos.agregarAFavorito(usuario, producto);
	}
	private Producto dadoQueExisteUnProductoConId(int idProducto, Usuario usuario) {
		Producto producto=new Producto();
		producto.setId(idProducto);
		Favorito favorito=new Favorito();
		favorito.setUsuario(usuario);
		favorito.setProducto(producto);
		when(repositorioFavorito.agregarAFavorito(favorito)).thenReturn(true);
		when(repositorioFavorito.buscarFavorito(usuario.getId(), producto.getId())).thenReturn(favorito);
		return producto;
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
