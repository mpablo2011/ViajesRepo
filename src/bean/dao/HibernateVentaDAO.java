package bean.dao;

import java.awt.List;
import java.util.Vector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Productos;
import bean.Ventas;
import hbt.HibernateUtil;

public class HibernateVentaDAO {
	private static HibernateVentaDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static HibernateVentaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateVentaDAO();
		} 
		return instancia;
	}
	
	public void grabarVenta(Ventas vta) 
	{
		try
		{
			Session session = sf.openSession();
			session.beginTransaction();
			session.merge(vta);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}			
	}
	
	@SuppressWarnings("deprecation")
	public Vector<Ventas> obtenerVentas(){       
	    try
	    {
			Session session = sf.openSession();
			session.beginTransaction();
	        return (Vector<Ventas>) session.createCriteria(Ventas.class).list();
	        
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}
}
