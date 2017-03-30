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

import ar.com.facu.domain.model.Pais;
import ar.com.facu.domain.model.Status;
import ar.com.facu.domain.model.UsuarioAdmin;
import ar.com.facu.domain.service.UsuarioAdminService;
import ar.com.facu.empleos.config.cache.CacheControl;
import ar.com.facu.empleos.config.cache.CachePolicy;

@Controller
@RequestMapping("/UserAdmin")
public class UsuarioAdminController {

    @Autowired
    UsuarioAdminService dataServices;

    static final Logger logger = Logger.getLogger(UsuarioAdminController.class);
	
    @CacheControl(maxAge = 3600, policy = CachePolicy.PUBLIC)	
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public @ResponseBody Status getPerson(@RequestParam(value = "mail", required = true) String mail,@RequestParam(value = "pass", required = true) String pass) {              
	  try {
          
		  logger.info("parametro mail "  + mail);
		  logger.info("parametro pass "  + pass);
		  boolean result = dataServices.getUsuarioAdmin(mail, pass);
          if(result)
            return new Status(1, "usuario correcto" );
          else
            return new Status(0, "usuario incorrecto");
      } catch (Exception e) {
          return new Status(0, e.toString());
      }       
    }
       	
   
    @RequestMapping(value = "/setUser", method = RequestMethod.POST)    
    @ResponseBody
    public Status SetPerson(Model model,String mail,String pass,String nombre,String telefono) {    	
	  try {          
		  UsuarioAdmin usuarioAdmin = new UsuarioAdmin();		  
		  setUsuario(mail, pass, nombre, telefono, usuarioAdmin);		  		  
		  dataServices.SetUsuarioAdmin(usuarioAdmin);       
          return new Status(1, "usuario creado correcto" );       
      } catch (Exception e) {
    	     return new Status(0, "usuario no creado");
      }       
    }
    
	@CacheControl(maxAge = 300, policy = CachePolicy.PUBLIC)	
    @RequestMapping(value = "/getUsuarios", method = RequestMethod.GET)
    public  ResponseEntity<List<UsuarioAdmin>>  getUsuarios() throws Exception {              	            	
      return  new ResponseEntity<List<UsuarioAdmin>>(dataServices.getListUsuarioAdmin(), HttpStatus.OK);             
    }


	private void setUsuario(String mail, String pass, String nombre,
			String telefono, UsuarioAdmin usuarioAdmin) {
		usuarioAdmin.setMail(mail);
		  usuarioAdmin.setNombre(nombre);
		  usuarioAdmin.setPass(pass);
		  usuarioAdmin.setTelefono(telefono);
	}

}  