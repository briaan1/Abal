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
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;

import static org.assertj.core.api.Assertions.*;

public class ControladorCategoriaPizzaTest {
	
	private ServicioFavoritos servicioDeFavorito=mock(ServicioFavoritos.class);
	private ServicioCategoriaPizza servicioCategoriaPizza=mock(ServicioCategoriaPizza.class);
	private ControladorCategoriaPizza controladorCategoriaPizza=new ControladorCategoriaPizza(servicioCategoriaPizza, servicioDeFavorito);
	
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

	@Test
	public void alAgregarUnFavoritoMeMuestraUnMensajeQueSeAgregoCorrectamente() {

		dadoQueExisteUnProducto(2, "pizza");
		
		ModelAndView model = cuandoLoAgregoAFavorito(2, "pizza");
		
		entoncesMeMuestraUnMensaje("Se agrego a favoritos", model);	
	}
	
	@Test
	public void alAgregarUnProductoQueNoExisteAFavoritoMeMuestraUnMensajeDeError() {
		dadoQueNoExisteUnProducto(2, "pizza");
		
		ModelAndView model = cuandoLoAgregoAFavorito(2, "pizza");
		
		entoncesMeMuestraUnMensaje("Producto inexistente", model);	
	}
	
	@Test
	public void alAgregarUnProductoQueYaExisteEnFavoritosMeMuestraUnMensaje() {
		dadoQueExisteUnProductoAgregadoEnFavorito(2);
		
		ModelAndView model = cuandoLoAgregoAFavorito(2, "pizza");
		
		entoncesMeMuestraUnMensaje("El producto ya esta agregado", model);	
	}
	
	private void dadoQueExisteUnProductoAgregadoEnFavorito(int idProducto) {
		Producto producto = new Producto();
		
		producto.setId(idProducto);
		
		when(servicioCategoriaPizza.validarExistenciaProductoPor(idProducto)).thenReturn(producto);
		when(servicioDeFavorito.validarExistenciaProductoPor(idProducto)).thenReturn(producto);
		//when(servicioDeFavorito.agregarAFavorito(producto.getId())).thenReturn(true);	
	}
	
	private void dadoQueNoExisteUnProducto(int idProducto, String nombreProducto) {
		when(servicioCategoriaPizza.validarExistenciaProductoPor(idProducto)).thenReturn(null);
	}
	
	private ModelAndView cuandoLoAgregoAFavorito(int idProducto, String nombreProducto) {
		return controladorCategoriaPizza.clickEnAgregarFavorito(idProducto);
	}
	
	private void dadoQueExisteUnProducto(int idProducto, String nombreProducto) {	
		Producto producto = new Producto();
		
		producto.setId(idProducto);
		producto.setNombre(nombreProducto);
		
		when(servicioCategoriaPizza.validarExistenciaProductoPor(idProducto)).thenReturn(producto);
		when(servicioDeFavorito.agregarAFavorito(producto.getId())).thenReturn(true);	
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
