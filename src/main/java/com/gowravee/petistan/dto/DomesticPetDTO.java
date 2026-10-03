package com.gowravee.petistan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class DomesticPetDTO extends PetDTO {

    private LocalDate birthDate;
}
