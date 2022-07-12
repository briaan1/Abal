package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;




	@ManyToOne(cascade = CascadeType.ALL)
	private Categoria categoria;
	
	@OneToMany(mappedBy = "producto")
	private Set<Favorito> favoritos = new HashSet();

	@OneToMany(mappedBy = "productoCarrito")
	private Set<Carrito> carrito = new HashSet();
	
	@OneToMany(mappedBy = "productoDetalle")
	private Set<DetalleDePedido> detalleDePedido = new HashSet();


	private Double precio;
	private String imagen;


	public Set<DetalleDePedido> getDetalleDePedido() {
		return detalleDePedido;
	}
	public void setDetalleDePedido(Set<DetalleDePedido> detalleDePedido) {
		this.detalleDePedido = detalleDePedido;
	}
	public Set<Favorito> getFavoritos() {
		return favoritos;
	}
	public void setFavoritos(Set<Favorito> favoritos) {
		this.favoritos = favoritos;
	}


	public Set<Carrito> getCarrito() {
		return carrito;
	}
	public void setCarrito(Set<Carrito> carritos) {
		this.carrito = carritos;
	}
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}