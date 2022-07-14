package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

import java.util.List;

@Controller
public class ControladorDePerfil {
	private ServicioUsuario servicioUsuario;
	private ServicioCarrito servicioCarrito;
	
	@Autowired
	public ControladorDePerfil(ServicioUsuario servicioUsuario,ServicioCarrito servicioCarrito) {
		this.servicioUsuario = servicioUsuario;
		this.servicioCarrito=servicioCarrito;
	}
	
	@RequestMapping(path = "/perfil")
    public ModelAndView irAPerfil() {
    	
    	ModelMap model=new ModelMap();
    	
    	Usuario usuarioNombre = servicioUsuario.getUnicoUsuario();
		List<Carrito> listaDeCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuarioNombre);

		int cantProducto=servicioCarrito.sumarCantidadDeProductosProductos(listaDeCarrito);
		double sumaTotalDelCarrito=servicioCarrito.sumarElTotalDeLosProductos(listaDeCarrito);

		model.put("sumaTotalDelCarrito",sumaTotalDelCarrito);
		model.put("cantProductos",cantProducto);

    	model.put("nombre", usuarioNombre.getNombre());
    	model.put("apellido", usuarioNombre.getApellido());
    	model.put("domicilio",usuarioNombre.getDomicilio());
    	model.put("localidad", usuarioNombre.getLocalidad());
    	model.put("codPostal", usuarioNombre.getCodPostal());
    	model.put("email", usuarioNombre.getEmail());
    	
        return new ModelAndView("perfil",model);
    }

}
