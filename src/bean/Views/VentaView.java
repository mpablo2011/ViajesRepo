package bean.Views;

import java.io.Serializable;

public class VentaView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float totalVenta;

	public float getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(float f) {
		this.totalVenta = f;
	}
	
	
}

