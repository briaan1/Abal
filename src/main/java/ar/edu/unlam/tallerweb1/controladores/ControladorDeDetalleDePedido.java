package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
@Controller

public class ControladorDeDetalleDePedido {
	private ServicioUsuario servicioUsuario;
    private ServicioCarrito servicioCarrito;
    private ServicioPedido servicioPedido;
    
    @Autowired
    public ControladorDeDetalleDePedido(ServicioUsuario servicioUsuario, ServicioCarrito servicioCarrito, ServicioPedido servicioPedido) {
		this.servicioUsuario = servicioUsuario;
		this.servicioCarrito = servicioCarrito;
		this.servicioPedido = servicioPedido;
	}

	@RequestMapping(path = "/detalle-de-pedido")
    public ModelAndView irADetalleDePedido() {
		 ModelMap model=new ModelMap();
	     Usuario usuario=servicioUsuario.getUsuario();
	     List<Carrito> listaDeProductosDelCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuario);
	     
	     if(listaDeProductosDelCarrito.size()==0) {
	    	 model.put("msg", "No hay productos en el carrito");
	     }else {
	        	Double sumaTotal= servicioCarrito.sumarElTotalDeLosProductos(listaDeProductosDelCarrito);
	        	model.put("listaDeProductosDelCarrito", listaDeProductosDelCarrito);
	            model.put("total", sumaTotal);
	        }

	     model.put("usuario", usuario.getNombre());
	     model.put("eliminarDelCarrito", "Eliminar del carrito");
	       
        return new ModelAndView("detalleDePedido", model);
    }
	
	@RequestMapping(path = "/pagar-pedido")
    public ModelAndView pagarPedido() {
		Usuario usuario=servicioUsuario.getUsuario();
		List<Carrito> listaDeProductosDelCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuario);
		servicioPedido.registrarPedido(usuario, listaDeProductosDelCarrito);
		servicioCarrito.eliminarProductosDelCarrito(listaDeProductosDelCarrito);
		return new ModelAndView("redirect:/estado-de-pedido");
	}

}
