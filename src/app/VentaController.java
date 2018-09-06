package app;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import bean.Cliente;
import bean.ItemVenta;
import bean.Productos;
import bean.Ventas;
import bean.Views.ClienteView;
import bean.Views.ItemVentaView;
import bean.Views.ProductoView;
import bean.Views.VentaView;
import bean.srv.ClienteSRV;
import bean.srv.ProductoSRV;
import bean.srv.VentaSRV;

public class VentaController {
	
	private Ventas venta;
	private static VentaController instancia;

	public static VentaController getInstancia() {
		if (instancia == null) {
			instancia = new VentaController();
		}
		return instancia;
	}
	
	private VentaController() {
		venta = new Ventas();
	}

	public int VincularClienteAVenta(int dni) {
		
		ClienteController cc = ClienteController.getInstancia();
		Cliente cli = cc.buscarCliente(dni);
		
		if(cli == null)
		{	
			return -1;
		}
		else
		{
			venta.setCliente(cli);
			return 1;
		}
		
	}

	public void agregarProducto(int codproducto, int cant) {
		
		Productos producto = new ProductoSRV().getProductoPorCodigo(codproducto);
		ItemVenta iv = new ItemVenta();
		
		iv.setCantidad(cant);
		iv.setProducto(producto);
		
		venta.setItemVenta(iv);
		
	}
	
	public VentaView getVentaView()
	{
		VentaView vv = new VentaView();
		
		vv.setTotalVenta(this.venta.getPrecioTotal());
		
		return vv;
	}
	
	public ClienteView getClienteView()
	{
		ClienteView c = new ClienteView();
		
		if (this.venta.getCliente() != null)
		{
			c.setNombre(this.venta.getCliente().getNombre());
			c.setDni(this.venta.getCliente().getDni());
		}
		else
		{
			c = null;
		}
		
		
		return c;
	}
	
	public Vector getItemVentaVector()
	{
		Vector vector=new Vector();
		vector = this.venta.gerProductosVector();
		return vector;
		
		
	}
	
	public void grabarVenta() 
	{
		VentaSRV srv = new VentaSRV();
		srv.grabarVenta(this.venta);
	}
	
	public Vector<VentaView> obtenerVentasView() 
	{
		Vector<VentaView> VentasView = new Vector<VentaView>();
		VentaSRV srv = new VentaSRV();
		List<Ventas> ventas = srv.obtenerVentas();
		
		
		return VentasView;
		
		
	}
}
