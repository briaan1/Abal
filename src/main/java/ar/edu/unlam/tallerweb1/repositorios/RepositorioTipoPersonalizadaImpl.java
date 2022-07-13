package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;

@Repository
public class RepositorioTipoPersonalizadaImpl implements RepositorioTipoPersonalizada{

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioTipoPersonalizadaImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean guardarProductoPersonalizado(Producto producto) {
		sessionFactory.getCurrentSession().save(producto);
		return true;
	}

	@Override
	public void guardarListaProductosPersonalizado(TipoPersonalizado productoPersonalizado) {
		sessionFactory.getCurrentSession().save(productoPersonalizado);
		
	}

}
