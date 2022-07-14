package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetalleDePedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int cantidad;
	private int idProductoPersonalizado;
	
	@ManyToOne()
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne()
	@JoinColumn(name = "producto_id")
	private Producto productoDetalle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProductoDetalle() {
		return productoDetalle;
	}

	public void setProductoDetalle(Producto productoDetalle) {
		this.productoDetalle = productoDetalle;
	}

	public int getIdProductoPersonalizado() {
		return idProductoPersonalizado;
	}

	public void setIdProductoPersonalizado(int idProductoPersonalizado) {
		this.idProductoPersonalizado = idProductoPersonalizado;
	}
}
