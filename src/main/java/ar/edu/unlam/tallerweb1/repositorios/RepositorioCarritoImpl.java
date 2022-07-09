package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioCarritoImpl implements RepositorioCarrito {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCarritoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Carrito> listarLosProductosDelCarrito() {
        return null;
    }

    @Override
    public boolean agregarUnProductoAlCarrito(Carrito carrito) {
       sessionFactory.getCurrentSession().save(carrito);
        return true;
    }

    @Override
    public Carrito buscarCarrito(int idUsuario, int idProducto) {
        return (Carrito) sessionFactory.getCurrentSession().createCriteria(Carrito.class)
                .add(Restrictions.eq("usuario.id",idUsuario))
                .add(Restrictions.eq("productoCarrito.id",idProducto))
                .uniqueResult();
    }
}
