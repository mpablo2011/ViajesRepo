package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import bean.Cliente;
import bean.Views.ClienteView;
import bean.Views.PaqueteView;
import bean.Views.ProductoView;
import bean.Views.VentaView;

public interface TDAManejoDatos extends Remote{
	
	public Cliente buscarCliente(int dni)  throws RemoteException;
	
	public int altaCliente(int dni, String nombre, int telefono, String mail) throws RemoteException;
	
	public int bajaCliente(int dni)  throws RemoteException;
	
	public ProductoView getProductoPorCodigo(int codigo) throws RemoteException;
	
	public void grabarAlojamiento(String descripcion, String fechaDesde,String fechaHasta, String nombre, float precio, String ubicacion) throws RemoteException;
	
	public void grabarPasaje(String descripcion, String fecha, String aerolinea, String origen, String destino, float precio) throws RemoteException;
	
	public void grabarVisita(String descripcion, String fecha, String nombre,String ubicacion,float precio) throws RemoteException;
	
	public void grabarPaquete(PaqueteView paqueteVw) throws RemoteException;
	
	public void cargaInicial() throws RemoteException;
	
	public List<Cliente> getClientes() throws RemoteException;
	
	public void addCliente(Cliente cliente) throws RemoteException;
	
	public int VincularClienteAVenta(int dni) throws RemoteException;
	
	public void agregarProducto(int codproducto, int cant) throws RemoteException;
	
	public VentaView getVentaView() throws RemoteException;
	
	public ClienteView getClienteView() throws RemoteException;
	
	public Vector getItemVentaVector() throws RemoteException;
	
	public void grabarVenta() throws RemoteException;
	
	public Object[][] getVentas() throws RemoteException;
		
	public Object[][] getProductos() throws RemoteException;
}
