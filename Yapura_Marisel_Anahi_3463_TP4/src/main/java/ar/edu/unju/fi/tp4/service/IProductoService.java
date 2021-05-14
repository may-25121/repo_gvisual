package ar.edu.unju.fi.tp4.service;

import java.util.List;

import ar.edu.unju.fi.tp4.model.Producto;



public interface IProductoService {
	
	public Producto getProducto();
	
	public void addProducto(Producto producto);
	
	public Producto getUltimoProducto();
	
	public List<Producto> getAllProductos();
	
	public Producto getUnProducto(int codigo);
	
}
