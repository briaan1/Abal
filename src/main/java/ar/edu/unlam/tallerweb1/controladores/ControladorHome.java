package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioHome;
@Controller
public class ControladorHome {
	private ServicioHome servicioHome;
	
	@Autowired
	public ControladorHome(ServicioHome servicioHome) {
		this.servicioHome = servicioHome;
	}
	
	
		@RequestMapping(path = "/home")
		public ModelAndView irAlHome() {
			ModelMap model = new ModelMap();
			List<Comentario> listaDeComentarios = servicioHome.getListaDeComentarios();
			if(listaDeComentarios.size()==0) {
				model.put("msg", "No hay comentarios");
			}else {
				model.put("listaDeComentarios", listaDeComentarios);
			}
			
			return new ModelAndView("home",model);
		}
		
	
	
}
