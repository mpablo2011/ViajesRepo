package bean.srv;

import bean.Ventas;
import bean.dao.HibernateVentaDAO;;

public class VentaSRV {

	private static HibernateVentaDAO dao;

	static {
		dao = HibernateVentaDAO.getInstancia();
	}
	
	public void grabarVenta(Ventas vta){
		dao.grabarVenta(vta);
	}
}

