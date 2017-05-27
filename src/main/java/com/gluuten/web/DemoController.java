package com.gluuten.web;

import com.gluuten.entities.Person;
import com.gluuten.repository.Personrepo;

import com.gluuten.service.personservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yusufaslan on 25.05.2017.
 */
@RestController
@RequestMapping("")
public class DemoController {

    private final personservice personService;

    @Autowired
    public DemoController(personservice personService) {
        this.personService = personService;
    }

    @RequestMapping("/person/{id}")
    public Person getPerson(
            @PathVariable("id") Long id) {


        final Person person = personService.getPersonById(id);

        return person;
    }
    @RequestMapping("/hello")
    public String hello()
    {
        return "hello";
    }
////
//    @Autowired
//    private personservice personservice;
//
//    @GetMapping("person/{id}")
//    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id){
//
//        Person person =personservice.getPersonById(id);
//
//
//        return new ResponseEntity<Person>(person, HttpStatus.OK);
//    }


}
