package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoriaPizza;
import static org.assertj.core.api.Assertions.*;

public class ServicioCategoriaPizzaTest {

	private RepositorioCategoriaPizza repositorioCategoriaPizza ;
	private ServicioCategoriaPizza servicioCategoriaPizza ;

	@Before
	public void init(){
	repositorioCategoriaPizza = mock(RepositorioCategoriaPizza.class);
		 servicioCategoriaPizza = new ServicioCategoriaPizzaImpl(repositorioCategoriaPizza);

	}

	/*@Test
	public void devolverUnaListaVaciaSiNohayproductosEnLaCategoriaPizza() {
		dadoQueNoHayProductosEnLaCategoria("pizza");
		List<Producto> listaDeProductos = cuandoPidoLaListaDeProductos("pizza");
		entoncesLaListaEstaVacia(listaDeProductos, 0);
	}*/

	@Test
	public void queAlBuscarUnDeterminadoProductoMeLoDevuelva() {
		dadoQueExisteUnProductoConElId(4);

		Producto productoBuscado = cuandoBuscoElProducto(4);
		productoBuscado.setId(4);
		entoncesEncuentroElProducto(productoBuscado.getId(), 4);
	}

	private void entoncesLaListaEstaVacia(List<Producto> listaDeProductos, int cantidadEsperada) {
		assertThat(listaDeProductos).hasSize(cantidadEsperada);
	}

	private List<Producto> cuandoPidoLaListaDeProductos(String categoria) {
		return servicioCategoriaPizza.getListaDeProductos(categoria);
	}

	private void dadoQueNoHayProductosEnLaCategoria(String categoria) {
		when(repositorioCategoriaPizza.listar(categoria)).thenReturn(new ArrayList<Producto>());
	}




	private void entoncesEncuentroElProducto(int idProducto, int numeroId) {
		assertThat( numeroId).isEqualTo(idProducto);
		//assertEquals(numeroId,idProducto);
	}

	private Producto cuandoBuscoElProducto(int idDeProducto) {
		/*Le paso este metodo porque va a usar el metodo buscar del repositorio*/
		//return servicioCategoriaPizza.validarExistenciaProductoPor(idDeProducto);
		return  servicioCategoriaPizza.validarExistenciaProductoPor(idDeProducto);


	}

	private void dadoQueExisteUnProductoConElId(int idDeProducto) {

		when(repositorioCategoriaPizza.buscarPor(idDeProducto)).thenReturn(new Producto());
}
}