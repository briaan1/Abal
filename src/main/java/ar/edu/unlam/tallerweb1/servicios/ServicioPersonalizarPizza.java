package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Producto;

@Service
public interface ServicioPersonalizarPizza {
	List<Producto> getListaDeProductos(String categoria);
}
