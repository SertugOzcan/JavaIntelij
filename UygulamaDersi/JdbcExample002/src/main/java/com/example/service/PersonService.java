package com.example.service;

import com.example.entity.Person;
import com.example.repository.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(){
        this.personRepository = new PersonRepository();
    }

    public void register(Person person){
        personRepository.register(person);
    }
}
