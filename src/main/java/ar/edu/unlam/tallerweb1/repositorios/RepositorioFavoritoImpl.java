package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioFavoritoImpl implements RepositorioFavorito{
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioFavoritoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
<<<<<<< Updated upstream
	
	@Override
	public List<Favorito> listarFavoritos() {
		/*return sessionFactory.getCurrentSession()
                .createCriteria(Favorito.class).createAlias("usuario","usuario").add(restriction.eq("usuario.id",id))
                .list();*/
		return null;
	}
=======
>>>>>>> Stashed changes

	@Override
	public Favorito buscarFavorito(int idUsuario, int idProducto) {
		return (Favorito) sessionFactory.getCurrentSession()
                .createCriteria(Favorito.class)
                .add(Restrictions.eq("usuario.id", idUsuario))
                .add(Restrictions.eq("producto.id", idProducto))
                .uniqueResult();
	}

	@Override
	public boolean agregarAFavorito(Favorito favorito) {
		sessionFactory.getCurrentSession().save(favorito);
		return true;
	}

	@Override
<<<<<<< Updated upstream
	public List<Producto> listarFavoritos(Usuario usuario) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Producto.class)
                .createAlias("favoritos","favoritos")
                .add(Restrictions.eq("favoritos.usuario.id", usuario.getId()))
                .list();
	}

}
=======
	public List<Favorito> listarFavoritosPorId(int id) {
		return sessionFactory.getCurrentSession()		
				.createCriteria(Favorito.class)
                .createAlias("usuario","usu")
                .add(Restrictions.eq("usu.id", id))
                .list();
	}

	@Override
	public List<Favorito> listarFavoritos() {
		// TODO Auto-generated method stub
		return null;
	}

}
>>>>>>> Stashed changes
