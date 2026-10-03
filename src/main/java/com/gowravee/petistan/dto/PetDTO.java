package com.gowravee.petistan.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gowravee.petistan.enums.Gender;
import com.gowravee.petistan.enums.PetType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "category")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DomesticPetDTO.class, name = "Domestic"),
        @JsonSubTypes.Type(value = WildPetDTO.class, name = "Wild")
})
public class PetDTO {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;
    private Gender gender;
    private PetType petType;

}
