package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service @Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{
	
	private RepositorioUsuario repositorioUsuario;
	@Autowired
	public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}
	
	@Override
	public Usuario getUsuario() {
		return repositorioUsuario.getUsuario();
	}

	@Override
	public Usuario buscarUsuario(String email) {
		return repositorioUsuario.buscar(email);
	}

	@Override
	public List<Usuario> listaDeUsuarios() {
		return repositorioUsuario.listaDeUsuarios();
	}

	@Override
	public void cambiarUsuario(int idUsuario) {
		repositorioUsuario.cambiarUsuario(idUsuario);
	}

	@Override
	public Usuario getUnicoUsuario() {
		return repositorioUsuario.getUnicoUsuario();
	}

}
