package bean.Views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PaqueteView {
	private List<ProductoView> productos;
	private String descripcion;
	private int descuento;
	
	public PaqueteView()
	{
		this.productos = new ArrayList<ProductoView>();
	}
	
	
	public void agregarProducto(ProductoView producto) {
		productos.add(producto);
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getDescuento() {
		return this.descuento;
	}
	
	public Collection<ProductoView> getProductosView(){
		return this.productos;
	}
}
