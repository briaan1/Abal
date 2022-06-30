package ar.edu.unlam.tallerweb1.servicios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProducto;

public class ServicioCategoriaBebidaTest {

	private RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
	private ServicioProducto servicioProducto = new ServicioProductoImpl(repositorioProducto);
	
	@Test
	public void devolverUnaListaVaciaSiNohayproductosEnLaCategoriaBebida() {
		dadoQueNoHayProductosEnLaCategoria("bebida");
		List<Producto> listaDeProductos=cuandoPidoLaListaDeProductos("bebida");
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
