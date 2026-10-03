package com.gowravee.petistan.repository;

import com.gowravee.petistan.dto.OwnerDTO;
import com.gowravee.petistan.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
