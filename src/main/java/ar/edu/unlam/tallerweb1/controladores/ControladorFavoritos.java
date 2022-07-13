package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorFavoritos {
	
	private ServicioFavoritos servicioDeFavoritos;
	private ServicioUsuario servicioUsuario;
	private ServicioProducto servicioProducto;
	private ServicioCarrito servicioCarrito;
	
	@Autowired
    public ControladorFavoritos(ServicioFavoritos servicioDeFavoritos, ServicioUsuario servicioUsuario, ServicioProducto servicioProducto,ServicioCarrito servicioCarrito) {
    	this.servicioDeFavoritos=servicioDeFavoritos;
    	this.servicioUsuario=servicioUsuario;
    	this.servicioProducto=servicioProducto;
    	this.servicioCarrito= servicioCarrito;
	}

    @RequestMapping(path="/favorito")
    public ModelAndView irAFavorito() {
		ModelMap model=new ModelMap();
		Usuario usuario=servicioUsuario.getUsuario();

		List<Carrito> listaDeCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuario);
		Double sumaTotalDelCarrito= servicioCarrito.sumarElTotalDeLosProductos(listaDeCarrito);


		int cantProducto=servicioCarrito.sumarCantidadDeProductosProductos(listaDeCarrito);
		model.put("cantProductos",cantProducto);
		model.put("sumaTotalDelCarrito",sumaTotalDelCarrito);
		model.put("usuario", usuario.getNombre());
		model.put("eliminarDeFavoritos", "Eliminar de favoritos");
		
		List<Producto> listaDeFavoritos=servicioDeFavoritos.listarFavoritos(usuario);
		if(listaDeFavoritos!=null) {
			model.put("listaDeFavoritos", listaDeFavoritos);
		}else {
			model.put("msg", "No hay favoritos");
		}
		
		return new ModelAndView("favorito", model);
    }
    
    @RequestMapping(path = "/eliminar-favorito", method = RequestMethod.POST)
	public ModelAndView clicEnEliminarFavorito(@ModelAttribute("idFavorito") Integer idProducto ) {
		ModelMap model=new ModelMap();
		Usuario usuario=servicioUsuario.getUsuario();
		Producto productoEncontrado = servicioProducto.validarExistenciaProductoPor(idProducto);
		
		if(productoEncontrado!=null) {
			Favorito favorito = servicioDeFavoritos.validarExistenciaProductoPor(usuario, productoEncontrado);
			servicioDeFavoritos.eliminarFavorito(favorito);
		}else {
			model.put("msg", "Producto inexistente");
		}
		
		return new ModelAndView("redirect:/favorito", model);
    }

	@RequestMapping(path = "/agregar-carrito-cate-favorito", method = RequestMethod.POST)
	public ModelAndView clickEnAgregarAlCarritoDeCompras(  @ModelAttribute("idProductoParaCarrito") int idProducto,
														   @ModelAttribute("cantDeProducto")int cantidad ) {
		ModelMap model=new ModelMap();
		Usuario usuario=servicioUsuario.getUsuario();
		Producto productoEncontrado = servicioProducto.validarExistenciaProductoPor(idProducto);
		if(productoEncontrado!=null) {

			//if (seAgrego){
			if (cantidad >= 1) {
				servicioCarrito.agregarProductoAlCarrito(usuario,productoEncontrado,cantidad);
				List<Carrito> listaDeCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuario);
				int cantidadProductos= servicioCarrito.sumarCantidadDeProductosProductos(listaDeCarrito);
				double sumaTotalDelCarrito=servicioCarrito.sumarElTotalDeLosProductos(listaDeCarrito);

				model.put("sumaTotalDelCarrito",sumaTotalDelCarrito);
				model.put("cantProductos",cantidadProductos);
				model.put("msg", "Se agrego el producto al carrito de compras");

			} else  {
				model.put("msg", "selecciona la cantidad deseada");
			}
		}else {
			model.put("msg", "el producto no se encontro");
		}

		return new ModelAndView("redirect:/favorito", model);
	}

}