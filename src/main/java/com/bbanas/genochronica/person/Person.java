package com.bbanas.genochronica.person;

import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import com.bbanas.genochronica.event.SimpleEvent;
import com.bbanas.genochronica.event.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String middleName;
	private String lastName;

	private Optional<String> maidenName;

	@JsonUnwrapped
	private SimpleEvent birth;

	@JsonUnwrapped
	private Optional<SimpleEvent> death;


	// every person has at most 2 parents, but they can be unknown

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "father_id")
	private Optional<Person> father;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "mother_id")
	private Optional<Person> mother;

	@JsonIgnore
	@ManyToMany(mappedBy = "participants")
	private Set<Event> events = new HashSet<>();


	public boolean isAlive() {
		return death.isEmpty();
	}

}
