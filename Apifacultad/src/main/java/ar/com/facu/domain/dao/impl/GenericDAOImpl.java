package ar.com.facu.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Transactional;

import ar.com.facu.domain.dao.base.GenericDAO;

public class GenericDAOImpl<E, I extends Serializable> implements GenericDAO<E, I>  {

	private final Class<E> entityClass;
	private final SessionFactory sessionFactory;

	protected GenericDAOImpl(SessionFactory sessionFactory, Class<E> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}

	@Transactional
	public void save(E entity) {
		this.getSession().saveOrUpdate(entity);
	}

	public void save(E[] entities) {
		this.getSession().saveOrUpdate(entities);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public E getById(I id) {
		return (E) this.getSession().get(this.entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> find() {
		return this.getSession().createCriteria(this.entityClass).setCacheable(true).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> find(Criterion criterion) {
		Criteria criteria = this.getSession().createCriteria(this.entityClass);
		criteria.setCacheable(true);
		criteria.add(criterion);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public E findBy(Criterion criterion) {
		Criteria criteria = this.getSession().createCriteria(this.entityClass);
		criteria.add(criterion);
		return (E) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<E> find(String hql) {
		return this.getSession().createQuery(hql).list();
	}

	protected Session getSession() {
		Session sesion = this.sessionFactory.getCurrentSession();	

		return sesion;
	}


}
