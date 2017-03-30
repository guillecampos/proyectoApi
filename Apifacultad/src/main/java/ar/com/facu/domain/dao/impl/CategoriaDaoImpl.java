package ar.com.facu.domain.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.facu.domain.dao.CategoriaDao;
import ar.com.facu.domain.model.Categoria;

@Transactional
@Repository
public class CategoriaDaoImpl extends GenericDAOImpl<Categoria, Long> implements CategoriaDao  {

    @Autowired
    protected CategoriaDaoImpl(SessionFactory sessionFactory) {
	super(sessionFactory, Categoria.class);
    }

    
}
