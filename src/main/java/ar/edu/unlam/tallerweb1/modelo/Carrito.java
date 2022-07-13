package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double total;


    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCarrito;

    @ManyToOne()
    @JoinColumn(name = "productoCarrito")
    private Producto productoCarrito;

    @ManyToOne()
    @JoinColumn(name = "productoPersonalizado")
    private TipoPersonalizado productoPersonalizado;
    
    private int cantidad;
    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuarioCarrito;
    }

    public void setUsuario(Usuario usuario) {
        this.usuarioCarrito = usuario;
    }

    public Producto getProducto() {
        return productoCarrito;
    }

    public Usuario getUsuarioCarrito() {
        return usuarioCarrito;
    }

    public void setUsuarioCarrito(Usuario usuarioCarrito) {
        this.usuarioCarrito = usuarioCarrito;
    }

    public void setProducto(Producto producto) {
        this.productoCarrito = producto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

	public Producto getProductoCarrito() {
		return productoCarrito;
	}

	public void setProductoCarrito(Producto productoCarrito) {
		this.productoCarrito = productoCarrito;
	}

	public TipoPersonalizado getProductoPersonalizado() {
		return productoPersonalizado;
	}

	public void setProductoPersonalizado(TipoPersonalizado productoPersonalizado) {
		this.productoPersonalizado = productoPersonalizado;
	}

    
}
