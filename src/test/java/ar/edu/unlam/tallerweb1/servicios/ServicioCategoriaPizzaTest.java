package ar.edu.unlam.tallerweb1.servicios;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProducto;
import static org.assertj.core.api.Assertions.*;

public class ServicioCategoriaPizzaTest {
	private RepositorioProducto repositorioProducto=mock(RepositorioProducto.class);
	private ServicioProducto servicioProducto=new ServicioProductoImpl(repositorioProducto);
	
	@Test
	public void devolverUnaListaVaciaSiNohayproductosEnLaCategoriaPizza() {
		dadoQueNoHayProductosEnLaCategoria("pizza");
		List<Producto> listaDeProductos=cuandoPidoLaListaDeProductos("pizza");
		entoncesLaListaEstaVacia(listaDeProductos, 0);
	}

	private void entoncesLaListaEstaVacia(List<Producto> listaDeProductos, int cantidadEsperada) {
		assertThat(listaDeProductos).hasSize(cantidadEsperada);
	}

	private List<Producto> cuandoPidoLaListaDeProductos(String categoria) {
		return servicioProducto.getListaDeProductos(categoria);
	}

	private void dadoQueNoHayProductosEnLaCategoria(String categoria) {
		when(repositorioProducto.listar(categoria)).thenReturn(new ArrayList<Producto>());
	}
}