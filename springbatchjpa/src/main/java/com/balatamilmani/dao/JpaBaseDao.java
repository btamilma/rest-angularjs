package com.balatamilmani.dao;
/**
 * @author Balamurugan Tamilmani
 *
 */
public interface JpaBaseDao<T> {

	void persist(T t);
	
	T merge(T t);
}
