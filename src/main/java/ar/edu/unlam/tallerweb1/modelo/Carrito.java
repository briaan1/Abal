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

    public void setProducto(Producto producto) {
        this.productoCarrito = producto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
