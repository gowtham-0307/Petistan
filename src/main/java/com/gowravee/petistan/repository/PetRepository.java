package com.gowravee.petistan.repository;

import com.gowravee.petistan.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query("""
			SELECT
			 CASE
			  WHEN TYPE(p) = DomesticPet THEN 'DOMESTIC'
			  WHEN TYPE(p) = WildPet THEN 'WILD'
			 END,
			 p.gender,
			 p.type,
			 COUNT(p)
			FROM Pet p
			GROUP BY
			 CASE
			  WHEN TYPE(p) = DomesticPet THEN 'DOMESTIC'
			  WHEN TYPE(p) = WildPet THEN 'WILD'
			 END,
			 p.gender,
			 p.type
			""")
    List<Object[]> fetchStatistics();
}
