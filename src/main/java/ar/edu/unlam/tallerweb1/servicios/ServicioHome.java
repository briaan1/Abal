package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.*;

@Service
public interface ServicioHome {
	
	List<Comentario> getListaDeComentarios();

	void addComentario(Usuario usuario, String comentario);

}
