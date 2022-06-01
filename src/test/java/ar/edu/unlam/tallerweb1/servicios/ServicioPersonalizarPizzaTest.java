package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPersonalizarPizza;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class ServicioPersonalizarPizzaTest {
	private RepositorioPersonalizarPizza repositorioPersonalizarPizza=mock(RepositorioPersonalizarPizza.class);
	private ServicioPersonalizarPizza servicioPersonalizarPizza=new ServicioPersonalizarPizzaImpl(repositorioPersonalizarPizza);
	
	@Test
	public void devolverUnaListaVaciaSiNohayproductos() {
		dadoQueNoHayProductosEnLaCategoria("pizza");
		List<Producto> listaDeProductos=cuandoPidoLaListaDeProductos("pizza");
		entoncesLaListaEstaVacia(listaDeProductos, 0);
	}

	private void entoncesLaListaEstaVacia(List<Producto> listaDeProductos, int cantidadEsperada) {
		assertThat(listaDeProductos).hasSize(cantidadEsperada);
	}

	private List<Producto> cuandoPidoLaListaDeProductos(String nombreCategoria) {
		return servicioPersonalizarPizza.getListaDeProductos(nombreCategoria);
	}

	private void dadoQueNoHayProductosEnLaCategoria(String nombreCategoria) {
		when(repositorioPersonalizarPizza.listar(nombreCategoria)).thenReturn(null);
	}
}
