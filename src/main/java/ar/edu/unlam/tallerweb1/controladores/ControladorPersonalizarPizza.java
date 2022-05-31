package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonalizarPizza;

@Controller

public class ControladorPersonalizarPizza {
	private ServicioPersonalizarPizza servicioPersonalizarPizza;
	
	@Autowired
	public ControladorPersonalizarPizza(ServicioPersonalizarPizza servicioPersonalizarPizza) {
		this.servicioPersonalizarPizza = servicioPersonalizarPizza;
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
	
	@RequestMapping(path="/detalle-personalizar-pizza",method= RequestMethod.POST)
	public ModelAndView irADetallePersonalizarPizza(@ModelAttribute("datosPizzaPersonalizada") DatosPizzaPersonalizada datos ) {
		ModelMap model = new ModelMap();
		model.put("datosPizzaPersonalizada", datos);

		return new ModelAndView("detallePizzaPersonalizada",model);
	}
	
	
}
