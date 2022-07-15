package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorCarrito {
    private ServicioUsuario servicioUsuario;
    private ServicioCarrito servicioCarrito;

    @Autowired
    public ControladorCarrito(ServicioUsuario servicioUsuario, ServicioCarrito servicioCarrito) {
        this.servicioUsuario = servicioUsuario;
        this.servicioCarrito = servicioCarrito;
    }

    @RequestMapping(path = "/carrito", method = RequestMethod.GET)
    public ModelAndView irAlCarrito(@RequestParam(value = "msg", required = false) String mensaje) {
        ModelMap model=new ModelMap();
        model.put("msg", mensaje);
        Usuario usuario=servicioUsuario.getUsuario();
        List<Carrito> listaDeProductosDelCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuario);
        double sumaTotalDelCarrito=servicioCarrito.sumarElTotalDeLosProductos(listaDeProductosDelCarrito);
        int cantProducto=servicioCarrito.sumarCantidadDeProductosProductos(listaDeProductosDelCarrito);
        model.put("sumaTotalDelCarrito",sumaTotalDelCarrito);
        model.put("cantProductos",cantProducto);


        if(listaDeProductosDelCarrito.size()==0) {
            model.put("msg", "No hay productos en el carrito");
        }else {
            Double sumaTotal= servicioCarrito.sumarElTotalDeLosProductos(listaDeProductosDelCarrito);
            int sumaDeLosProductosDelCarrito=servicioCarrito.sumarCantidadDeProductosProductos(listaDeProductosDelCarrito);
           model.put("cantProductos",sumaDeLosProductosDelCarrito);
            model.put("listaDeProductosDelCarrito", listaDeProductosDelCarrito);
            model.put("total", sumaTotal);
        }

        model.put("usuario", usuario.getNombre());
        model.put("eliminarDelCarrito", "Eliminar del carrito");

        return new ModelAndView("carrito", model);
    }

    @RequestMapping(path = "/eliminar-del-carrito", method = RequestMethod.POST)
    public ModelAndView clickEnEliminarDelCarrito(@ModelAttribute("idCarrito") int idCarrito) {
        ModelMap model=new ModelMap();
        Carrito carrito=servicioCarrito.validarExistenciaProductoPor(idCarrito);
        servicioCarrito.eliminarDelCarrito(carrito);
        model.put("msg", "Se elimino el producto del carrito");

        return new ModelAndView("redirect:/carrito", model);
    }
}
