package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
    public List<Carrito> listarLosProductosDelCarrito(Usuario usuario) {
        return sessionFactory.getCurrentSession().createCriteria(Carrito.class)
                .add(Restrictions.eq("usuarioCarrito.id",usuario.getId()))
                .list();
    }

    @Override
    public boolean agregarUnProductoAlCarrito(Carrito carrito) {
        sessionFactory.getCurrentSession().save(carrito);
        return true;
    }

    @Override
    public Carrito buscarCarrito(int idCarrito) {
        return (Carrito) sessionFactory.getCurrentSession().createCriteria(Carrito.class)
                .add(Restrictions.eq("id",idCarrito))
                .uniqueResult();
    }

    @Override
    public void eliminarCarrito(Carrito carrito) {
        sessionFactory.getCurrentSession().delete(carrito);

    }


}
