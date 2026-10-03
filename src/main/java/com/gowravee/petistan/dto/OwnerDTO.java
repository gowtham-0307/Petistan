package com.gowravee.petistan.dto;

import com.gowravee.petistan.enums.Gender;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OwnerDTO {

    @EqualsAndHashCode.Include
    private Integer id;

    private String firstName;
    private String lastName;
    private Gender gender;
    private String city;
    private String state;

    @EqualsAndHashCode.Include
    private String phone;

    @EqualsAndHashCode.Include
    private String email;

    private PetDTO petDTO;
}
