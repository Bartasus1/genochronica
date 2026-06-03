package com.bbanas.genochronica.person;

import java.util.Set;
import java.util.HashSet;

import com.bbanas.genochronica.event.SimpleEvent;
import com.bbanas.genochronica.event.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import lombok.With;


@Entity
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("middle_name")
	private String middleName;
	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("maiden_name")
	private String maidenName;

	@JsonUnwrapped(prefix="birth_")
	private SimpleEvent birth;

	@JsonUnwrapped(prefix="death_")
	private SimpleEvent death;


	// every person has at most 2 parents, but they can be unknown

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "father_id")
	private Person father;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "mother_id")
	private Person mother;

	@JsonIgnore
	@ManyToMany(mappedBy = "participants")
	private Set<Event> events = new HashSet<>();


	public boolean isAlive() {
		return death == null;
	}

	public String getName() {
		return String.join(" ", firstName, middleName, lastName)
			.replaceAll("\\s+", " ")
			.trim();
  	}

}
