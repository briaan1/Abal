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
	
	@OneToMany(mappedBy = "producto_ids")
	private List<Producto> producto = new ArrayList<Producto>();

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
	
	
}