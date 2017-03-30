package ar.com.facu.domain.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDAO<E, I extends Serializable> {
	
	void save(E entity);

	void save(E[] entities);

	E getById(I id);

	E findBy(Criterion criterion);

	List<E> find();

	List<E> find(String hql);

	List<E> find(Criterion criterion);

}