package com.gowravee.petistan.service;

import com.gowravee.petistan.dto.OwnerDTO;
import com.gowravee.petistan.exception.OwnerNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    Integer saveOwner(OwnerDTO ownerDTO);

    OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

    void deleteOwner(int ownerId) throws OwnerNotFoundException;

    Page<OwnerDTO> findAllOwners(Pageable pageable);
}
