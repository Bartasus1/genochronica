package com.bbanas.genochronica.person;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bbanas.genochronica.event.SimpleEvent;
import com.bbanas.genochronica.person.dto.PersonRequest;
import com.bbanas.genochronica.place.Place;
import com.bbanas.genochronica.place.PlaceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
	private final PlaceRepository placeRepository;


    Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

	Person savePerson(PersonRequest person) {
		Place birthPlace = getOrCreatePlace(person.getBirthPlace());
		SimpleEvent birth = new SimpleEvent(birthPlace, person.getBirthDate());


		return personRepository.save(person.toPerson().withBirth(birth));
	}

	Person updatePerson(Long id, Person updatedPerson) {
		updatedPerson.setId(id);
		return personRepository.save(updatedPerson);
	}

    Page<Person> searchByName(String name) {
        return personRepository.findByName(name, PageRequest.of(0, 20));
    }


	private Place getOrCreatePlace(Place place) {
		return placeRepository.findByCity(place.getCity())
				.orElseGet(() -> placeRepository.save(place));
	}



}