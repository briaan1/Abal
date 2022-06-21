package ar.edu.unlam.tallerweb1.modelo;

<<<<<<< Updated upstream
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
=======
import javax.persistence.*;
>>>>>>> Stashed changes

@Entity
public class Favorito {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
<<<<<<< Updated upstream
	@ManyToOne()
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name = "producto_id")
	private Producto producto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
=======
>>>>>>> Stashed changes
	
}
