package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
		if(listaDeComentario!=null) {
			return listaDeComentario;
		}else {
			return new ArrayList<Comentario>();
		}
	}

	@Override
	public void addComentario(Usuario usuario, String comentario) {
		Comentario nuevoComentario=new Comentario();
		nuevoComentario.setUsuario(usuario);
		nuevoComentario.setComentario(comentario);
		nuevoComentario.setNombreUsuario(usuario.getNombre()+" "+usuario.getApellido());
		nuevoComentario.setImagen("persona1.jpg");
		repositorioHome.addComentario(nuevoComentario);
	}

}
