package ar.edu.unlam.tallerweb1.controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorCategoriaCombos;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.servicios.ServicioProducto;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorCategoriaCombosTest {



    private ControladorCategoriaCombos controladorCategoriaCombos;
    private ServicioProducto servicioProducto;
    private ServicioFavoritos servicioFavoritos;
    private ServicioUsuario servicioUsuario;
    @Before
            public void init(){
        servicioProducto = mock(ServicioProducto.class);
        servicioFavoritos=mock(ServicioFavoritos.class);
        servicioUsuario=mock(ServicioUsuario.class);
      controladorCategoriaCombos=new ControladorCategoriaCombos(servicioProducto,servicioFavoritos,servicioUsuario);
        //  controladorCategoriaCombos=new ControladorCategoriaCombos(servicioProducto);

    }


    @Test
    public void alPedirLaCategoriaCombosMeMuestraLaCategoria(){
        ModelAndView model=cuandoPidoLaCategoria();
        entoncesMeLlevaALaVistaCategoria("categoriaCombos",model);
    }
    @Test
    public void alPedirLaListaDeProductosDeCategoriaCombosDevuelveLalistaCompleta() {
        dadoQueExistenLosProductosDeCategoria("combos", 10);
        ModelAndView model=cuandoPidoLaListaDeProductos("combos");
        entoncesMeMuestraLaListaCompleta(model, 10);
    }

    @Test
    public void alAgregarUnFavoritoMeMuestraUnMensajeQueSeAgregoCorrectamente() {
        dadoQueExisteUnProducto(2, "combo");
        ModelAndView model = cuandoLoAgregoAFavorito(2);
        entoncesMeMuestraUnMensaje("Se agrego a favoritos", model);
    }

    @Test
    public void alAgregarUnProductoQueNoExisteAFavoritoMeMuestraUnMensajeDeError() {
        dadoQueNoExisteUnProducto(2, "combos");

        ModelAndView model = cuandoLoAgregoAFavorito(2);

        entoncesMeMuestraUnMensaje("Producto inexistente", model);
    }

    @Test
    public void alSeleccionarEliminarFavoritoQueLoElimineYMuestreMensaje() {
        Usuario usuario=new Usuario();usuario.setId(1);
        Producto producto = new Producto();producto.setId(1);
        dadoQueQuieraElimiarElProducto(usuario, producto);

        ModelAndView model = cuandoLoAgregoAFavorito(1);

        entoncesMeMuestraUnMensaje("El producto fue eliminado de favoritos", model);
    }


    private void dadoQueQuieraElimiarElProducto(Usuario usuario, Producto producto) {
        when(servicioUsuario.getUsuario()).thenReturn(usuario);
        when(servicioProducto.validarExistenciaProductoPor(producto.getId())).thenReturn(producto);
        when(servicioFavoritos.validarExistenciaProductoPor(usuario, producto)).thenReturn(new Favorito());
    }
    private void dadoQueNoExisteUnProducto(int idProducto, String nombreProducto) {
        when(servicioProducto.validarExistenciaProductoPor(idProducto)).thenReturn(null);
    }

    private void entoncesMeMuestraUnMensaje(String mensajeEsperado, ModelAndView model) {
        assertThat(model.getModel().get("msg")).isEqualTo(mensajeEsperado);
    }
    private ModelAndView cuandoLoAgregoAFavorito(int idProducto) {
        return controladorCategoriaCombos.clicEnAgregarFavorito(idProducto);
    }
    private void dadoQueExisteUnProducto(int idProducto, String nombreProducto) {
        Usuario usuario=new Usuario();
        Producto producto = new Producto();
        producto.setId(idProducto);
        producto.setNombre(nombreProducto);
        when(servicioUsuario.getUsuario()).thenReturn(usuario);
        when(servicioProducto.validarExistenciaProductoPor(idProducto)).thenReturn(producto);
        when(servicioFavoritos.validarExistenciaProductoPor(usuario, producto)).thenReturn(null);
        when(servicioFavoritos.agregarAFavorito(usuario, producto)).thenReturn(true);
    }


    private ModelAndView cuandoPidoLaListaDeProductos(String categoria) {
        return controladorCategoriaCombos.irACombos(null,null);
    }
    private void entoncesMeMuestraLaListaCompleta(ModelAndView model, int cantidadEsperada) {
        assertThat(model.getModel().get("listaDeProductos")).asList().hasSize(cantidadEsperada);
    }
    private void dadoQueExistenLosProductosDeCategoria(String categoria, int cantidadDeCombos) {
        List<Producto> listaDeCombos=new ArrayList<Producto>();
        for(int i=0;i<cantidadDeCombos;i++) {
            listaDeCombos.add(new Producto());
        }

        when(servicioProducto.getListaDeProductos(categoria)).thenReturn(listaDeCombos);
    }

    private void entoncesMeLlevaALaVistaCategoria(String vistaEsperada, ModelAndView model) {
        assertThat(model.getViewName()).isEqualTo(vistaEsperada);
    }

    private ModelAndView cuandoPidoLaCategoria() {
        return controladorCategoriaCombos.irACombos(null,null);
    }


}
