package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;

public interface RepositorioTipoPersonalizada {

	boolean guardarProductoPersonalizado(Producto producto);

	void guardarListaProductosPersonalizado(TipoPersonalizado productoPersonalizado);

}
