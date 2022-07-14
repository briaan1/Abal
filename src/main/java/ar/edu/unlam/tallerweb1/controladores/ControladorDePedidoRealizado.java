package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.DetalleDePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorDePedidoRealizado {
	private ServicioUsuario servicioUsuario;
	private ServicioPedido servicioPedido;
	
	@Autowired
	public ControladorDePedidoRealizado(ServicioUsuario servicioUsuario, ServicioPedido servicioPedido) {
		this.servicioUsuario = servicioUsuario;
		this.servicioPedido = servicioPedido;
	}

    @RequestMapping(path = "/pedido-realizado")
    public ModelAndView irAPedidoRealizado(@RequestParam("idPedido") int idPedido) {
    	ModelMap model=new ModelMap();
	     Usuario usuario=servicioUsuario.getUsuario();
	     List<DetalleDePedido> listaDeProductosDelPedido=servicioPedido.getListaDeProductos(idPedido);
	     List<DetalleDePedido> listaDeProductoPersonalizado=servicioPedido.getListaDeProductosPersonalizados(idPedido);
	     List<TipoPersonalizado> listaDeTipoPersonalizado=servicioPedido.getListaDeTipoPersonalizado(listaDeProductoPersonalizado);
	     
	     model.put("listaDeTipoPersonalizado", listaDeTipoPersonalizado);
	        	Double sumaTotal= servicioPedido.sumarElTotalDeLosProductos(listaDeProductosDelPedido);
	        	sumaTotal+=servicioPedido.sumarElTotalDeTipoPersonalizado(listaDeTipoPersonalizado);
	        	Pedido pedido= servicioPedido.getPedido(idPedido);
	        	model.put("pedido", pedido);
	        	model.put("listaDeProductosDelPedido", listaDeProductosDelPedido);
	            model.put("total", sumaTotal);
	         

	     model.put("usuario", usuario.getNombre());
	     
        return new ModelAndView("pedidoRealizado", model);
    }




}
