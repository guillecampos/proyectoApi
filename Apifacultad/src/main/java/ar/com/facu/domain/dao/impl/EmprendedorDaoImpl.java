package ar.com.facu.domain.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.facu.domain.dao.EmprendedorDao;
import ar.com.facu.domain.model.Emprendedor;

@Transactional
@Repository
public class EmprendedorDaoImpl extends GenericDAOImpl<Emprendedor, Long> implements EmprendedorDao  {

    @Autowired
    protected EmprendedorDaoImpl(SessionFactory sessionFactory) {
	super(sessionFactory, Emprendedor.class);
    }


    
    
}
