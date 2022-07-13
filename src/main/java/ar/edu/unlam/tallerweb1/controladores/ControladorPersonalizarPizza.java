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

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonalizarPizza;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoPersonalizada;

@Controller

public class ControladorPersonalizarPizza {
	private ServicioPersonalizarPizza servicioPersonalizarPizza;
	private ServicioProducto servicioProducto;
	private ServicioFavoritos servicioFavorito;
	private ServicioCarrito servicioCarrito;
	private ServicioTipoPersonalizada servicioPersonalizada;
	
	@Autowired
	public ControladorPersonalizarPizza(ServicioPersonalizarPizza servicioPersonalizarPizza, ServicioProducto servicioProducto, ServicioFavoritos servicioFavorito, ServicioCarrito servicioCarrito, ServicioTipoPersonalizada servicioPersonalizada) {
		this.servicioPersonalizarPizza = servicioPersonalizarPizza;
		this.servicioProducto = servicioProducto;
		this.servicioFavorito = servicioFavorito;
		this.servicioCarrito = servicioCarrito;
		this.servicioPersonalizada = servicioPersonalizada;
	}

	@RequestMapping("/personalizar-pizza")
	public ModelAndView irAPersonalizarPizza() {
		ModelMap model = new ModelMap();
		DatosPizzaPersonalizada datos = new DatosPizzaPersonalizada();
		model.put("datosPizzaPersonalizada", datos);
		List<Producto> listaDeProducto = servicioPersonalizarPizza.getListaDeProductos("pizza");
		if(listaDeProducto.size()!=0) {
			model.put("listaDePizza", listaDeProducto);
		}else {
			model.put("mensaje", "No hay productos para mostrar");
		}
		
		return new ModelAndView("personalizarPizza",model);
	}
	
	@RequestMapping(path="/agregar-personalizar-pizza",method= RequestMethod.POST)
	public ModelAndView irADetallePersonalizarPizza(@ModelAttribute("datosPizzaPersonalizada") DatosPizzaPersonalizada datos) {
		ModelMap model = new ModelMap();
		
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
		List<TipoPersonalizado> listaProductosPersonalizados = new ArrayList<TipoPersonalizado>();
		//int idPersonalizada=0;
		
		for(int i=0;i<listaDePorciones.size(); i++) {
			Producto producto = servicioProducto.validarExistenciaProductoPor(listaDePorciones.get(i));
			//servicioPersonalizada.setProductoPersonalizado(producto);
			//servicioPersonalizada.setProductoPersonalizado(listaDePorciones.get(i));
		
			
			//idPersonalizada += listaDePorciones.get(i);
			listaProductos.add(producto);
			boolean existeListaProductosPersonalizados = servicioPersonalizada.agregarProductoPersonalizado(listaProductos);
			//listaProductosPersonalizados.addAll(producto);
			
		}
		
		//model.put("idPizzaPersonalizada", idPersonalizada);
		model.put("listaDeProductosPrueba", listaProductos);
		model.put("datosPizzaPersonalizada", listaDePorciones);
		return new ModelAndView("detallePizzaPersonalizada",model);
	}
	
	
}
