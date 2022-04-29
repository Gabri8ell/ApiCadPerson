package com.mypc.program.personaApi.services;
import com.mypc.program.personaApi.dto.response.MessageResponseDTO;
import com.mypc.program.personaApi.dto.request.PersonDTO;
import com.mypc.program.personaApi.entity.Person;
import com.mypc.program.personaApi.exception.PersonNotFoundException;
import com.mypc.program.personaApi.dto.mapper.PersonMapper;
import com.mypc.program.personaApi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return createMessageResponseDTO(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExist(id);

        return personMapper.toDTO(person);
    }


    public MessageResponseDTO delete(Long id) throws PersonNotFoundException {
        verifyIfExist(id);
        personRepository.deleteById(id);

        return createMessageResponseDTO(id, "Deleted person with ID ");

    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExist(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);

        return createMessageResponseDTO(updatedPerson.getId(), "Updated person with ID ");


    }

    private Person verifyIfExist(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponseDTO(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
