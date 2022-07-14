package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioHome;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorDeEstadoDelPedido {
	private ServicioUsuario servicioUsuario;
	private ServicioHome servicioHome;
	
	@Autowired
	public ControladorDeEstadoDelPedido(ServicioUsuario servicioUsuario, ServicioHome servicioHome) {
		this.servicioUsuario = servicioUsuario;
		this.servicioHome = servicioHome;
	}

	@RequestMapping(path="/estado-de-pedido")
	public ModelAndView verEstadoDePedido() {
		ModelMap model=new ModelMap();
		model.put("usuario", servicioUsuario.getUnicoUsuario().getNombre());
		return new ModelAndView("estadoDePedido", model);
	}
	
	@RequestMapping(path = "/enviar-comentario", method = RequestMethod.POST)
	public ModelAndView enviarComentario(@ModelAttribute("comentario") String comentario) {
		Usuario usuario=servicioUsuario.getUnicoUsuario();
		servicioHome.addComentario(usuario, comentario);
		return new ModelAndView("redirect:/historial-de-pedidos");
	}

}
