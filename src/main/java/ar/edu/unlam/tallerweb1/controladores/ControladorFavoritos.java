package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;

import java.util.List;

@Controller
public class ControladorFavoritos {
	
	private ServicioFavoritos servicioDeFavoritos;
	@Autowired
    public ControladorFavoritos(ServicioFavoritos servicioDeFavoritos) {
    	this.servicioDeFavoritos=servicioDeFavoritos;
	}

	@RequestMapping(path="/favorito")
    public ModelAndView irAFavorito()
    {
        ModelMap model = new ModelMap();
        List<Favorito> listaDeProductoDeFavorito = servicioDeFavoritos.getListaDeFavoritos();

        if(listaDeProductoDeFavorito.size()!=0) {
            model.put("listaDePizzaFavoritas", listaDeProductoDeFavorito);
        }else {
            model.put("mensaje", "No hay productos para mostrar");
        }
        return new ModelAndView("favorito");
    }
}
