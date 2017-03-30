package ar.com.facu.domain.service;

import java.util.List;

import ar.com.facu.domain.model.UsuarioAdmin;




public interface UsuarioAdminService {
	
    public boolean getUsuarioAdmin(String mail, String pass ) throws Exception;
    
    public void SetUsuarioAdmin(UsuarioAdmin userAdmin) throws Exception;
    
    public List<UsuarioAdmin> getListUsuarioAdmin() throws Exception;
}
