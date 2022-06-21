package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import static org.assertj.core.api.Assertions.*;

public class RepositorioFavoritoTest extends SpringTest{
	
	private Usuario usuario;

    @Autowired
    private RepositorioFavorito repositorioFavorito;
    
    @Test @Transactional @Rollback
<<<<<<< Updated upstream
    public void listarLosFavoritosDeUnUsuario() {
        dadoQueExistenFavoritos(2, 3);     
        List<Producto> listaDeFavoritos = cuandoListoLosFavoritosDeUnUsuario(usuario);
        entoncesMeDevuelveLaListaCompleta(listaDeFavoritos, 3);
    }

    private void entoncesMeDevuelveLaListaCompleta(List<Producto> listaDeFavoritos, int cantidadFavoritos) {
=======
    public void queAlListarLosFavoritosDeUnUsuarioPorIdMeDevuelvaUnaLista() {
        dadoQueExistenFavoritos(1, 3);     
        List<Favorito> listaDeFavoritos = cuandoListoLosFavoritosDeUnUsuario(1);
        entoncesMeDevuelveLaListaCompleta(listaDeFavoritos, 3);
    }

    @Test @Transactional @Rollback
    public void queUnUsuarioNoTengaFavoritos() {
        dadoQueNoExistenFavoritosParaElUsuario(3);     
        List<Favorito> listaDeFavoritos = cuandoListoLosFavoritosDeUnUsuario(3);
        entoncesMeDevuelveUnaListaVacia(listaDeFavoritos, 0);
    }
    
    private void entoncesMeDevuelveLaListaCompleta(List<Favorito> listaDeFavoritos, int cantidadFavoritos) {
>>>>>>> Stashed changes
		assertThat(listaDeFavoritos).hasSize(cantidadFavoritos);
	}

<<<<<<< Updated upstream
	private List<Producto> cuandoListoLosFavoritosDeUnUsuario(Usuario usuario) {
		
		return repositorioFavorito.listarFavoritos(usuario);
=======
	private List<Favorito> cuandoListoLosFavoritosDeUnUsuario(int idUsuario) {
		return repositorioFavorito.listarFavoritosPorId(idUsuario);
>>>>>>> Stashed changes
	}

	private void dadoQueExistenFavoritos(int idUsuario, int cantidadFavoritos) {
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
       
       for(int i=0;i<cantidadFavoritos;i++) {
            Producto producto=new Producto ();
	        producto.setId(1);
	        Favorito favorito=new Favorito();
	        favorito.setProducto(producto);
	        favorito.setUsuario(usuario);
	        session().save(usuario);
	        session().save(producto);
	        session().save(favorito);
        }
    }
	
	private void entoncesMeDevuelveUnaListaVacia(List<Favorito> listaDeFavoritos, int i) {
		assertThat(listaDeFavoritos).hasSize(0);
	}

	private void dadoQueNoExistenFavoritosParaElUsuario(int idUsuario) {
		 Usuario usuario = new Usuario();
	     usuario.setId(idUsuario); 
	     session().save(usuario);
	}
	
}