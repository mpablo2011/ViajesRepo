package bean.srv;
import java.util.List;

import bean.Productos;
import bean.dao.HibernateProductoDAO;


public class ProductoSRV {
	
	
	private static HibernateProductoDAO dao;
	static {
		dao = HibernateProductoDAO.getInstancia();
	}
		
	public Productos getProductoPorCodigo(int codigo) {
		return dao.getProductoPorCodigo(codigo);
	}
	
	public void grabarProducto(Productos producto) {
		dao.grabarProducto(producto);
	}
	
	public List<Productos> getProductos()
	{
		return dao.getProductos();
	}
}
