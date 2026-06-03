package com.bbanas.genochronica.person;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;


    Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    Page<Person> searchByName(String name) {
        return personRepository.findByName(name, PageRequest.of(0, 20));
    }



}