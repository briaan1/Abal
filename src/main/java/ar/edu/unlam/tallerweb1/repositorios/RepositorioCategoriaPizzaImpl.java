package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Producto;

@Repository
public class RepositorioCategoriaPizzaImpl implements RepositorioCategoriaPizza{
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioCategoriaPizzaImpl(SessionFactory sessionFactory){
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
	public List<Producto> listarProductos() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Producto.class)
				.list();
	}

	@Override
	public Producto buscarPor(int idDeProducto) {
		return (Producto) sessionFactory.getCurrentSession()
				.createCriteria(Producto.class)
				//.createAlias("id", "productoId")
				.add(Restrictions.eq("id", idDeProducto))
				.uniqueResult();
	}




}
