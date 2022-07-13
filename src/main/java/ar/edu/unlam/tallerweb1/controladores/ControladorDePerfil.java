package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorDePerfil {
	private ServicioUsuario servicioUsuario;
	
	@Autowired
	public ControladorDePerfil(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}
	
	@RequestMapping(path = "/perfil")
    public ModelAndView irAPerfil() {
    	
    	ModelMap model=new ModelMap();
    	
    	Usuario usuarioNombre = servicioUsuario.getUnicoUsuario();
    	model.put("nombre", usuarioNombre.getNombre());
    	model.put("apellido", usuarioNombre.getApellido());
    	model.put("domicilio",usuarioNombre.getDomicilio());
    	model.put("localidad", usuarioNombre.getLocalidad());
    	model.put("codPostal", usuarioNombre.getCodPostal());
    	model.put("email", usuarioNombre.getEmail());
    	
        return new ModelAndView("perfil",model);
    }

}
