package ar.edu.unlam.tallerweb1.repositorios;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;

@Repository
public class RepositorioFavoritoImpl implements RepositorioFavorito{
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioFavoritoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Favorito> listarFavoritos() {
		return sessionFactory.getCurrentSession()
                .createCriteria(Favorito.class)
                .list();
	}

	@Override
	public List<Favorito> listarFavoritosPorIdUsuario(int id) {

		return sessionFactory.getCurrentSession()
				.createCriteria(Favorito.class).createAlias("idfavoritoUsuario","idfavus")
				.add(Restrictions.eq("idfavus.usuario",id))
				.list();

}}


