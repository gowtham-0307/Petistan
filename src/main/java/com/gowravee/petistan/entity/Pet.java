package com.gowravee.petistan.entity;

import com.gowravee.petistan.enums.Gender;
import com.gowravee.petistan.enums.PetType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pet_table")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pet extends Base {

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PetType type;

}
