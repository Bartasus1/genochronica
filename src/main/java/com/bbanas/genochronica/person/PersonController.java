package com.bbanas.genochronica.person;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.bbanas.genochronica.person.dto.PersonRequest;




@RestController
@AllArgsConstructor
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> personOpt = personService.getPersonById(id);
        if (personOpt.isPresent()) {
            return ResponseEntity.ok(personOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@PostMapping("")
	public ResponseEntity<Person> createPerson(@RequestBody PersonRequest person) {
		return ResponseEntity.status(201).body(personService.savePerson(person));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
		Person existingPerson = personService.getPersonById(id).orElse(null);
		if (existingPerson == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(202).body(personService.updatePerson(id, updatedPerson));
	}
	

    @GetMapping("/search")
    public Page<Person> searchByName(@RequestParam String name) {
        return personService.searchByName(name);
    }
    
}