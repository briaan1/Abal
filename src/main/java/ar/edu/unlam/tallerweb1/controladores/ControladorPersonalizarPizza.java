package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoriaPizza;

@Controller

public class ControladorPersonalizarPizza {
	private ServicioCategoriaPizza servicioCategoriaPizza;
	
	@Autowired
	public ControladorPersonalizarPizza(ServicioCategoriaPizza servicioCategoriaPizza) {
		this.servicioCategoriaPizza = servicioCategoriaPizza;
	}

	@RequestMapping("/personalizar-pizza")
	public ModelAndView irAPersonalizarPizza() {
		ModelMap model = new ModelMap();
		List<Producto> listaDeProducto = servicioCategoriaPizza.getListaDeProductos("pizza");
		if(listaDeProducto!=null) {
			model.put("listaDePizza", listaDeProducto);
		}else {
			model.put("mensaje", "No hay productos para mostrar");
		}
		
		return new ModelAndView("personalizarPizza",model);
	}
	
	
}
