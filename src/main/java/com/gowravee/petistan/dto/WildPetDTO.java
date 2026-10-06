package com.gowravee.petistan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class WildPetDTO extends PetDTO {

    private String birthPlace;
}
