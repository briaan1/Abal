package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import static org.assertj.core.api.Assertions.*;

public class RepositorioFavoritoTest extends SpringTest{

    @Autowired
    private RepositorioFavorito repositorioFavorito;
    
    @Test @Transactional @Rollback
    public void listarLosFavoritosDeUnUsuario() {
        dadoQueExistenFavoritos(2, 3);     
        List<Favorito> listaDeFavoritos = cuandoListoLosFavoritosDeUnUsuario(2);
        entoncesMeDevuelveLaListaCompleta(listaDeFavoritos, 3);
    }

    private void entoncesMeDevuelveLaListaCompleta(List<Favorito> listaDeFavoritos, int cantidadFavoritos) {
		assertThat(listaDeFavoritos).hasSize(cantidadFavoritos);
		
	}

	private List<Favorito> cuandoListoLosFavoritosDeUnUsuario(int idUsuario) {
		
		return repositorioFavorito.listarFavoritos(idUsuario);
	}

	private void dadoQueExistenFavoritos(int idUsuario, int cantidadFavoritos) {
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        
        for(int i=0;i<cantidadFavoritos;i++) {
            Favorito favorito = new Favorito();
            favorito.setUsuario(usuario);
            session().save(favorito);
        }
    }
}