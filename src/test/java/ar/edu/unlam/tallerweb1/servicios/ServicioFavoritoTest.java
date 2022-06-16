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
	@Test
	public void alBuscarUnProductoQueNoEstaAgregadoEnfavoritosMeDevuelveNull() {
		Producto producto=dadoQueNoExisteUnProductoAgregadoConId(1);
		Producto productoEncontrado=cuandoValidoLaExistenciaDelProductoEnFavoritos(producto);
		entoncesNoEncuentraElProductoYDevuelveNull(productoEncontrado);
	}
	@Test
	public void alBuscarUnProductoQueEstaAgregadoEnfavoritosMeDevuelveElProducto() {
		Producto producto=dadoQueExisteUnProductoAgregadoConId(1);
		Producto productoEncontrado=cuandoValidoLaExistenciaDelProductoEnFavoritos(producto);
		entoncesEncuentraElProductoYDevuelveElProducto(producto, productoEncontrado);
	}
	@Test
	public void alAgregarUnFavoritoLoAgrega() {
		Producto producto=dadoQueExisteUnProductoConId(1);
		boolean productoAgregado=cuandoLoAgregoAFavoritos(producto);
		entoncesLoAgrega(productoAgregado);
	}
	private void entoncesLoAgrega(boolean productoAgregado) {
		assertThat(productoAgregado).isEqualTo(true);
	}
	private boolean cuandoLoAgregoAFavoritos(Producto producto) {
		return servicioFavoritos.agregarAFavorito(producto.getId());
	}
	private Producto dadoQueExisteUnProductoConId(int idProducto) {
		Producto producto=new Producto();
		producto.setId(idProducto);
		when(repositorioFavorito.agregarAFavorito(producto.getId())).thenReturn(true);
		return producto;
	}
	private void entoncesEncuentraElProductoYDevuelveElProducto(Producto productoBuscado, Producto productoEncontrado) {
		assertThat(productoEncontrado.getId()).isEqualTo(productoBuscado.getId());
	}
	private void entoncesNoEncuentraElProductoYDevuelveNull(Producto productoEncontrado) {
		assertThat(productoEncontrado).isEqualTo(null);
	}
	private Producto cuandoValidoLaExistenciaDelProductoEnFavoritos(Producto producto) {
		return servicioFavoritos.validarExistenciaProductoPor(producto.getId());
	}
	private Producto dadoQueNoExisteUnProductoAgregadoConId(int idProducto) {
		when(repositorioFavorito.buscarFavoritoPorId(idProducto)).thenReturn(null);
		Producto producto=new Producto();
		producto.setId(idProducto);
		return producto;
	}
	private Producto dadoQueExisteUnProductoAgregadoConId(int idProducto) {
		Producto producto=new Producto();
		producto.setId(idProducto);
		when(repositorioFavorito.buscarFavoritoPorId(idProducto)).thenReturn(producto);
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
