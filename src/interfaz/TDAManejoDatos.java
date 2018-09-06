package interfaz;

import java.rmi.Remote;
import java.util.List;
import java.util.Vector;

import bean.Cliente;
import bean.Views.ClienteView;
import bean.Views.PaqueteView;
import bean.Views.ProductoView;
import bean.Views.VentaView;

public interface TDAManejoDatos extends Remote{
	
	public Cliente buscarCliente(int dni);
	
	public int altaCliente(int dni, String nombre, int telefono, String mail);
	
	public int bajaCliente(int dni);
	
	public ProductoView getProductoPorCodigo(int codigo);
	
	public void grabarAlojamiento(String descripcion, String fechaDesde,String fechaHasta, String nombre, float precio, String ubicacion);
	
	public void grabarPasaje(String descripcion, String fecha, String aerolinea, String origen, String destino, float precio);
	
	public void grabarVisita(String descripcion, String fecha, String nombre,String ubicacion,float precio);
	
	public void grabarPaquete(PaqueteView paqueteVw);
	
	public void cargaInicial();
	
	public List<Cliente> getClientes();
	
	public void addCliente(Cliente cliente);
	
	public int VincularClienteAVenta(int dni);
	
	public void agregarProducto(int codproducto, int cant);
	
	public VentaView getVentaView();
	
	public ClienteView getClienteView();
	
	public Vector getItemVentaVector();
	
	public void grabarVenta();
	
	public Object[][] getVentas();
		
	public Object[][] getProductos();
}
