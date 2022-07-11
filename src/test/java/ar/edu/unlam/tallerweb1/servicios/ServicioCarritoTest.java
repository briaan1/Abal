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
    public void alSumarLosProductosDelCarritoQueSeMuestreLaSumaTotal(){

        List<Carrito> listaDeCarrito=dadoQueExistentenProductosEnElCarrito();
        Double valorTotalDelProducto=cuandoPidoLaSumaTotalDeLosProductosMeDebuelve(listaDeCarrito);
        entocesLaSumaDeLosProductosDelCarritoes(valorTotalDelProducto,110.0);


    }

    private void entocesLaSumaDeLosProductosDelCarritoes(Double valorTotalDelProducto, double valorEsperado) {
        assertThat(valorTotalDelProducto).isEqualTo(valorEsperado);
    }

    private Double cuandoPidoLaSumaTotalDeLosProductosMeDebuelve(List<Carrito> listaDeCarrito) {
       return  servicioCarrito.sumarElTotalDeLosProductos(listaDeCarrito);
    }

    private List<Carrito> dadoQueExistentenProductosEnElCarrito() {
        Producto producto=new Producto();
        Producto producto1=new Producto();
        Usuario usuario= new Usuario();
        Carrito carrito =new Carrito();
        Carrito carrito1 =new Carrito();
        usuario.setId(1);
        producto.setId(1);
        producto.setPrecio(50.0);
        producto1.setPrecio(60.0);
        producto1.setId(2);
        carrito.setProducto(producto);
        carrito1.setProducto(producto1);
        carrito.setUsuario(usuario);
        carrito.setCantidad(1);
        carrito1.setCantidad(1);
        List<Carrito> listaDeCarrito=new ArrayList<>();
        listaDeCarrito.add(carrito);
        listaDeCarrito.add(carrito1);
        return listaDeCarrito;





    }

    private void entoncesLaListaDelCarritoDeComprasEstaVacia(List<Carrito> listaDeProductosDelCarrito, int cantProductos)
    {
        assertThat(listaDeProductosDelCarrito).hasSize(0);
    }

    private List<Carrito> cuandoPidoLaListaDelCarritoDeCompras() {
        Usuario usuario=new Usuario();
        return servicioCarrito.getListaDeProductosDelCarrito(usuario);

    }

    private void dadoQueNoHayProductosEnElCarritoDeCompras() {
        Usuario usuario =new Usuario();

        when(repositorioCarrito.listarLosProductosDelCarrito(usuario)).thenReturn(new ArrayList<Carrito>());


    }


}
