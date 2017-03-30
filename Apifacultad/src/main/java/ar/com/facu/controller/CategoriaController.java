package ar.com.facu.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.facu.domain.model.Categoria;
import ar.com.facu.domain.service.CategoriaService;
import ar.com.facu.empleos.config.cache.CacheControl;
import ar.com.facu.empleos.config.cache.CachePolicy;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
    @Autowired
    CategoriaService dataServices;

    static final Logger logger = Logger.getLogger(CategoriaController.class);
	
    
	@CacheControl(maxAge = 300, policy = CachePolicy.PUBLIC)	
    @RequestMapping(value = "/getCategorias", method = RequestMethod.GET)
    public  ResponseEntity<List<Categoria>>  getCategorias() throws Exception {              	            	
      return  new ResponseEntity<List<Categoria>>(dataServices.getLisCategorias(), HttpStatus.OK);             
    }

}
