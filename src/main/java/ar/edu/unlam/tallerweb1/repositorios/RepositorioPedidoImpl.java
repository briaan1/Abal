package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.DetalleDePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;
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

	@Override
	public List<DetalleDePedido> getListaDeProductos(int idPedido) {
		return  sessionFactory.getCurrentSession()
    			.createCriteria(DetalleDePedido.class)
                .add(Restrictions.eq("pedido.id", idPedido))
                .add(Restrictions.eq("idProductoPersonalizado", 0))
                .list();
	}
	@Override
	public List<DetalleDePedido> getListaDeProductosPersonalizados(int idPedido) {
		return  sessionFactory.getCurrentSession()
    			.createCriteria(DetalleDePedido.class)
                .add(Restrictions.eq("pedido.id", idPedido))
                .add(Restrictions.not(Restrictions.eq("idProductoPersonalizado", 0)))
                .list();
	}
	
	@Override
	public TipoPersonalizado getPersonalizado(int idProductoPersonalizado) {
		return  (TipoPersonalizado) sessionFactory.getCurrentSession()
    			.createCriteria(TipoPersonalizado.class)
                .add(Restrictions.eq("id", idProductoPersonalizado))
                .uniqueResult();
	}
	

	@Override
	public Pedido getPedido(int idPedido) {
		return  (Pedido) sessionFactory.getCurrentSession()
    			.createCriteria(Pedido.class)
                .add(Restrictions.eq("id", idPedido))
                .uniqueResult();
	}

	@Override
	public Producto getProductoPersonalizado() {
		return  (Producto) sessionFactory.getCurrentSession()
    			.createCriteria(Producto.class)
                .add(Restrictions.eq("nombre", "Personalizado"))
                .uniqueResult();
	}
}
