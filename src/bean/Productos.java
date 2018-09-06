package bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import bean.Views.ProductoView;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Productos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoProducto;
	
	@Column (name = "descripcion", length = 100)
	protected String descripcion;
	
	public Productos()
	{
		
	}
	
	public abstract float getPrecio();
		
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCodigoProducto() {
		return this.codigoProducto;
	}
	
	public ProductoView getView()
	{
		return new ProductoView(this.codigoProducto,this.descripcion);
	}
}
