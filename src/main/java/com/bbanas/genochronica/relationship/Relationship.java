package com.bbanas.genochronica.relationship;

import java.time.LocalDate;

import com.bbanas.genochronica.person.Person;
import com.bbanas.genochronica.relationship.types.RelationshipStatus;
import com.bbanas.genochronica.relationship.types.RelationshipType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
	private RelationshipType type;

    @Enumerated(EnumType.STRING)
    private RelationshipStatus status;

    @ManyToOne
    @JoinColumn(name = "person_a_id")
    private Person personA;

    @ManyToOne
    @JoinColumn(name = "person_b_id")
    private Person personB;

    private LocalDate from;
    private LocalDate to;

}