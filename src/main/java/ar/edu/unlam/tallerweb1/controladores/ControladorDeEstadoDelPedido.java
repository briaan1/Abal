package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorDeEstadoDelPedido {
	@RequestMapping(path="/estado-de-pedido")
	public ModelAndView verEstadoDePedido() {
		return new ModelAndView("estadoDePedido");
	}

}
