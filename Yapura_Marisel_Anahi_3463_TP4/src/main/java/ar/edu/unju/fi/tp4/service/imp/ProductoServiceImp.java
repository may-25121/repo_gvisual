package ar.edu.unju.fi.tp4.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;



@Service
public class ProductoServiceImp implements IProductoService{
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	
	@Autowired
	private Producto producto;
	
	List<Producto> productos = new ArrayList<Producto>();
	
	@Override
	public Producto getProducto() {
		LOGGER.info("SERVICE: IProductoService -> ProductoServiceImp");
		LOGGER.info("METHOD: getProducto()");
		LOGGER.info("RESULT: devuelve un objeto producto");
		return this.producto;
	}
	
	@Override
	public void addProducto(Producto producto) {
		LOGGER.info("SERVICE: IProductoService -> ProductoServiceImp");
		LOGGER.info("METHOD: addProducto()");
		LOGGER.info("RESULT: agrega un objeto producto a la lista");
		this.productos.add(producto);
	}

	@Override
	public Producto getUltimoProducto() {
		int indiceUltimoProducto=productos.size() - 1;
		Producto producto=productos.get(indiceUltimoProducto);
		LOGGER.info("SERVICE: IProductoService -> ProductoServiceImp");
		LOGGER.info("METHOD: getUltimoProducto()");
		LOGGER.info("RESULT: devuelve el ultimo producto agregado");
		return producto;
	}

	@Override
	public List<Producto> getAllProductos() {
		LOGGER.info("SERVICE: IProductoService -> ProductoServiceImp");
		LOGGER.info("METHOD: getAllProductos()");
		LOGGER.info("RESULT: devuelve una lista de los productos agregados");
		return this.productos;
	}

}
