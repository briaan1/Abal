package ar.edu.unlam.tallerweb1.controlador;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ar.edu.unlam.tallerweb1.controladores.ControladorPersonalizarPizza;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoriaPizza;

public class ControladorPersonalizarPizzaTest {
	private ServicioCategoriaPizza servicioCategoriaPizza= mock(ServicioCategoriaPizza.class);
	private ControladorPersonalizarPizza controladorPersonalizarPizza= new ControladorPersonalizarPizza(servicioCategoriaPizza);
	
	@Test
	public void alPedirPersonalizarQueMeMuestrePersonalizarPizza() {
		ModelAndView model = cuandoPidoPersonalizarPizza();
		entoncesMeLlevaALaVista("personalizarPizza",model);
	}

	private void entoncesMeLlevaALaVista(String vistaEsperada, ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);	
	}

	private ModelAndView cuandoPidoPersonalizarPizza() {
		return controladorPersonalizarPizza.irAPersonalizarPizza();
	}

	
	@Test
	public void alPedirLaListaEntoncesMeMuestraLaListaDePizzas() {
		dadoQueExisteUnaListaDePizza("pizza",4);
		ModelAndView model = cuandoPidoLaLista("pizza");
		entoncesMeMuestraLaListaDePizza(4,model);
	}

	private void entoncesMeMuestraLaListaDePizza(int cantidadEsperada, ModelAndView model) {
		assertThat(model.getModel().get("listaDePizza")).asList().hasSize(cantidadEsperada);
	}

	private ModelAndView cuandoPidoLaLista(String string) {
		
		return controladorPersonalizarPizza.irAPersonalizarPizza();
	}

	private void dadoQueExisteUnaListaDePizza(String nombreCategoria, int cantidadDePizzas) {
		List<Producto> listaDeProductos=new ArrayList<Producto>();
		for(int i=0;i<cantidadDePizzas;i++) {
			listaDeProductos.add(new Producto());
		}
		when(servicioCategoriaPizza.getListaDeProductos(nombreCategoria)).thenReturn(listaDeProductos);		
	}
	
	@Test
	public void mostrarUnMensajeSiNoHayPizzas() {
		dadoQueNoHayPizzas("pizza");
		ModelAndView model = cuandoPidoLaLista("pizza");
		entoncesMeMuestraUnMensaje("No hay productos para mostrar",model);
	}

	private void entoncesMeMuestraUnMensaje(String mensajeEsperado, ModelAndView model) {
		assertThat(model.getModel().get("mensaje")).isEqualTo(mensajeEsperado);	
	}

	private void dadoQueNoHayPizzas(String nombreCategoria) {
		
		when(servicioCategoriaPizza.getListaDeProductos(nombreCategoria)).thenReturn(null);	
		
	}

}
