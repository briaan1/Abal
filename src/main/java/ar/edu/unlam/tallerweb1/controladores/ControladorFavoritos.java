package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;

@Controller
public class ControladorFavoritos {
	
	/*private ServicioFavoritos servicioDeFavoritos;
	
    public ControladorFavoritos(ServicioFavoritos servicioDeFavoritos) {
    	this.servicioDeFavoritos
	}*/

	@RequestMapping(path="/favorito")
    public ModelAndView irAFavorito()
    {
        return new ModelAndView("favorito");
    }
}
