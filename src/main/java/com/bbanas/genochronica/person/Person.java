package com.bbanas.genochronica.person;

import java.util.Date;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String middleName;
	private String lastName;

	private String birthPlace;
	private Date birthDate;

	private Optional<String> deathPlace;
	private Optional<Date> deathDate;


	// every person has at most 2 parents, but they can be unknown
	private Optional<Person> father;
	private Optional<Person> mother;


	public boolean isAlive() {
		return deathDate.isEmpty();
	}

}
