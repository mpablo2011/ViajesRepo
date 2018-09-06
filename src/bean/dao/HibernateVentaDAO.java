package bean.dao;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	
	public List<Ventas> obtenerVentas(){       
	    try
	    {
	    	Session session = sf.openSession();
			session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Ventas> cq = cb.createQuery(Ventas.class);
			Root<Ventas> matRoot = cq.from(Ventas.class);
			cq.select(matRoot);
			List<Ventas> result = session.createQuery(cq).getResultList();
			session.getTransaction().commit();
			return result;	       
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}
}
