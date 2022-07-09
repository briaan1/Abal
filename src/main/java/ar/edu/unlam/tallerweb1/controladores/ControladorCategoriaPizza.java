package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorCategoriaPizza {
	
	private ServicioProducto servicioProducto;
	private ServicioFavoritos servicioDeFavorito; 
	private ServicioUsuario servicioUsuario;
	private ServicioCarrito servicioCarrito;
	
	
	@Autowired
	public ControladorCategoriaPizza(ServicioProducto servicioProducto, ServicioFavoritos servicioDeFavorito, ServicioUsuario servicioUsuario, ServicioCarrito servicioCarrito) {
		this.servicioProducto = servicioProducto;
		this.servicioDeFavorito = servicioDeFavorito;
		this.servicioUsuario = servicioUsuario;
		this.servicioCarrito=servicioCarrito;
	}
	
	@RequestMapping(path = "/pizza", method = RequestMethod.GET)
	public ModelAndView irAPizza(@RequestParam(value = "idFavorito", required = false) Integer idFavorito,
                                 @RequestParam(value = "msg", required = false) String mensaje) {
		ModelMap model=new ModelMap();
		model.put("msg", mensaje);
		
		Usuario usuario=servicioUsuario.getUsuario();
		List<Producto> listaDeProductos=new ArrayList<Producto>();
		if(usuario != null) {
			List<Producto> listaDeFavoritos=servicioDeFavorito.listarFavoritos(usuario, "pizza");
			listaDeProductos=servicioDeFavorito.listarProductosSinFavoritos(usuario, "pizza");
			model.put("listaDeFavoritos", listaDeFavoritos);
			model.put("usuario", usuario.getNombre());
			model.put("eliminarDeFavoritos", "Eliminar de favoritos");
		}
		else {
			listaDeProductos=servicioProducto.getListaDeProductos("pizza");
		}
		
		
		if(listaDeProductos.size()==0) {
			model.put("msg", "No hay productos en esta categoria");
		}else {
			model.put("listaDeProductos", listaDeProductos);
		}
		
		model.put("titulo","Pizza");
		return new ModelAndView("categoriaPizza", model);
	}

	@RequestMapping(path = "/agregar-favorito", method = RequestMethod.POST)
	public ModelAndView clicEnAgregarFavorito(@ModelAttribute("idFavorito") int idProducto ) {
		ModelMap model=new ModelMap();
		
		Usuario usuario=servicioUsuario.getUsuario();
		Producto productoEncontrado = servicioProducto.validarExistenciaProductoPor(idProducto);
		
		if(productoEncontrado!=null) {
			Favorito favorito = servicioDeFavorito.validarExistenciaProductoPor(usuario, productoEncontrado);
			
			if(favorito==null) {
				model.put("msg", "Se agrego a favoritos");
				boolean productoAgregado=servicioDeFavorito.agregarAFavorito(usuario, productoEncontrado);
				if(productoAgregado==true) {
					model.put("msg", "Se agrego a favoritos");
				}
			}else {
				servicioDeFavorito.eliminarFavorito(favorito);
				model.put("msg", "El producto fue eliminado de favoritos");
			}
		}else {
			model.put("msg", "Producto inexistente");
		}
		
		return new ModelAndView("redirect:/pizza", model);
	}


	@RequestMapping(path = "/agregar-carrito-cate-pizza", method = RequestMethod.POST)
	public ModelAndView clickEnAgregarAlCarritoDeCompras(  @ModelAttribute("idProductoParaCarrito") int idProducto,
														   @ModelAttribute("cantDeProducto")int cantidad ) {
		ModelMap model=new ModelMap();
		Usuario usuario=servicioUsuario.getUsuario();
		Producto productoEncontrado = servicioProducto.validarExistenciaProductoPor(idProducto);
		if(productoEncontrado!=null) {
			boolean  seAgrego= servicioCarrito.agregarProductoAlCarrito(usuario,productoEncontrado);
            if (seAgrego){
			if (cantidad > 1) {
				model.put("msg", "Se agregaron  los productos al carrito de compras de compras");

			} else  {
				model.put("msg", "Se agrego al carrito de compras el producto ");
		      	}


			}else {
				model.put("msg", "el producto no se pudo agregar al carrito");
			}
		}else {
			model.put("msg", "Producto inexistente");
		}
		return new ModelAndView("redirect:/pizza", model);
	}
}