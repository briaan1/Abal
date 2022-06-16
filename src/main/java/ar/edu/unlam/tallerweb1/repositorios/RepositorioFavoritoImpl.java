package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

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
                .createCriteria(Favorito.class).createAlias("usuario","usuario").add(restriction.eq("usuario.id",id))
                .list();
	}

	@Override
	public Producto buscarFavoritoPorId(int idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean agregarAFavorito(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
