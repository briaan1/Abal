package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
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

import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorCategoriaCombos {
    private ServicioProducto servicioProducto;
    private ServicioFavoritos servicioDeFavorito;
    private ServicioUsuario servicioUsuario;
    private ServicioCarrito servicioCarrito;


    @Autowired
    public ControladorCategoriaCombos(ServicioProducto servicioProducto, ServicioFavoritos servicioDeFavorito, ServicioUsuario servicioUsuario, ServicioCarrito servicioCarrito) {
        this.servicioProducto = servicioProducto;
        this.servicioDeFavorito = servicioDeFavorito;
        this.servicioUsuario = servicioUsuario;
        this.servicioCarrito=servicioCarrito;
    }

    @RequestMapping(value = "/categoriaCombos" ,method = RequestMethod.GET)
    public ModelAndView irACombos(@RequestParam(value = "idFavorito",required = false)Integer idFavorito,
                                  @RequestParam(value = "msg",required = false)String mensaje) {
        ModelMap model=new ModelMap();
        model.put("msg",mensaje);

        List<Producto> listaDeProductos=new LinkedList<>();

        Usuario usuario=servicioUsuario.getUsuario();

        List<Carrito> listaDeCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuario);
        int cantProducto=servicioCarrito.sumarCantidadDeProductosProductos(listaDeCarrito);
        double sumaTotalDelCarrito=servicioCarrito.sumarElTotalDeLosProductos(listaDeCarrito);
        model.put("sumaTotalDelCarrito",sumaTotalDelCarrito);

        model.put("cantProductos",cantProducto);

        if(usuario != null) {
            List<Producto> listaDeFavoritos = servicioDeFavorito.listarFavoritos(usuario, "combo");
            listaDeProductos = servicioDeFavorito.listarProductosSinFavoritos(usuario, "combo");

            model.put("listaDeFavoritos", listaDeFavoritos);
            model.put("usuario", usuario.getNombre());
            model.put("eliminarDeFavoritos", "Eliminar de favoritos");


        }else {
            listaDeProductos=servicioProducto.getListaDeProductos("combo");
        }
        if(listaDeProductos.size()==0) {
            model.put("msg", "No hay productos en esta categoria");
        }else {
            model.put("listaDeProductos", listaDeProductos);
        }

        model.put("titulo","combo");

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


    @RequestMapping(path = "/agregar-carrito-cate-combo", method = RequestMethod.POST)
    public ModelAndView clickEnAgregarAlCarritoDeCompras(  @ModelAttribute("idProductoParaCarrito") int idProducto,
                                                           @ModelAttribute("cantDeProducto")int cantidad ) {
        ModelMap model=new ModelMap();
        Usuario usuario=servicioUsuario.getUsuario();
        Producto productoEncontrado = servicioProducto.validarExistenciaProductoPor(idProducto);
        if(productoEncontrado!=null) {

            //if (seAgrego){
            if (cantidad >= 1) {
                servicioCarrito.agregarProductoAlCarrito(usuario,productoEncontrado,cantidad);
                List<Carrito> listaDeCarrito=servicioCarrito.getListaDeProductosDelCarrito(usuario);
                int cantidadProductos= servicioCarrito.sumarCantidadDeProductosProductos(listaDeCarrito);
                model.put("cantProductos",cantidadProductos);
                model.put("msg", "Se agrego el producto al carrito de compras");

            } else  {
                model.put("msg", "selecciona la cantidad deseada");
            }
        }else {
            model.put("msg", "el producto no se encontro");
        }
        //}else {
        //model.put("msg", "Producto inexistente");
        //}
        return new ModelAndView("redirect:/categoriaCombos", model);
    }

}