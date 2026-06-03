package com.bbanas.genochronica.family;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bbanas.genochronica.person.Person;
import com.bbanas.genochronica.person.PersonRepository;
import com.bbanas.genochronica.relationship.Relationship;
import com.bbanas.genochronica.relationship.RelationshipRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FamilyService {

    private final PersonRepository personRepository;
    private final RelationshipRepository relationshipRepository;

    Family getFamilyTree() {
        List<Person> members = personRepository.findAll();
        List<Relationship> relationships = relationshipRepository.findAll();
        members.forEach(person -> {

            if(person.getFather() != null) {
                relationships.add(
                    new Relationship()
                    .withPersonA(person)
                    .withPersonB(person.getFather())
                    .withFrom(person.getBirth().getDate())
                );
            }

            if(person.getMother() != null) {
                relationships.add(
                    new Relationship()
                    .withPersonA(person)
                    .withPersonB(person.getMother())
                    .withFrom(person.getBirth().getDate())
                );
            }
        });
        return new Family(members, relationships);
    }
}