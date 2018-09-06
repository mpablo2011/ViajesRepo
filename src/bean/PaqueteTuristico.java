package bean;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class PaqueteTuristico extends Productos {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch= FetchType.EAGER)
	@JoinTable(name="paquete_producto", joinColumns=@JoinColumn(name="paquete_id"), inverseJoinColumns=@JoinColumn(name="producto_id"))
	private List<Productos> productos;
	private int descuento;
	
	public PaqueteTuristico()
	{
		
	}	
	
	public PaqueteTuristico(String descripcion, int descuento, List<Productos> productos)
	{
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.productos = productos;
	}	
	
	public float getPrecio() {
		float total = 0;
		
		for(Productos prod : this.productos)
		{		
			total = total + prod.getPrecio();
		}
		
		return total - this.descuento;
	}

	public Collection<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
}
