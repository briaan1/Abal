package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String estado;
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	private String fecha;
	
	@OneToMany(mappedBy = "pedido")
	private Set<DetalleDePedido> detalleDePedido = new HashSet();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<DetalleDePedido> getDetalleDePedido() {
		return detalleDePedido;
	}

	public void setDetalleDePedido(Set<DetalleDePedido> detalleDePedido) {
		this.detalleDePedido = detalleDePedido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
