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
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonalizarPizza;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoPersonalizada;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

public class ControladorPersonalizarPizzaTest {
	private ServicioPersonalizarPizza servicioPersonalizarPizza= mock(ServicioPersonalizarPizza.class);
	private ServicioProducto servicioProducto = mock(ServicioProducto.class);
	private ServicioFavoritos servicioFavorito = mock(ServicioFavoritos.class);
	private ServicioCarrito servicioCarrito = mock(ServicioCarrito.class);
	private ServicioTipoPersonalizada servicioPersonalizada = mock(ServicioTipoPersonalizada.class);
	private ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
	private ControladorPersonalizarPizza controladorPersonalizarPizza= new ControladorPersonalizarPizza(servicioPersonalizarPizza, servicioProducto, servicioFavorito, servicioCarrito, servicioPersonalizada, servicioUsuario);
	
	@Test
	public void alPedirPersonalizarQueMeMuestrePersonalizarPizza() {
		ModelAndView model = cuandoPidoPersonalizarPizza();
		entoncesMeLlevaALaVista("personalizarPizza",model);
	}

	private void entoncesMeLlevaALaVista(String vistaEsperada, ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);	
	}

	private ModelAndView cuandoPidoPersonalizarPizza() {
		return controladorPersonalizarPizza.irAPersonalizarPizza(null);
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
		
		return controladorPersonalizarPizza.irAPersonalizarPizza(string);
	}

	private void dadoQueExisteUnaListaDePizza(String nombreCategoria, int cantidadDePizzas) {
		List<Producto> listaDeProductos=new ArrayList<Producto>();
		for(int i=0;i<cantidadDePizzas;i++) {
			listaDeProductos.add(new Producto());
		}
		when(servicioPersonalizarPizza.getListaDeProductos(nombreCategoria)).thenReturn(listaDeProductos);		
	}
	
//	@Test
	public void mostrarUnMensajeSiNoHayPizzas() {
//		dadoQueNoHayPizzas("pizza");
//		ModelAndView model = cuandoPidoLaLista("pizza");
//		entoncesMeMuestraUnMensaje("No hay productos para mostrar",model);
	}

	private void entoncesMeMuestraUnMensaje(String mensajeEsperado, ModelAndView model) {
		assertThat(model.getModel().get("mensaje")).isEqualTo(mensajeEsperado);	
	}

	private void dadoQueNoHayPizzas(String nombreCategoria) {
		
		when(servicioPersonalizarPizza.getListaDeProductos(nombreCategoria)).thenReturn(new ArrayList<Producto>());	
		
	}

}
