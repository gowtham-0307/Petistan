package com.gowravee.petistan.entity;

import com.gowravee.petistan.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "owner_table")
@Entity
@Getter
@Setter
public class Owner extends Base {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column (name = "phone", nullable = false, unique = true, length = 10)
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false, unique = true)
    private Pet pet;
}
