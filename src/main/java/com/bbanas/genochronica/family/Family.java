package com.bbanas.genochronica.family;

import java.util.List;

import com.bbanas.genochronica.person.Person;
import com.bbanas.genochronica.relationship.Relationship;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Family {

    List<Person> members;
    List<Relationship> relationships;
}