package com.mypc.program.personaApi.controller;

import com.mypc.program.personaApi.dto.MessageResponseDTO;
import com.mypc.program.personaApi.entity.Person;
import com.mypc.program.personaApi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonaController {

    private PersonService personService;

    @Autowired
    public PersonaController(PersonService PersonService) {
        this.personService = PersonService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);

    }

}
