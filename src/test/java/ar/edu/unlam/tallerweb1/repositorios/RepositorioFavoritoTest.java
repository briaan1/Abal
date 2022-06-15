package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.*;


import javax.transaction.Transactional;
import java.util.List;

public class RepositorioFavoritoTest  extends SpringTest {
    @Autowired
    RepositorioFavorito repositorioFavorito;

    @Test @Transactional @Rollback
     public void listarPizzasFavoritasDeUnUsuario(){
        Usuario usuario=new Usuario();
        usuario.setId(1);
        Producto producto=new Producto();
        producto.setId(2);
        Producto producto2=new Producto();
        producto.setId(3);
        Favorito favorito=new Favorito();
        Favorito favorito1=new Favorito();
        favorito1.setUsuario(usuario);
        favorito.setUsuario(usuario);

        favorito1.setProducto(producto2);
        favorito.setProducto(producto);
        session().save(usuario);
        session().save(producto);
        session().save(producto2);
        session().save(favorito);


        List<Favorito> resultado=repositorioFavorito.listarFavoritosPorIdUsuario(1);
        //validacion
        assertThat(resultado).hasSize(2);
    }
}
