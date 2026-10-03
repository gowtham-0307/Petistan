package com.gowravee.petistan.entity;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
@Getter
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}
