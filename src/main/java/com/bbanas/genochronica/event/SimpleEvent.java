package com.bbanas.genochronica.event;

import java.time.LocalDate;

import com.bbanas.genochronica.place.Place;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SimpleEvent {

    @ManyToOne
    private Place place;
    private LocalDate date;
}