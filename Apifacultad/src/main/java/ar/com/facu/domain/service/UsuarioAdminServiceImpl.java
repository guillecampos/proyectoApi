package ar.com.facu.domain.service;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.facu.domain.dao.UsuarioAdminDao;
import ar.com.facu.domain.model.UsuarioAdmin;



@Service
public class UsuarioAdminServiceImpl implements UsuarioAdminService {

    private static final int EstadoActivo = 1;
	@Autowired
	UsuarioAdminDao usuarioAdminDao;
	 static final Logger logger = Logger.getLogger(UsuarioAdminServiceImpl.class);
	
	@Override
	public boolean getUsuarioAdmin(String mail, String pass) throws Exception {		
		UsuarioAdmin userAdmin = usuarioAdminDao.getUserAdmin(mail, pass);
					
		return getUsuarioActivo(userAdmin);				
	}


	private boolean getUsuarioActivo(UsuarioAdmin userAdmin) {
		if(userAdmin!=null)
		{
			
			logger.info("userAdmin not null "  + userAdmin.getEstado());
		
			if(userAdmin.getEstado().equals(EstadoActivo)){
				return true;
			}
			return false;
		}else
		{	
			logger.info("userAdmin null ");
			return false;
		}
	}


	@Override
	public void SetUsuarioAdmin(UsuarioAdmin userAdmin) throws Exception {
		usuarioAdminDao.save(userAdmin);
	}


	@Override
	public List<UsuarioAdmin> getListUsuarioAdmin() throws Exception {
		return usuarioAdminDao.find();				
	}

}
