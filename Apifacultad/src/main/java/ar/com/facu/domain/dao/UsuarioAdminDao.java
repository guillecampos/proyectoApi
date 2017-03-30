package ar.com.facu.domain.dao;

import ar.com.facu.domain.dao.base.GenericDAO;
import ar.com.facu.domain.model.Pais;
import ar.com.facu.domain.model.UsuarioAdmin;

public interface UsuarioAdminDao extends GenericDAO<UsuarioAdmin, Long> {
	
    public UsuarioAdmin getUserAdmin(String mail,String pass);
}
