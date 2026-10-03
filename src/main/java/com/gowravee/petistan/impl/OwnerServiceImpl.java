package com.gowravee.petistan.impl;

import com.gowravee.petistan.dto.OwnerDTO;
import com.gowravee.petistan.entity.Owner;
import com.gowravee.petistan.exception.OwnerNotFoundException;
import com.gowravee.petistan.repository.OwnerRepository;
import com.gowravee.petistan.service.OwnerService;
import com.gowravee.petistan.util.OwnerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Value("${owner.not.found}")
    private String ownerNotFound;

    @Override
    public Integer saveOwner(OwnerDTO ownerDTO) {
        Owner owner = ownerMapper.ownerDTOToOwner(ownerDTO);
        ownerRepository.save(owner);
        return owner.getId();
    }

    @Override
    public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
        return ownerRepository.findById(ownerId)
                .map(ownerMapper::ownerToOwnerDTO)
                .orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
        owner.getPet().setName(petName);
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(int ownerId) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public Page<OwnerDTO> findAllOwners(Pageable pageable) {
        return ownerRepository.findAll(pageable)
                .map(ownerMapper::ownerToOwnerDTO);
    }
}
