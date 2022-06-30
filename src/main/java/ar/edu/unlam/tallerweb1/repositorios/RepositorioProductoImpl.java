package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Producto;

@Repository
public class RepositorioProductoImpl implements RepositorioProducto{
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioProductoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Producto> listar(String categoria) {
		return sessionFactory.getCurrentSession()
                .createCriteria(Producto.class)
                .createAlias("categoria","cate")
                .add(Restrictions.eq("cate.nombre", categoria))
                .list();
	}

	@Override
	public Producto validarExistenciaProductoPor(int idProducto) {
		return (Producto) sessionFactory.getCurrentSession()
                .createCriteria(Producto.class)
                .add(Restrictions.eq("id", idProducto))
                .uniqueResult();
	}

}
