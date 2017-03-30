package ar.com.facu.controller;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.facu.domain.model.Producto;
import ar.com.facu.domain.service.ProductoService;
import ar.com.facu.empleos.config.cache.CacheControl;
import ar.com.facu.empleos.config.cache.CachePolicy;

@Controller
@RequestMapping("/Producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    static final Logger logger = Logger.getLogger(ProductoController.class);
	   
	@CacheControl(maxAge = 300, policy = CachePolicy.PUBLIC)	
    @RequestMapping(value = "/getProductos", method = RequestMethod.GET)
    public  ResponseEntity<List<Producto>>  getProductos() throws Exception {              	            	
      return  new ResponseEntity<List<Producto>>(productoService.getListProductos(), HttpStatus.OK);             
    }



}  