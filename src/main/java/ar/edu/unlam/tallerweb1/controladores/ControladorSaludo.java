package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class ControladorSaludo {

	@RequestMapping(path="/saludo")
	public ModelAndView mostrarSaludo() {
		
		ModelMap modelMap = new ModelMap();
		modelMap.put("saludoKey", "ABAL");
		
		return new ModelAndView("saludo",modelMap);
	}
	
	
}
