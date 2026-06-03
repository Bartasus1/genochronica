package com.bbanas.genochronica.person.dto;

import java.time.LocalDate;

import com.bbanas.genochronica.event.SimpleEvent;
import com.bbanas.genochronica.person.Person;
import com.bbanas.genochronica.place.Place;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PersonRequest {

	private String firstName;
	private String middleName;
	private String lastName;

	private String maidenName;


	private Place birthPlace;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate birthDate;

	public Person toPerson() {
		Person person = new Person();
		person.setFirstName(firstName);
		person.setMiddleName(middleName);
		person.setLastName(lastName);
		person.setMaidenName(maidenName);
		return person;
	}

}