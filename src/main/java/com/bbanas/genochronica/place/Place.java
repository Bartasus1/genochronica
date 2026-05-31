package com.bbanas.genochronica.place;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String state;

    @Column(length = 2) // ISO 3166-1 alpha-2 country code
    private String country = "PL";
}