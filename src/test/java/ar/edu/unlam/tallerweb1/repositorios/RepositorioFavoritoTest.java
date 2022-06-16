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
     public void listarPizzasFavoritos(){
        Usuario usuario=new Usuario();
        Producto producto=new Producto();
        Producto producto2=new Producto();
        Producto producto3 =new Producto();
        Favorito favorito=new Favorito();
        Favorito favorito1=new Favorito();
        Favorito favorito2=new Favorito();
        producto.setId(1);
        producto.setId(2);
        producto3.setId(3);
        usuario.setId(1);

        favorito1.setUsuario(usuario);
        favorito2.setUsuario(usuario);
        favorito.setUsuario(usuario);
        favorito1.setProducto(producto2);
        favorito.setProducto(producto);
        favorito2.setProducto(producto3);

        session().save(usuario);
        session().save(producto);
        session().save(producto2);
        session().save(producto3);
        session().save(favorito);
        session().save(favorito1);
        session().save(favorito2);



        List<Favorito> resultado=repositorioFavorito.listarFavoritosPorIdUsuario(1);

        //validacion
        assertThat(resultado).hasSize(2);
    }


}
