package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {
	Usuario getUsuario();
	Usuario buscarUsuario(String string);
	List<Usuario> listaDeUsuarios();
	void cambiarUsuario(int idUsuario);
}
