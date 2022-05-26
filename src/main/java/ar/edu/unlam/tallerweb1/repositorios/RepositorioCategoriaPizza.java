package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Producto;

public interface RepositorioCategoriaPizza {
	List<Producto> listar(String categoria);
}
