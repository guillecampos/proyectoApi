package ar.com.facu.domain.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.facu.domain.dao.ProductoDao;
import ar.com.facu.domain.model.Producto;

@Transactional
@Repository
public class ProductoDaoImpl extends GenericDAOImpl<Producto, Long> implements ProductoDao  {

    @Autowired
    protected ProductoDaoImpl(SessionFactory sessionFactory) {
    	super(sessionFactory, Producto.class);
    }


    
    
}
