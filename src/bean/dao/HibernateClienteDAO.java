package bean.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Cliente;
import bean.Productos;
import hbt.HibernateUtil;

public class HibernateClienteDAO {
	private static HibernateClienteDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static HibernateClienteDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateClienteDAO();
		} 
		return instancia;
	}
	
	public void grabarCliente(Cliente cli) 
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.merge(cli);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Cliente buscarCliente(int dni)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		Cliente result = (Cliente) session.get(Cliente.class, dni);
		session.getTransaction().commit();
		return result;
	}
	
	public int eliminarCliente(Cliente cli) {
	
		Session session = sf.openSession();
		session.beginTransaction();
		session.remove(cli);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return 1;
	}

}
