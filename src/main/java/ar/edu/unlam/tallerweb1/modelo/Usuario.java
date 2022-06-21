package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

<<<<<<< Updated upstream
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
=======
import javax.persistence.*;

@Entity
public class Usuario {

>>>>>>> Stashed changes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String email;
	private String password;
	private String rol;
	private Boolean activo = false;
	
<<<<<<< Updated upstream
	@OneToMany(mappedBy = "usuario")
	private Set<Favorito> favoritos = new HashSet();
	
	public Set<Favorito> getFavoritos() {
		return favoritos;
	}
	public void setFavoritos(Set<Favorito> favoritos) {
		this.favoritos = favoritos;
	}
=======
	private List<Producto> producto;
	
	
>>>>>>> Stashed changes
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
<<<<<<< Updated upstream
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
=======
	
>>>>>>> Stashed changes
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Boolean getActivo() {
		return activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public boolean activo() {
		return activo;
    }

    public void activar() {
		activo = true;
    }
<<<<<<< Updated upstream
}
=======

	/*public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}*/
    
}
>>>>>>> Stashed changes
