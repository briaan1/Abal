package ar.edu.unlam.tallerweb1.controladores;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller 
public class ControladorCategoriaBebida {
	private ServicioProducto servicioProducto;
    private ServicioFavoritos servicioDeFavorito;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorCategoriaBebida(ServicioProducto servicioProducto, ServicioFavoritos servicioDeFavorito, ServicioUsuario servicioUsuario) {
        this.servicioProducto = servicioProducto;
        this.servicioDeFavorito = servicioDeFavorito;
        this.servicioUsuario = servicioUsuario;
    }
	
    @RequestMapping(value = "/categoriaBebida" ,method = RequestMethod.GET)
    public ModelAndView irABebida(@RequestParam(value = "idFavorito",required = false)Integer idFavorito,
                                  @RequestParam(value = "msg",required = false)String mensaje) {
        ModelMap model=new ModelMap();
        model.put("msg",mensaje);
        Usuario usuario=servicioUsuario.getUsuario();
        List<Producto> listaDeProductos=new LinkedList<>();
        if(usuario != null) {
            List<Producto> listaDeFavoritos=servicioDeFavorito.listarFavoritos(usuario, "bebida");
            listaDeProductos=servicioDeFavorito.listarProductosSinFavoritos(usuario, "bebida");
            model.put("listaDeFavoritos", listaDeFavoritos);
            model.put("usuario", usuario.getNombre());
            model.put("eliminarDeFavoritos", "Eliminar de favoritos");
        }
        else {
            listaDeProductos=servicioProducto.getListaDeProductos("bebida");
        }

        if(listaDeProductos.size()==0) {
            model.put("msg", "No hay productos en esta categoria");
        }else {
            model.put("listaDeProductos", listaDeProductos);
        }

        model.put("titulo","Bebida");

        return new ModelAndView("categoriaBebida",model);
    }
	
	
}