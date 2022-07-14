package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Comentario;

@Repository
public class RepositorioHomeImpl implements RepositorioHome{
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioHomeImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Comentario> listar() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Comentario.class)
				.list();
	}

	@Override
	public void addComentario(Comentario comentario) {
		sessionFactory.getCurrentSession().save(comentario);
	}

}
