package ar.com.facu.controller;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.facu.domain.model.Emprendedor;
import ar.com.facu.domain.model.Pais;
import ar.com.facu.domain.model.Status;
import ar.com.facu.domain.model.UsuarioAdmin;
import ar.com.facu.domain.service.EmprendedorService;
import ar.com.facu.domain.service.UsuarioAdminService;
import ar.com.facu.empleos.config.cache.CacheControl;
import ar.com.facu.empleos.config.cache.CachePolicy;

@Controller
@RequestMapping("/Emprendedores")
public class EmprendedorController {

    @Autowired
    EmprendedorService dataServices;

    static final Logger logger = Logger.getLogger(EmprendedorController.class);
	

    
	@CacheControl(maxAge = 300, policy = CachePolicy.PUBLIC)	
    @RequestMapping(value = "/getEmprendedores", method = RequestMethod.GET)
    public  ResponseEntity<List<Emprendedor>>  getEmprendedores() throws Exception {              	            	
      return  new ResponseEntity<List<Emprendedor>>(dataServices.getListEmprendedores(), HttpStatus.OK);             
    }



}  