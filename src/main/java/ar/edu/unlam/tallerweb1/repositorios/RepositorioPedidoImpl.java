package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.DetalleDePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPedidoImpl implements RepositorioPedido {
    private SessionFactory sessionFactory;


    @Autowired
    public RepositorioPedidoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @Override
	public void registrarPedido(Pedido pedido) {
		sessionFactory.getCurrentSession().save(pedido);
	}
    
    @Override
	public void registrarDetalleDePedido(DetalleDePedido detalleDePedido) {
    	sessionFactory.getCurrentSession().save(detalleDePedido);
	}

    @Override
	public List<Pedido> getListaDePedidos(Usuario usuario) {
    	return  sessionFactory.getCurrentSession()
    			.createCriteria(Pedido.class)
                .add(Restrictions.eq("usuario.id", usuario.getId()))
                .list();
	}
}
