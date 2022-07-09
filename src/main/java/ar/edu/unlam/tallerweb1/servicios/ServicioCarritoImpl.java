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
    public List<Carrito> getListaDeProductosDelCarrito() {
        List<Carrito> listaDeCarritos=repositorioCarrito.listarLosProductosDelCarrito();
        if(listaDeCarritos.size()==0) {
            return new ArrayList<Carrito>();
        }else {
            return listaDeCarritos;
        }
    }



    @Override
    public Carrito validarExistenciaProductoPor(Usuario usuario, Producto producto) {
       Carrito carrito = repositorioCarrito.buscarCarrito(usuario.getId(),producto.getId());
        if(carrito==null){
            return null;
        }else{
            return  carrito;
        }

    }

    @Override
    public boolean agregarProductoAlCarrito(Usuario usuario, Producto producto) {
        Carrito carrito=new Carrito();
        carrito.setUsuario(usuario);
        carrito.setProducto(producto);
        return repositorioCarrito.agregarUnProductoAlCarrito(carrito);

    }

    @Override
    public boolean agregarProductoAlCarrito1(Carrito carrito) {

        return repositorioCarrito.agregarUnProductoAlCarrito(carrito);
    }
}
