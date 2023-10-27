package org.example.controller;

import org.example.entity.Person;
import org.example.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void registerPerson(Person person) {
        personService.register(person);
    }

    public void listPersons() {
        personService.listPersons();
    }
}
