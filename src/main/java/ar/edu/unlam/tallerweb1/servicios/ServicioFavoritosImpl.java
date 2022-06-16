package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
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
	public Boolean agregarAFavorito(int idProducto) {
		return repositorioFavorito.agregarAFavorito(idProducto);
	}

	@Override
	public Producto validarExistenciaProductoPor(int idProducto) {
		Producto productoEncontradoEnFavoritos = repositorioFavorito.buscarFavoritoPorId(idProducto);
		if(productoEncontradoEnFavoritos==null) {
			return null;
		}else {
			return productoEncontradoEnFavoritos;
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

}
