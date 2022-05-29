package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioHome;

@Service @Transactional
public class ServicioHomeImpl implements ServicioHome{
	private RepositorioHome repositorioHome;
	
	@Autowired
	public ServicioHomeImpl(RepositorioHome repositorioHome) {
		this.repositorioHome = repositorioHome;
	}
	
	@Override
	public List<Comentario> getListaDeComentarios() {
		List<Comentario> listaDeComentario = repositorioHome.listar();
		if(listaDeComentario.size()==0) {
			return new ArrayList<Comentario>();
		}else {
			return listaDeComentario;
		}
	}

}
