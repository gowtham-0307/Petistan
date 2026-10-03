package com.gowravee.petistan.util;

import com.gowravee.petistan.dto.DomesticPetDTO;
import com.gowravee.petistan.dto.OwnerDTO;
import com.gowravee.petistan.dto.PetDTO;
import com.gowravee.petistan.dto.WildPetDTO;
import com.gowravee.petistan.entity.DomesticPet;
import com.gowravee.petistan.entity.Owner;
import com.gowravee.petistan.entity.Pet;
import com.gowravee.petistan.entity.WildPet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OwnerMapper {

    String UNSUPPORTED_PET_INSTANCE = "Unsupported pet instance: %s";

    @Mapping(source = "petDTO", target = "pet")
    Owner ownerDTOToOwner(OwnerDTO ownerDTO);

    default Pet petDTOToPet(PetDTO petDTO) {
        return switch (petDTO) {
            case DomesticPetDTO domesticPetDTO -> domesticPetDTOToDomesticPet(domesticPetDTO);
            case WildPetDTO wildPetDTO -> wildPetDTOToWildPet(wildPetDTO);
            default -> throw new IllegalArgumentException(String.format(UNSUPPORTED_PET_INSTANCE, petDTO.getClass()));
        };
    }

    DomesticPet domesticPetDTOToDomesticPet(DomesticPetDTO domesticPetDTO);

    WildPet wildPetDTOToWildPet(WildPetDTO wildPetDTO);

    @Mapping(source = "pet", target = "petDTO")
    OwnerDTO ownerToOwnerDTO(Owner owner);

    default PetDTO petToPetDTO(Pet pet) {
        return switch (pet) {
            case DomesticPet domesticPet -> domesticPetToDomesticPetDTO(domesticPet);
            case WildPet wildPet -> wildPetToWildPetDTO(wildPet);
            default -> throw new IllegalArgumentException(String.format(UNSUPPORTED_PET_INSTANCE, pet.getClass()));
        };
    }

    DomesticPetDTO domesticPetToDomesticPetDTO(DomesticPet domesticPet);

    WildPetDTO wildPetToWildPetDTO(WildPet wildPet);
}
