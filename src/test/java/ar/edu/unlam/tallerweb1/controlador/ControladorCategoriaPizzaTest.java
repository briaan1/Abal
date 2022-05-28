package ar.edu.unlam.tallerweb1.controlador;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.controladores.ControladorCategoriaPizza;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoriaPizza;

import static org.assertj.core.api.Assertions.*;

public class ControladorCategoriaPizzaTest {
	private ServicioCategoriaPizza servicioCategoriaPizza=mock(ServicioCategoriaPizza.class);
	private ControladorCategoriaPizza controladorCategoriaPizza=new ControladorCategoriaPizza(servicioCategoriaPizza);
	
	@Test
    public void alPedirLaCategoriaPizzaMeMuestraLaCategoria(){
        ModelAndView model=cuandoPidoLaCategoriaPizza();
        entoncesMeLlevaALaVistaCategoria("categoriaPizza",model);
    }
	@Test
	public void alPedirLaListaDeProductosDeCategoriaPizzaDevuelveLalistaCompleta() {
		dadoQueExistenLosProductosDeCategoria("pizza", 10);
		ModelAndView model=cuandoPidoLaListaDeProductos("pizza");
		entoncesMeMuestraLaListaCompleta(model, 10);
	}
	@Test
	public void mostrarUnMensajeSiNoHayProductosEnLaCategoriaPizza() {
		dadoQueNoHayProductosEnLaCategoria("pizza");
		ModelAndView model=cuandoPidoLaListaDeProductos("pizza");
		entoncesMeMuestraUnMensaje("No hay productos en esta categoria", model);
	}

	private void entoncesMeMuestraUnMensaje(String mensajeEsperado, ModelAndView model) {
		assertThat(model.getModel().get("msg")).isEqualTo(mensajeEsperado);
	}
	private ModelAndView cuandoPidoLaListaDeProductos(String categoria) {
		return controladorCategoriaPizza.irAPizza();
	}
	private void dadoQueNoHayProductosEnLaCategoria(String categoria) {
		when(servicioCategoriaPizza.getListaDeProductos(categoria)).thenReturn(new ArrayList<Producto>());
	}
	private void entoncesMeMuestraLaListaCompleta(ModelAndView model, int cantidadEsperada) {
		assertThat(model.getModel().get("listaDeProductos")).asList().hasSize(cantidadEsperada);
	}
	private void dadoQueExistenLosProductosDeCategoria(String categoria, int cantidadDeproductos) {
		List<Producto> listaDeProductos=new ArrayList<Producto>();
		for(int i=0;i<cantidadDeproductos;i++) {
			listaDeProductos.add(new Producto());
		}
		when(servicioCategoriaPizza.getListaDeProductos(categoria)).thenReturn(listaDeProductos);
	}
	private void entoncesMeLlevaALaVistaCategoria(String vistaEsperada, ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);
	}

	private ModelAndView cuandoPidoLaCategoriaPizza() {
		return controladorCategoriaPizza.irAPizza();
	}
}
