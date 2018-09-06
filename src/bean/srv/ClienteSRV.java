package bean.srv;

import bean.Cliente;
import bean.dao.HibernateClienteDAO;


public class ClienteSRV {
	private static HibernateClienteDAO dao;
	
	static {
		dao = HibernateClienteDAO.getInstancia();
	}
	
	public void grabarCliente(Cliente cli){
		dao.grabarCliente(cli);
	}
	
	public Cliente getCliente(int cli){
		return dao.buscarCliente(cli);
	}
	
	public int eliminarCliente(Cliente cli){
		return dao.eliminarCliente(cli);
	}
	
	public Cliente buscarCliente(int dni)
	{
		try {
			return dao.buscarCliente(dni);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
