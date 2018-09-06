package bean.Views;

import java.io.Serializable;

public class ProductoView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigoProducto;
	private String descripcion;
	private float precio;
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	private boolean esPaquete;
	
	public ProductoView() {
	}
	
	public ProductoView(int codigo, String descripcion) {
		this.setCodigoProducto(codigo);
		this.setDescripcion(descripcion);
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}
	
	public boolean getEsPaquete()
	{
		return this.esPaquete;
	}
	
	public void setEsPaquete(boolean esPaquete)
	{
		this.esPaquete = esPaquete;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}

