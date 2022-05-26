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
public class ControladorCategoriaPizza {
	private ServicioCategoriaPizza servicioCategoriaPizza;
	@Autowired
	public ControladorCategoriaPizza(ServicioCategoriaPizza servicioCategoriaPizza) {
		this.servicioCategoriaPizza = servicioCategoriaPizza;
	}
	
	@RequestMapping("/pizza")
	public ModelAndView irAPizza() {
		ModelMap model=new ModelMap();
		List<Producto> listaDeProductos=servicioCategoriaPizza.getListaDeProductos("pizza");
		if(listaDeProductos.size()==0) {
			model.put("msg", "No hay productos en esta categoria");
		}else {
			model.put("listaDeProductos", listaDeProductos);
		}
		
		model.put("titulo","Pizza");
		return new ModelAndView("categoriaPizza", model);
	}
}
