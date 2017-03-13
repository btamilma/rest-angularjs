package com.balatamilmani.dao;
/**
 * @author Balamurugan Tamilmani
 *
 */
import org.springframework.stereotype.Repository;

import com.balatamilmani.model.Person;

//@EnableTransactionManagement
//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Repository
public class PersonDaoImpl extends JpaBaseDaoImpl<Person>{

}
