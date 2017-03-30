package ar.com.facu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.facu.domain.model.Pais;
import ar.com.facu.domain.service.PaisService;
import ar.com.facu.empleos.config.cache.CacheControl;
import ar.com.facu.empleos.config.cache.CachePolicy;


@Controller
public class PaisController {

	
	private final PaisService paisService;
	
	@Autowired
	public PaisController(PaisService paisService) {			
		this.paisService= paisService;		
	}
	@CacheControl(maxAge = 3600, policy = CachePolicy.PUBLIC)	
	@RequestMapping(value = "/paises/*", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Pais>>  getPais() {			
		List<Pais> paises = paisService.getAll();		
		return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
	} 
		
	@CacheControl(maxAge = 3600, policy = CachePolicy.PUBLIC)	
	@RequestMapping(method = RequestMethod.GET, value = "/pais/{paisId}")
	@ResponseBody
	public ResponseEntity<Pais>  getPaisById(@PathVariable Long paisId) {			
		Pais pais = paisService.getPaisById(paisId);				
	 return new ResponseEntity<Pais>(pais, HttpStatus.OK);
	} 
		
}
