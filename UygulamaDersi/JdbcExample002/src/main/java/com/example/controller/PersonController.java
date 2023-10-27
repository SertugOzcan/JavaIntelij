package com.example.controller;

import com.example.entity.Person;
import com.example.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(){
        this.personService = new PersonService();
    }

    public void register(Person person){
        personService.register(person);
    }
}
