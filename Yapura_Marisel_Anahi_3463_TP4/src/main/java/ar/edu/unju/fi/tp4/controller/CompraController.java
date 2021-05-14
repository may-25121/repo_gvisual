package ar.edu.unju.fi.tp4.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.service.ICompraService;
import ar.edu.unju.fi.tp4.service.IProductoService;
//import ar.edu.unju.fi.tp4.service.imp.ProductoServiceImp;
import ar.edu.unju.fi.tp4.controller.CompraController;


@Controller
public class CompraController {
	private static final Log LOGGER = LogFactory.getLog(CompraController.class);


	
	@Autowired
	private ICompraService compraService;
	@Autowired
	private IProductoService productoService;
	

	
	@GetMapping("/compra")
	public String getCompraPage(Model model) {
		LOGGER.info("CONTROLLER: CompraController con /compra invoca al metodo get");
		LOGGER.info("METHOD: getCompraPage()");
		LOGGER.info("RESULT: Se visualiza la página nuevacompra.html");
		model.addAttribute("compra", compraService.getCompra());
	    model.addAttribute("productos", productoService.getAllProductos());
		return "nuevacompra";
	}
	
	@GetMapping("/compra/guardar")
	public String getCompraResultadoPage(Model model, @RequestParam(name="codigo") String codigo, @RequestParam(name="cantidad") String cantidad) {
		LOGGER.info("CONTROLLER: CompraController con /compra/guardar invoca al metodo post");
		LOGGER.info("METHOD: getCompraResultadoPage() -- PARAMS: compra '"+codigo+"' codigo '"+cantidad);
		LOGGER.info("RESULT: Se visualiza la página resultado02.html mostrando el formulario de compras");
		
		Compra compra = new Compra();
		compra.setCantidad(Integer.valueOf(cantidad));
		compra.setProducto(this.productoService.getUnProducto(Integer.valueOf(codigo)));
		compraService.agregarCompra(compra);
		return "resultado02";
	}
	
	
	
	@GetMapping("/compra/listar")
	public String getListarCompraPage(Model model) {
		LOGGER.info("CONTROLLER: CompraController con /compra/listar invoca al metodo get");
		LOGGER.info("METHOD: getListarComprasPage()");
		LOGGER.info("RESULT: Se visualiza la página listarcompras.html, mostrando las compras que se encuentran en la lista");
		model.addAttribute("compras", compraService.obtenerCompras());
	return "listarcompras";
	}
	
	
	/*
	@GetMapping("/compra/nueva")
	public String getNuevaCompraPage(Model model) {
		model.addAttribute("compra", compra);
		return "nuevacompra";
	}
	
	
	public String getProductsPage() {
		ModelAndView model = new ModelAndView("productos");
		model
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView saveCompra(@ModelAttribute("compra") Compra compra ) {
		ModelAndView model = new ModelAndView("compra");
		compraService.saveCompra(compra);
		model.addObject("compra", compraService.getCompras());
		return model;
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getCompraListadoPage() {
		ModelAndView model = new ModelAndView("compra");
		if (compraService.getCompras()==null) {
			compraService.generarListaCompras();
		}
		model.addObject("compra", compraService.getCompras());
		
		return model;
	}*/
	

}
