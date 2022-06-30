package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProducto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioCombosTest {

    private RepositorioProducto repositorioProducto=mock(RepositorioProducto.class);
    private ServicioProducto servicioProducto=new ServicioProductoImpl(repositorioProducto);

    @Test
    public void devolverUnaListaVaciaSiNohayproductosEnLaCategoriaPizza() {
        dadoQueNoHayProductosEnLaCategoria("combos");
        List<Producto> listaDeProductos=cuandoPidoLaListaDeProductos("combos");
        entoncesLaListaEstaVacia(listaDeProductos, 0);
    }


    @Test
    public void devolverUnaListaDeproductosDeLaCategoriaCombos() {
        dadoQueExistenLosProductosDeCategoria("combos",5);
        List<Producto> listaDeProductos=cuandoPidoLaListaDeProductos("combos");
        entoncesLaListaEstaVacia(listaDeProductos, 5);
    }

    private void dadoQueExistenLosProductosDeCategoria(String categoria,int cantidadDeCombos) {
        List<Producto> listaDeCombos=new ArrayList<Producto>();
        for(int i=0;i<cantidadDeCombos;i++) {
            listaDeCombos.add(new Producto());
        }

        when(servicioProducto.getListaDeProductos(categoria)).thenReturn(listaDeCombos);

    }

    private void entoncesLaListaEstaVacia(List<Producto> listaDeProductos, int cantidadEsperada) {
        assertThat(listaDeProductos).hasSize(cantidadEsperada);
    }

    private List<Producto> cuandoPidoLaListaDeProductos(String categoria) {
        return servicioProducto.getListaDeProductos(categoria);
    }

    private void dadoQueNoHayProductosEnLaCategoria(String categoria) {
        when(repositorioProducto.listar(categoria)).thenReturn(new ArrayList<Producto>());
    }
}
