package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoriaPizza;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;

@Controller
public class ControladorCategoriaPizza {
	
	private ServicioCategoriaPizza servicioCategoriaPizza;
	private  ServicioFavoritos servicioDeFavorito; 
	
	
	@Autowired
	public ControladorCategoriaPizza(ServicioCategoriaPizza servicioCategoriaPizza, ServicioFavoritos servicioDeFavorito) {
		this.servicioCategoriaPizza = servicioCategoriaPizza;
		this.servicioDeFavorito = servicioDeFavorito;
	}
	
	@RequestMapping(path = "/pizza", method = RequestMethod.GET)
	public ModelAndView irAPizza(@RequestParam(value = "idFavorito", required = false) Integer idFavorito, @RequestParam(value = "msg", required = false) String mensaje) {
		ModelMap model=new ModelMap();
		model.put("msg", mensaje);
		
		List<Producto> listaDeProductos=servicioCategoriaPizza.getListaDeProductos("pizza");
		if(listaDeProductos.size()==0) {
			model.put("msg", "No hay productos en esta categoria");
		}else {
			model.put("listaDeProductos", listaDeProductos);
		}
		
		model.put("titulo","Pizza");
		return new ModelAndView("categoriaPizza", model);
	}

	@RequestMapping(path = "/agregar-favorito", method = RequestMethod.POST)
	public ModelAndView clickEnAgregarFavorito(@ModelAttribute("idFavorito") int idProducto ) {
		ModelMap model=new ModelMap();
		Producto productoEncontrado = servicioCategoriaPizza.validarExistenciaProductoPor(idProducto);
		
		if(productoEncontrado!=null) {
			Producto productoEncontradoEnFavoritos = servicioDeFavorito.validarExistenciaProductoPor(idProducto);
			
			if(productoEncontradoEnFavoritos==null) {
				servicioDeFavorito.agregarAFavorito(idProducto);
				model.put("msg", "Se agrego a favoritos");
			}else {
				model.put("msg", "El producto ya esta agregado");
			}
		}else {
			model.put("msg", "Producto inexistente");
		}
		
		return new ModelAndView("redirect:/pizza", model);
	}

		
}
