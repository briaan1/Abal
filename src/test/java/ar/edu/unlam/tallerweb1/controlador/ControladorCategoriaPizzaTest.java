package ar.edu.unlam.tallerweb1.controlador;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.controladores.ControladorCategoriaPizza;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

import static org.assertj.core.api.Assertions.*;

public class ControladorCategoriaPizzaTest {
	
	private ServicioFavoritos servicioDeFavorito=mock(ServicioFavoritos.class);
	private ServicioProducto servicioProducto=mock(ServicioProducto.class);
	private ServicioUsuario servicioUsuario=mock(ServicioUsuario.class);
	private ServicioCarrito servicioCarrito=mock(ServicioCarrito.class);

	private ControladorCategoriaPizza controladorCategoriaPizza=new ControladorCategoriaPizza(servicioProducto, servicioDeFavorito, servicioUsuario,servicioCarrito);
	
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
		Usuario usuario=new Usuario();
		usuario.setId(1);
		Producto producto = new Producto();
		producto.setId(1);
		dadoQueExisteUnProductoAgregadoEnFavorito(usuario, producto);
		
		ModelAndView model = cuandoLoAgregoAFavorito(1);
		
		entoncesMeMuestraUnMensaje("El producto fue eliminado de favoritos", model);
	}


	@Test
	public void alAgregarUnProductoAlCarritoDeComprasQueMeMuestraUnMensajeQueSeAgregoCorrectamente(){
		Usuario usuario=new Usuario();
		usuario.setId(2);
		Producto producto = new Producto();
		producto.setId(2);
		dadoQueExisteUnProductoParaElCarrito(producto, "pizza",usuario);
		ModelAndView model = cuandoLosAgregoAlCarritoDeComprasYSuCantEsMenorAUno(producto, "pizza",usuario,1);
		entoncesMeMuestraUnMensaje("Se agrego al carrito de compras el producto ", model);
	}



	//@Test
	//public void alAgregarMasDeUnProductoAlCarritoDeComprasQueMeMuestraUnMensajeQueSeAgregoCorrectamente(){
	//dadoQueExisteUnProducto();
	//	ModelAndView model = cuandoLosAgregoAlCarritoDeCompras(2, "pizza",2,1);
	//	entoncesMeMuestraUnMensaje("Se agregaron  los productos al carrito de compras de compras", model);
	//}
	private void dadoQueExisteUnProductoParaElCarrito(Producto producto, String categoria, Usuario usuario) {
		when(servicioUsuario.getUsuario()).thenReturn(usuario);
		when(servicioProducto.validarExistenciaProductoPor(producto.getId())).thenReturn(producto);
		when(servicioCarrito.agregarProductoAlCarrito(usuario,producto)).thenReturn(true);

	}
/*	private ModelAndView cuandoLosAgregoAlCarritoDeCompras(Producto producto, String pizza, int cantidad,Usuario usuario) {
		Usuario usuario=new Usuario();
		usuario.setId(IdUsario);
		Producto producto = new Producto();
		producto.setId(idProducto);
		Carrito carrito=new Carrito();
		carrito.setProducto(producto);
		carrito.setUsuario(usuario);

		servicioCarrito.agregarProductoAlCarrito(carrito.getUsuario(),carrito.getProducto());
		return controladorCategoriaPizza.clickEnAgregarAlCarritoDeCompras(idProducto,cantidad);
	}*/

	private ModelAndView cuandoLosAgregoAlCarritoDeComprasYSuCantEsMenorAUno(Producto producto, String categoria,Usuario usuario,int cant ) {
		return controladorCategoriaPizza.clickEnAgregarAlCarritoDeCompras(producto.getId(),cant);
	}


	private void dadoQueExisteUnProductoAgregadoEnFavorito(Usuario usuario, Producto producto) {
		when(servicioUsuario.getUsuario()).thenReturn(usuario);
		when(servicioProducto.validarExistenciaProductoPor(producto.getId())).thenReturn(producto);
		when(servicioDeFavorito.validarExistenciaProductoPor(usuario, producto)).thenReturn(new Favorito());	
	}
	
	private void dadoQueNoExisteUnProducto(int idProducto, String nombreProducto) {
		when(servicioProducto.validarExistenciaProductoPor(idProducto)).thenReturn(null);
	}
	
	private ModelAndView cuandoLoAgregoAFavorito(int idProducto) {
		return controladorCategoriaPizza.clicEnAgregarFavorito(idProducto);
	}
	
	private void entoncesMeMuestraUnMensaje(String mensajeEsperado, ModelAndView model) {
		assertThat(model.getModel().get("msg")).isEqualTo(mensajeEsperado);
	}

	private ModelAndView cuandoLoAgregoAFavorito(int idProducto, String nombreProducto) {
		return controladorCategoriaPizza.clicEnAgregarFavorito(idProducto);
	}
	
	private void dadoQueExisteUnProducto(int idProducto, String nombreProducto) {
		Usuario usuario=new Usuario();
		Producto producto = new Producto();
		producto.setId(idProducto);
		producto.setNombre(nombreProducto);
		when(servicioUsuario.getUsuario()).thenReturn(usuario);
		when(servicioProducto.validarExistenciaProductoPor(idProducto)).thenReturn(producto);
		when(servicioDeFavorito.validarExistenciaProductoPor(usuario, producto)).thenReturn(null);
		when(servicioDeFavorito.agregarAFavorito(usuario, producto)).thenReturn(true);
	}
	
	private ModelAndView cuandoPidoLaListaDeProductos(String categoria) {
		return controladorCategoriaPizza.irAPizza(null, null);
	}
	
	private void dadoQueNoHayProductosEnLaCategoria(String categoria) {
		when(servicioProducto.getListaDeProductos(categoria)).thenReturn(new ArrayList<Producto>());
	}
	
	private void entoncesMeMuestraLaListaCompleta(ModelAndView model, int cantidadEsperada) {
		assertThat(model.getModel().get("listaDeProductos")).asList().hasSize(cantidadEsperada);
	}
	
	private void dadoQueExistenLosProductosDeCategoria(String categoria, int cantidadDeproductos) {
		List<Producto> listaDeProductos=new ArrayList<Producto>();
		for(int i=0;i<cantidadDeproductos;i++) {
			listaDeProductos.add(new Producto());
		}
		when(servicioProducto.getListaDeProductos(categoria)).thenReturn(listaDeProductos);
	}
	
	private void entoncesMeLlevaALaVistaCategoria(String vistaEsperada, ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);
	}

	private ModelAndView cuandoPidoLaCategoriaPizza() {
		return controladorCategoriaPizza.irAPizza(null, null);
	}
}