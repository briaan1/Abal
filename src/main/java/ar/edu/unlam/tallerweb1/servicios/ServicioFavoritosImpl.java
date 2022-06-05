package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;

@Service @Transactional
public class ServicioFavoritosImpl implements ServicioFavoritos {

	@Override
	public List<Favorito> getListaDeFavoritos(int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean agregarAFavorito(int idProducto) {
		
		return null;
	}

	@Override
	public Producto validarExistenciaProductoPor(int idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

}
