package ar.edu.unju.fi.tp4.service;

import java.util.List;

import ar.edu.unju.fi.tp4.model.Compra;

public interface ICompraService {
	
	public Compra getCompra();
	
	public void  agregarCompra(Compra compra);
	  
  	//public Compra obtenerUltomaCompra();
  	
  	public List<Compra> obtenerCompras();
	
	/*
	public void saveCompra(Compra compra);
	public void addCliente(Compra compra);
	public List<Compra>getCompras();
	public void generarListaCompras();
	*/

}
