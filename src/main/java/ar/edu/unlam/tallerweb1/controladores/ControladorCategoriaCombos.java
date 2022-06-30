package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorCategoriaCombos {
    private ServicioProducto servicioProducto;
    private ServicioFavoritos servicioDeFavorito;
    private ServicioUsuario servicioUsuario;


    @Autowired
    public ControladorCategoriaCombos(ServicioProducto servicioProducto, ServicioFavoritos servicioDeFavorito, ServicioUsuario servicioUsuario) {
        this.servicioProducto = servicioProducto;
        this.servicioDeFavorito = servicioDeFavorito;
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(value = "/categoriaCombos" ,method = RequestMethod.GET)
    public ModelAndView irACombos(@RequestParam(value = "idFavorito",required = false)Integer idFavorito,
                                  @RequestParam(value = "msg",required = false)String mensaje) {
        ModelMap model=new ModelMap();
        model.put("msg",mensaje);
        Usuario usuario=servicioUsuario.getUsuario();
        List<Producto> listaDeProductos=new LinkedList<>();
        if(usuario != null) {
            List<Producto> listaDeFavoritos=servicioDeFavorito.listarFavoritos(usuario, "combo");
            listaDeProductos=servicioDeFavorito.listarProductosSinFavoritos(usuario, "combo");
            model.put("listaDeFavoritos", listaDeFavoritos);
            model.put("usuario", usuario.getNombre());
            model.put("eliminarDeFavoritos", "Eliminar de favoritos");
        }
        else {
            listaDeProductos=servicioProducto.getListaDeProductos("combo");
        }

        if(listaDeProductos.size()==0) {
            model.put("msg", "No hay productos en esta categoria");
        }else {
            model.put("listaDeProductos", listaDeProductos);
        }

        model.put("titulo","Combos");

        return new ModelAndView("categoriaCombos",model);
    }




    @RequestMapping(path = "/agregar-favorito-combo", method = RequestMethod.POST)
    public ModelAndView clicEnAgregarFavorito(@ModelAttribute("idFavorito") int idProducto ) {
        ModelMap model=new ModelMap();

        Usuario usuario=servicioUsuario.getUsuario();
        Producto productoEncontrado = servicioProducto.validarExistenciaProductoPor(idProducto);

        if(productoEncontrado!=null) {
            Favorito favorito = servicioDeFavorito.validarExistenciaProductoPor(usuario, productoEncontrado);

            if(favorito==null) {
                model.put("msg", "Se agrego a favoritos");
                boolean productoAgregado=servicioDeFavorito.agregarAFavorito(usuario, productoEncontrado);
                if(productoAgregado==true) {
                    model.put("msg", "Se agrego a favoritos");
                }
            }else {
                servicioDeFavorito.eliminarFavorito(favorito);
                model.put("msg", "El producto fue eliminado de favoritos");
            }
        }else {
            model.put("msg", "Producto inexistente");
        }

        return new ModelAndView("redirect:/categoriaCombos", model);
    }

}
