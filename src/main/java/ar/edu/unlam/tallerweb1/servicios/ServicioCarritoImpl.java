package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServicioCarritoImpl implements ServicioCarrito {
    private RepositorioCarrito repositorioCarrito;

    @Autowired
    public ServicioCarritoImpl(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }


    @Override
    public List<Carrito> getListaDeProductosDelCarrito(Usuario usuario) {
        List<Carrito> listaDeCarritos=repositorioCarrito.listarLosProductosDelCarrito(usuario);
        if(listaDeCarritos.size()==0) {
            return new ArrayList<Carrito>();
        }else {
            return listaDeCarritos;
        }
    }




    @Override
    public Carrito validarExistenciaProductoPor(int idCarrito) {
       Carrito carrito = repositorioCarrito.buscarCarrito(idCarrito);
        if(carrito==null){
            return null;
        }else{
            return  carrito;
        }

    }

    @Override
    public boolean agregarProductoAlCarrito(Usuario usuario, Producto producto, int cantidadProducto) {
        Carrito carrito=new Carrito();
        carrito.setUsuario(usuario);
        carrito.setProducto(producto);
        carrito.setCantidad(cantidadProducto);
        return repositorioCarrito.agregarUnProductoAlCarrito(carrito);
    }



    @Override
    public boolean agregarProductoAlCarrito1(Carrito carrito) {

        return repositorioCarrito.agregarUnProductoAlCarrito(carrito);
    }

    @Override
    public void eliminarDelCarrito(Carrito carrito) {
            repositorioCarrito.eliminarCarrito(carrito);
    }

    @Override
    public Double sumarElTotalDeLosProductos(List<Carrito> listaDeProductosDelCarrito) {
        Double sumaProductos=0.0;
      for (int i=0;i<listaDeProductosDelCarrito.size();i++){
         sumaProductos += (listaDeProductosDelCarrito.get(i).getProducto().getPrecio()*listaDeProductosDelCarrito.get(i).getCantidad());
      }
        return sumaProductos;
    }

}
