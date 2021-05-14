package ar.edu.unju.fi.tp4.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Compra {
	private int id;
	private static int poxIdDisponible = 1;
	@Autowired
	private Producto producto;
	private int cantidad;
	private double total;
	
	public Compra() {
	}

	public Compra(Producto producto, int cantidad) {
		this.id = poxIdDisponible;
		poxIdDisponible++;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = this.getTotal();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static int getPoxIdDisponible() {
		return poxIdDisponible;
	}

	public static void setPoxIdDisponible(int poxIdDisponible) {
		Compra.poxIdDisponible = poxIdDisponible;
	}


	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		double total=this.producto.getPrecio()*this.cantidad;
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
	
}
