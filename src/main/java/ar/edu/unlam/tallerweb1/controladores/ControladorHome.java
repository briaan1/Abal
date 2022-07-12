package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
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
	private ServicioUsuario servicioUsuario;
	private ServicioCarrito servicioCarrito;

	@Autowired
	public ControladorHome(ServicioHome servicioHome, ServicioUsuario servicioUsuario,ServicioCarrito servicioCarrito) {
		this.servicioHome = servicioHome;
		this.servicioUsuario=servicioUsuario;
		this.servicioCarrito=servicioCarrito;
	}


	@RequestMapping(path = "/home")
	public ModelAndView irAlHome() {
		ModelMap model = new ModelMap();
            Usuario usuario= servicioUsuario.getUnicoUsuario();
			List <Carrito> listaDeProductos=servicioCarrito.getListaDeProductosDelCarrito(usuario);
			double sumaTotalDelCarrito=servicioCarrito.sumarElTotalDeLosProductos(listaDeProductos);

		int cantProducto=servicioCarrito.sumarCantidadDeProductosProductos(listaDeProductos);

		List<Comentario> listaDeComentarios = servicioHome.getListaDeComentarios();
		if(listaDeComentarios.size()==0) {
			model.put("msg", "No hay comentarios");
		}else {
			model.put("listaDeComentarios", listaDeComentarios);
		}
		model.put("cantProductos",cantProducto);
		model.put("usuario",usuario.getNombre());
		model.put("sumaTotalDelCarrito",sumaTotalDelCarrito);
		return new ModelAndView("home",model);
	}



}