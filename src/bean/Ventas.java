package bean;

import java.util.ArrayList;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ventas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVenta;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name= "dni")
	private Cliente cliente;
	
	
	@OneToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER) 
	@JoinColumn(name="idVenta", nullable= false)
	private List<ItemVenta> itemsVenta;
	private Date fechaVenta;
	
	public Ventas () {
		itemsVenta = new ArrayList<ItemVenta>();
		this.fechaVenta = new Date();
	}
		
	public float getPrecioTotal() 
	{
		float total = 0;
		
		for(ItemVenta i : this.itemsVenta)
			total = total + (i.getProducto().getPrecio() * i.getCantidad());

		return total;
	}
	
	public int getIdVenta() {
		return idVenta;
	}
	
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemVenta> getItemVenta() {
		return itemsVenta;
	}
	public void setItemVenta(ItemVenta itemVenta) {
		this.itemsVenta.add(itemVenta);
	}
	
	public Date getFechaVenta() {
		return fechaVenta;
	}
	
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	public Vector<Vector<String>> getProductosVector() 
	{
		Vector<Vector<String>> vector=new Vector<Vector<String>>();
		
		for(ItemVenta i : this.itemsVenta)
			vector.add(i.itemToVector());

		return vector;
	}
	
	public Vector<String> ventaToVector() {
		Vector<String> vector=new Vector<String>();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		vector.add(Integer.toString(this.getIdVenta()));
		vector.add(Integer.toString(this.getCliente().getDni()));
		vector.add(this.getCliente().getNombre());
		vector.add(df.format(this.getFechaVenta()));
		vector.add(String.valueOf(this.getPrecioTotal()));
		return vector;
	}
}
