package hbt;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import bean.*;

 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {	
        	Configuration config = new Configuration();
            config.addAnnotatedClass(Cliente.class);
            config.addAnnotatedClass(Productos.class);
            config.addAnnotatedClass(Alojamientos.class);
            config.addAnnotatedClass(Pasajes.class);
            config.addAnnotatedClass(PaqueteTuristico.class);
            config.addAnnotatedClass(VisitasTuristicas.class);
            config.addAnnotatedClass(Ventas.class);    
            config.addAnnotatedClass(ItemVenta.class);    
            sessionFactory = config.buildSessionFactory();    
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
