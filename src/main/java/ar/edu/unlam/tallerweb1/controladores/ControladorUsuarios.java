package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuarios {
	private ServicioUsuario servicioUsuario;
	
	@Autowired
	public ControladorUsuarios(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}
	
	@RequestMapping("/usuarios")
	public ModelAndView irAUsuarios() {
		ModelMap model = new ModelMap();
		List<Usuario> listaDeUsuarios = servicioUsuario.listaDeUsuarios();
		model.put("usuario", servicioUsuario.getUsuario().getNombre());
		model.put("listaDeUsuarios", listaDeUsuarios);
		return new ModelAndView("usuarios", model);
	}
	
	@RequestMapping(path = "/cambiar-usuario", method = RequestMethod.POST)
	public ModelAndView cambiarUsuario(@ModelAttribute("idUsuario") int idUsuario) {
		servicioUsuario.cambiarUsuario(idUsuario);
		return new ModelAndView("redirect:/usuarios");
	}
	
	
	
	
}
