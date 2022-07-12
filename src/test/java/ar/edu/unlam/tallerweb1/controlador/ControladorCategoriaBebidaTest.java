package ar.edu.unlam.tallerweb1.controlador;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorCategoriaBebida;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

public class ControladorCategoriaBebidaTest {

	private ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
	private ServicioProducto servicioProducto = mock(ServicioProducto.class);
	private ServicioFavoritos servicioFavorito = mock(ServicioFavoritos.class);
	private ServicioCarrito servicioCarrito=mock(ServicioCarrito.class);
	private ControladorCategoriaBebida controladorBebida = new ControladorCategoriaBebida(servicioProducto, servicioFavorito, servicioUsuario,servicioCarrito);
	
	@Test
	public void alPedirLaCategoriaBebidaMeDevuelveEsaCategoria() {
		ModelAndView model = cuandoPidoLaCategoriaBebida();
		entoncesMeLlevaALaCategoria("categoriaBebida", model);
	}
	
	@Test
	public void alPedirLaListaDeProductosDeLaCategoriaBebidaMeDevuelveLaListaCompleta() {
		dadoQueExistenProductosDeLaCategoria("bebida", 5);
		ModelAndView model = cuandoPidoLaListaDeProductos("bebida");
		entoncesMeDevuelveLaListaCompleta(model, 5);
	}

	@Test
	public void queMeMuestreUnMensajeSiNoHayProductosEnLaCategoriaBebida() {
		dadoQueNoExistenProductosDeLaCategoria("bebida");
		ModelAndView model = cuandoPidoLaListaDeProductos("bebida");
		entoncesMeMuestraUnMensaje("No hay productos en esta categoria", model);
	}
	
	@Test
	public void alAgregarUnaBebidaAFavoritosMeMuestraUnMensajeQueSeAgregoCorrectamente() {
		dadoQueExisteUnProducto(2, "bebida");
		ModelAndView model = cuandoLoAgregoAFavorito(2);
		entoncesMeMuestraUnMensaje("Se agrego a favoritos", model);	
	}
	
	@Test
	public void alAgregarUnProductoQueNoExisteAFavoritoMeMuestraUnMensajeDeError() {
		dadoQueNoExisteUnProducto(2);
		ModelAndView model = cuandoLoAgregoAFavorito(2);
		entoncesMeMuestraUnMensaje("Producto inexistente", model);	
	}
	
	@Test
	public void alAgregarUnProductoQueYaExisteEnFavoritosMeMuestraUnMensaje() {
		Usuario usuario=new Usuario();usuario.setId(1);
		Producto producto = new Producto();producto.setId(1);
		dadoQueExisteUnProductoAgregadoEnFavorito(usuario, producto);
		
		ModelAndView model = cuandoLoAgregoAFavorito(1);
		
		entoncesMeMuestraUnMensaje("El producto fue eliminado de favoritos", model);
	}
	
	private void dadoQueExisteUnProductoAgregadoEnFavorito(Usuario usuario, Producto producto) {
		when(servicioUsuario.getUsuario()).thenReturn(usuario);
		when(servicioProducto.validarExistenciaProductoPor(producto.getId())).thenReturn(producto);
		when(servicioFavorito.validarExistenciaProductoPor(usuario, producto)).thenReturn(new Favorito());
	}

	private void dadoQueNoExisteUnProducto(int idProducto) {
		when(servicioProducto.validarExistenciaProductoPor(idProducto)).thenReturn(null);
	}

	private ModelAndView cuandoLoAgregoAFavorito(int idProducto) {
		return controladorBebida.clicEnAgregarFavorito(idProducto);
	}

	private void dadoQueExisteUnProducto(int idProducto, String nombreProducto) {
		Usuario usuario=new Usuario();
		Producto producto = new Producto();
		producto.setId(idProducto);
		producto.setNombre(nombreProducto);
		
		when(servicioUsuario.getUsuario()).thenReturn(usuario);
		when(servicioProducto.validarExistenciaProductoPor(idProducto)).thenReturn(producto);
		when(servicioFavorito.validarExistenciaProductoPor(usuario, producto)).thenReturn(null);
		when(servicioFavorito.agregarAFavorito(usuario, producto)).thenReturn(true);
	}

	private void entoncesMeMuestraUnMensaje(String mensajeEsperado, ModelAndView model) {
		assertThat(model.getModel().get("msg")).isEqualTo(mensajeEsperado);
	}

	private void dadoQueNoExistenProductosDeLaCategoria(String bebida) {
		when(servicioProducto.getListaDeProductos(bebida)).thenReturn(new LinkedList<>());
	}

	private void entoncesMeDevuelveLaListaCompleta(ModelAndView model, int cantidadEsperada) {
		assertThat(model.getModel().get("listaDeProductos")).asList().hasSize(cantidadEsperada);
	}
	
	private ModelAndView cuandoPidoLaListaDeProductos(String categoriaBebida) {
		return controladorBebida.irABebida(null, null);
	}
	
	private void dadoQueExistenProductosDeLaCategoria(String categoriaBebida, int cantidadDeProductos) {
		List<Producto> listaDeProductos=new LinkedList<Producto>();
		for(int i=0;i<cantidadDeProductos;i++) {
			listaDeProductos.add(new Producto());
		}
		when(servicioProducto.getListaDeProductos(categoriaBebida)).thenReturn(listaDeProductos);
	}

	private void entoncesMeLlevaALaCategoria(String vistaEsperada, ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);
	}
	
	private ModelAndView cuandoPidoLaCategoriaBebida() {
		return controladorBebida.irABebida(null, null);
	}

}
