package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCarrito;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ServicioCarritoTest {
    private RepositorioCarrito repositorioCarrito=mock(RepositorioCarrito.class);
    private ServicioCarrito servicioCarrito = new ServicioCarritoImpl(repositorioCarrito);

    @Test
    public void devolverUnaListaVaciaSiNoHayProductosEnElCarritoDeCompras() {
        dadoQueNoHayProductosEnElCarritoDeCompras();
        List<Carrito> listaDeProductosDelCarrito = cuandoPidoLaListaDelCarritoDeCompras();
        entoncesLaListaDelCarritoDeComprasEstaVacia(listaDeProductosDelCarrito,0);
    }

    @Test
    public void alAgregarUnProductoAlCarritoLoAgrega() {

        Carrito carrito=dadoQueExisteUnProductoYUnUsuarioConId(1, 1);
        boolean productoAgregado=cuandoLoAgregoAlCarrito1(carrito);

        //  boolean productoAgregado=cuandoLoAgregoAlCarrito(carrito.getProducto(),carrito.getUsuario());
        //entoncesLoAgrega(carrito.getProducto(),carrito.getUsuario());
        entoncesLoAgrega(productoAgregado);

    }

    private boolean cuandoLoAgregoAlCarrito1(Carrito carrito) {
        when(repositorioCarrito.agregarUnProductoAlCarrito(carrito)).thenReturn(true);
        return servicioCarrito.agregarProductoAlCarrito1(carrito);

    }


    @Test
    public void alAgregarUnProductoQueSeSumeAElTotalDelCarrito(){
        dadoQueExisteUnProductoConUnPrecioYUnUsuarioConId(1,2,55.5);

    }

    private void dadoQueExisteUnProductoConUnPrecioYUnUsuarioConId(int idUsuario, int idProducto, double precio) {
        Usuario usuario=new Usuario();
        usuario.setId(idUsuario);
        Producto producto=new Producto();
        producto.setId(idProducto);
        producto.setPrecio(precio);
        Carrito carrito=new Carrito();
        carrito.setUsuario(usuario);
        carrito.setProducto(producto);


    }

    private void entoncesLoAgrega(boolean productoAgregado) {
        assertThat(productoAgregado).isTrue();
       // Carrito carrito=servicioCarrito.validarExistenciaProductoPor(usuario, producto);
        //assertThat(carrito.getUsuario().getId()).isEqualTo(usuario.getId());
        //assertThat(carrito.getProducto().getId()).isEqualTo(producto.getId());
    }

    private boolean cuandoLoAgregoAlCarrito(Producto producto, Usuario usuario) {

        return servicioCarrito.agregarProductoAlCarrito(usuario, producto);
    }

    private Carrito dadoQueExisteUnProductoYUnUsuarioConId(int idProducto, int idUsuario) {
        Usuario usuario=new Usuario();
        usuario.setId(idUsuario);
        Producto producto=new Producto();
        producto.setId(idProducto);
        Carrito carrito=new Carrito();
        carrito.setUsuario(usuario);
        carrito.setProducto(producto);
     //   when(repositorioCarrito.agregarUnProductoAlCarrito(carrito)).thenReturn(true);
     //   when(repositorioCarrito.buscarCarrito(usuario.getId(), producto.getId())).thenReturn(carrito);
        return carrito;
    }

    private void entoncesLaListaDelCarritoDeComprasEstaVacia(List<Carrito> listaDeProductosDelCarrito, int cantProductos)
    {
        assertThat(listaDeProductosDelCarrito).hasSize(0);


    }

    private List<Carrito> cuandoPidoLaListaDelCarritoDeCompras() {
        return servicioCarrito.getListaDeProductosDelCarrito();

    }

    private void dadoQueNoHayProductosEnElCarritoDeCompras() {
        when(repositorioCarrito.listarLosProductosDelCarrito()).thenReturn(new ArrayList<Carrito>());


    }


}
