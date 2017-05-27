package com.gluuten.service;

import com.gluuten.entities.Person;
import com.gluuten.repository.Personrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;

/**
 * Created by yusufaslan on 27.05.2017.
 */
@Service
public class personservice {

    private Personrepo personrepo;

    @Autowired
    public personservice(Personrepo personrepo)
    {
        this.personrepo = personrepo;
    }

    public Person getPersonById(Long id){
        Person person = personrepo.getPersonById(id);

        return person;
    }

}
