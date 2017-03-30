package ar.com.facu.domain.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.facu.domain.dao.PaisDAO;
import ar.com.facu.domain.dao.UsuarioAdminDao;
import ar.com.facu.domain.model.Pais;
import ar.com.facu.domain.model.UsuarioAdmin;

@Transactional
@Repository
public class UsuarioAdminDaoImpl extends GenericDAOImpl<UsuarioAdmin, Long> implements UsuarioAdminDao  {

    @Autowired
    protected UsuarioAdminDaoImpl(SessionFactory sessionFactory) {
	super(sessionFactory, UsuarioAdmin.class);
    }

	@Override
	public UsuarioAdmin getUserAdmin(String mail, String pass) {
		return (UsuarioAdmin) getSession().createCriteria(UsuarioAdmin.class).add(Restrictions.eq("mail", mail)).add(Restrictions.eq("pass",  pass))
		        .uniqueResult();	
	}
	
	
    
    
    
}
