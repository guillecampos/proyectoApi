package ar.com.facu.domain.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.com.facu.domain.dao.PaisDAO;
import ar.com.facu.domain.model.Pais;


@Repository
public class PaisDAOImpl extends GenericDAOImpl<Pais, Long> implements PaisDAO  {

    @Autowired
    protected PaisDAOImpl(SessionFactory sessionFactory) {
	super(sessionFactory, Pais.class);
    }
    
    
    
}
