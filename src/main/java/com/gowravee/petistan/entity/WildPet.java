package com.gowravee.petistan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wild_pet_table")
@Getter
@Setter
public class WildPet extends Pet {

    @Column(name = "birth_place", nullable = false)
    private String birthPlace;
}
