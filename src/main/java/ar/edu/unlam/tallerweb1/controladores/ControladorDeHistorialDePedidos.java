package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorDeHistorialDePedidos {
	private ServicioPedido servicioPedido;
	private ServicioUsuario servicioUsuario;
	
	@Autowired
	public ControladorDeHistorialDePedidos(ServicioPedido servicioPedido, ServicioUsuario servicioUsuario) {
		this.servicioPedido = servicioPedido;
		this.servicioUsuario = servicioUsuario;
	}

	@RequestMapping(path = "/historial-de-pedidos")
    public ModelAndView irAHistorialDePedidos() {
		 ModelMap model=new ModelMap();
	     Usuario usuario=servicioUsuario.getUnicoUsuario();
	     List<Pedido> listaDePedidos=servicioPedido.getListaDePedidos(usuario);
	     
	     if(listaDePedidos.size()==0) {
	    	 model.put("msg", "No hay pedidos");
	     }else {
	        	model.put("listaDePedidos", listaDePedidos);
	        }

	     model.put("usuario", usuario.getNombre());
	       
        return new ModelAndView("historialDePedidos", model);
    }

	
}
