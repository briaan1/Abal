package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorFavoritos {
	
	private ServicioFavoritos servicioDeFavoritos;
	private ServicioUsuario servicioUsuario;
	
	@Autowired
    public ControladorFavoritos(ServicioFavoritos servicioDeFavoritos, ServicioUsuario servicioUsuario) {
    	this.servicioDeFavoritos=servicioDeFavoritos;
    	this.servicioUsuario=servicioUsuario;
	}

    @RequestMapping(path="/favorito")
    public ModelAndView irAFavorito() {
		ModelMap model=new ModelMap();
		Usuario usuario=servicioUsuario.getUsuario();
		model.put("usuario", usuario.getNombre());
		
		List<Producto> listaDeFavoritos=servicioDeFavoritos.listarFavoritos(usuario);
		if(listaDeFavoritos!=null) {
			model.put("listaDeFavoritos", listaDeFavoritos);
		}else {
			model.put("msg", "No hay favoritos");
		}
		
		return new ModelAndView("favorito", model);
    }
}