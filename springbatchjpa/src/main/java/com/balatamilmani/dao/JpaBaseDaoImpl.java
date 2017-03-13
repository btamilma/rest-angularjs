package com.balatamilmani.dao;
/**
 * @author Balamurugan Tamilmani
 *
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JpaBaseDaoImpl<T> implements JpaBaseDao<T>{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void persist(T t) {
		entityManager.persist(t);
	}
	
	public T merge(T t){
		return entityManager.merge(t);
	}

}
