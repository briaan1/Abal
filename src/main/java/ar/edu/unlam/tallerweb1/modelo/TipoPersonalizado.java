package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class TipoPersonalizado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int codigoPersonalizado;
	private Double precioTotal;
	
	@OneToMany(mappedBy = "producto_ids")
	private List<Producto> producto = new ArrayList<Producto>();
	
	@OneToMany(mappedBy = "productoPersonalizado")
	private Set<Carrito> carrito = new HashSet();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public int getCodigoPersonalizado() {
		return codigoPersonalizado;
	}

	public void setCodigoPersonalizado(int codigoPersonalizado) {
		this.codigoPersonalizado = codigoPersonalizado;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Set<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(Set<Carrito> carrito) {
		this.carrito = carrito;
	}
	
	
}