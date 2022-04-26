package com.mypc.program.personaApi.controller;

import com.mypc.program.personaApi.dto.response.MessageResponseDTO;
import com.mypc.program.personaApi.dto.request.PersonDTO;
import com.mypc.program.personaApi.exception.PersonNotFoundException;
import com.mypc.program.personaApi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);

    }

    @GetMapping
    public List<PersonDTO> ListAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

}
