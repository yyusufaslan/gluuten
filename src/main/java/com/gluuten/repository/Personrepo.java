package com.gluuten.repository;

import com.gluuten.entities.Person;
import com.gluuten.service.personservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by yusufaslan on 27.05.2017.
 */

public interface Personrepo extends JpaRepository<Person, Long>,JpaSpecificationExecutor<Person> {

    Person getPersonById(Long id);

}
