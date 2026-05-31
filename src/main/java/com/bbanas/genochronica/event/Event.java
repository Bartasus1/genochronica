package com.bbanas.genochronica.event;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.bbanas.genochronica.person.Person;
import com.bbanas.genochronica.place.Place;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    private Place place;
    private LocalDate date;

    @ManyToMany
    private Set<Person> participants = new HashSet<>();
}