package com.gowravee.petistan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "domestic_pet_table")
@Getter
@Setter
public class DomesticPet extends Pet {

    @Column(name = "birth_date")
    private LocalDate birthDate;
}
