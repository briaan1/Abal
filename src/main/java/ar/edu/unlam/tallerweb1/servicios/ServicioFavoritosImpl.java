package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFavorito;

@Service @Transactional
public class ServicioFavoritosImpl implements ServicioFavoritos {
	private RepositorioFavorito repositorioFavorito;

	@Autowired
	public ServicioFavoritosImpl(RepositorioFavorito repositorioFavorito) {
		this.repositorioFavorito = repositorioFavorito;
	}

	@Override
	public List<Favorito> getListaDeFavoritos(int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean agregarAFavorito(Usuario usuario, Producto producto) {
		Favorito favorito=new Favorito();
		favorito.setUsuario(usuario);
		favorito.setProducto(producto);
		return repositorioFavorito.agregarAFavorito(favorito);
	}

	@Override
	public Favorito validarExistenciaProductoPor(Usuario usuario, Producto producto) {
		Favorito favorito = repositorioFavorito.buscarFavorito(usuario.getId(), producto.getId());
		if(favorito==null) {
			return null;
		}else {
			return favorito;
		}
		
	}
	
	@Override
	public List<Favorito> getListaDeFavoritos() {
			List<Favorito> listaDeFavoritos=repositorioFavorito.listarFavoritos();
			if(listaDeFavoritos.size()==0) {
				return new ArrayList<Favorito>(); 
			}else {
				return listaDeFavoritos;
			}
		}

	@Override
	public List<Producto> listarFavoritos(Usuario usuario) {
		List<Producto> listaDeFavoritos = repositorioFavorito.listarFavoritos(usuario);
		if(listaDeFavoritos.size()!=0) {
			return listaDeFavoritos; 
		}else {
			return null;
		}
	}

	@Override
	public List<Producto> listarFavoritos(Usuario usuario, String categoria) {
		List<Producto> listaDeFavoritos = repositorioFavorito.listarFavoritos(usuario, categoria);
		if(listaDeFavoritos.size()!=0) {
			return listaDeFavoritos; 
		}else {
			return null;
		}
	}

	@Override
	public List<Producto> listarProductosSinFavoritos(Usuario usuario, String categoria) {
		List<Producto> listaDeFavoritos = repositorioFavorito.listarProductosSinFavoritos(usuario, categoria);
		if(listaDeFavoritos.size()!=0) {
			return listaDeFavoritos; 
		}else {
			return new LinkedList<>();
		}
	}

	@Override
	public boolean eliminarFavorito(Favorito favorito) {
		return repositorioFavorito.eliminarFavorito(favorito);
	}
	

}
