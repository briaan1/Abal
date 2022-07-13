package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonalizarPizza;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoPersonalizada;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller

public class ControladorPersonalizarPizza {
	private ServicioPersonalizarPizza servicioPersonalizarPizza;
	private ServicioProducto servicioProducto;
	private ServicioFavoritos servicioFavorito;
	private ServicioCarrito servicioCarrito;
	private ServicioTipoPersonalizada servicioPersonalizada;
	private ServicioUsuario servicioUsuario;
	
	@Autowired
	public ControladorPersonalizarPizza(ServicioPersonalizarPizza servicioPersonalizarPizza, ServicioProducto servicioProducto, ServicioFavoritos servicioFavorito, ServicioCarrito servicioCarrito, ServicioTipoPersonalizada servicioPersonalizada, ServicioUsuario servicioUsuario) {
		this.servicioPersonalizarPizza = servicioPersonalizarPizza;
		this.servicioProducto = servicioProducto;
		this.servicioFavorito = servicioFavorito;
		this.servicioCarrito = servicioCarrito;
		this.servicioPersonalizada = servicioPersonalizada;
		this.servicioUsuario = servicioUsuario;
	}

	@RequestMapping("/personalizar-pizza")
	public ModelAndView irAPersonalizarPizza() {
		ModelMap model = new ModelMap();
		DatosPizzaPersonalizada datos = new DatosPizzaPersonalizada();
		
		 Usuario usuario=servicioUsuario.getUsuario();
	     List<Carrito> listaDeCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuario);
	        
	     int cantProducto=servicioCarrito.sumarCantidadDeProductosProductos(listaDeCarrito);
	     double sumaTotalDelCarrito=servicioCarrito.sumarElTotalDeLosProductos(listaDeCarrito);
	        
		List<Producto> listaDeProducto = servicioPersonalizarPizza.getListaDeProductos("pizza");
		if(listaDeProducto.size()!=0) {
			model.put("listaDePizza", listaDeProducto);
		}else {
			model.put("mensaje", "No hay productos para mostrar");
		}
		
		 model.put("sumaTotalDelCarrito",sumaTotalDelCarrito);
	     model.put("cantProductos",cantProducto);
		 model.put("datosPizzaPersonalizada", datos);
		
		return new ModelAndView("personalizarPizza",model);
	}
	
	@RequestMapping(path="/agregar-personalizar-pizza",method= RequestMethod.POST)
	public ModelAndView irADetallePersonalizarPizza(@ModelAttribute("datosPizzaPersonalizada") DatosPizzaPersonalizada datos, @ModelAttribute("cantDeProducto") int cantidadPersonalizado) {
		ModelMap model = new ModelMap();
		Usuario usuario = servicioUsuario.getUsuario();
		
		List<Integer> listaDePorciones=new ArrayList<Integer>();
		listaDePorciones.add(datos.getPorcion1());
		listaDePorciones.add(datos.getPorcion2());
		listaDePorciones.add(datos.getPorcion3());
		listaDePorciones.add(datos.getPorcion4());
		listaDePorciones.add(datos.getPorcion5());
		listaDePorciones.add(datos.getPorcion6());
		listaDePorciones.add(datos.getPorcion7());
		listaDePorciones.add(datos.getPorcion8());
	
		List<Producto> listaProductos = new ArrayList<Producto>();
		TipoPersonalizado productosPersonalizado = new TipoPersonalizado();
		
		for(int i=0;i<listaDePorciones.size(); i++) {
			Producto producto = servicioProducto.validarExistenciaProductoPor(listaDePorciones.get(i));

			listaProductos.add(producto);
		}
		servicioProducto.calcularPrecioPorUnidad(listaProductos);
		productosPersonalizado = servicioPersonalizada.agregarProductoPersonalizado(listaProductos);
		TipoPersonalizado productoPersonalizado = servicioPersonalizada.buscarProductoPersonalizadoPorCodigoGenerado(productosPersonalizado.getCodigoPersonalizado());
		//servicioPersonalizada.sumarTotalDePorciones(productoPersonalizado);
		
		if(cantidadPersonalizado>=1) {
			servicioCarrito.agregarProductoPersonalizadoAlCarrito(usuario,productoPersonalizado,cantidadPersonalizado);
			List<Carrito> listaDeCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuario);
			Double sumaTotalDelCarrito=servicioCarrito.sumarElTotalDeLosProductos(listaDeCarrito);
            int cantidadProductos= servicioCarrito.sumarCantidadDeProductosProductos(listaDeCarrito);
           
            model.put("cantProductos",cantidadProductos);
            model.put("sumaTotalDelCarrito",sumaTotalDelCarrito);
            model.put("msg", "Se agrego el producto al carrito de compras");
		}else  {
            model.put("msg", "selecciona la cantidad deseada");
        }
		
		
		model.put("listaDeProductosPrueba", listaProductos);
		model.put("datosPizzaPersonalizada", listaDePorciones);
		
		return new ModelAndView("redirect:/personalizar-pizza",model);
	}
	
	
}
