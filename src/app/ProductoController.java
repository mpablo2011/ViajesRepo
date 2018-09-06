package app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import bean.Alojamientos;
import bean.PaqueteTuristico;
import bean.Pasajes;
import bean.Productos;
import bean.Ventas;
import bean.VisitasTuristicas;
import bean.Views.PaqueteView;
import bean.Views.ProductoView;
import bean.Views.VentaView;
import bean.srv.ProductoSRV;
import bean.srv.VentaSRV;

public class ProductoController {
	private static ProductoController instancia;

	public static ProductoController getInstancia() {
		if (instancia == null) {
			instancia = new ProductoController();
		}
		return instancia;
	}
	
	private ProductoController()
	{
		
	}
	
	public ProductoView getProductoPorCodigo(int codigo) {
		Productos producto = new ProductoSRV().getProductoPorCodigo(codigo);
		
		if (producto != null)
		{
			ProductoView prodView = producto.getView();
			String clase = producto.getClass().getSimpleName();
			
			if(clase.equals("PaqueteTuristico"))
				prodView.setEsPaquete(true);
			else
				prodView.setEsPaquete(false);
			
			return prodView;
		}
		
		return null;		
	}
	
	public void grabarAlojamiento(String descripcion, String fechaDesde,String fechaHasta, String nombre, float precio, String ubicacion)
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");	        
			 	          
			Productos producto = new Alojamientos(descripcion,formatter.parse(fechaDesde),formatter.parse(fechaHasta),nombre,precio,ubicacion);
			
			ProductoSRV srv = new ProductoSRV();
			
			srv.grabarProducto(producto);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void grabarPasaje(String descripcion, String fecha, String aerolinea, String origen, String destino, float precio)
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");	        
	         
			Productos producto = new Pasajes(descripcion,formatter.parse(fecha), aerolinea, origen, destino, precio);
			
			ProductoSRV srv = new ProductoSRV();
			
			srv.grabarProducto(producto);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void grabarVisita(String descripcion, String fecha, String nombre,String ubicacion,float precio)
	{
		try
		{			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");	        
	         
			Productos producto = new VisitasTuristicas(descripcion,formatter.parse(fecha),nombre,ubicacion,precio);
			
			ProductoSRV srv = new ProductoSRV();
			
			srv.grabarProducto(producto);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void grabarPaquete(PaqueteView paqueteVw) {
		
		List<Productos> lista = new ArrayList<Productos>();
		ProductoSRV srv = new ProductoSRV();
		
		for (ProductoView  prodVw: paqueteVw.getProductosView())
		{			 
			Productos prod = srv.getProductoPorCodigo(prodVw.getCodigoProducto());
			
			if (prod != null)
				lista.add(prod);
		}
		
		srv.grabarProducto(new PaqueteTuristico(paqueteVw.getDescripcion(),paqueteVw.getDescuento(),lista));
	}				
	
	public Vector<Vector<String>> obtenerProductos() 
	{
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		
		ProductoSRV srv = new ProductoSRV();
		List<Productos> productos = srv.getProductos();
		
		for(Productos p : productos) {
			vector.add(p.ProductoToVector());
		}
		
		return vector;		
	}
}
