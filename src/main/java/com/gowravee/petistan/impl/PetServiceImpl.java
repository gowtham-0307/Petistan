package com.gowravee.petistan.impl;

import com.gowravee.petistan.dto.PetCategoryStatisticsDTO;
import com.gowravee.petistan.dto.PetGenderStatisticsDTO;
import com.gowravee.petistan.dto.PetStatisticsDTO;
import com.gowravee.petistan.enums.Gender;
import com.gowravee.petistan.enums.PetType;
import com.gowravee.petistan.repository.PetRepository;
import com.gowravee.petistan.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Override
    public PetStatisticsDTO getStatistics() {
        PetStatisticsDTO petStatisticsDTO = new PetStatisticsDTO();
        List<Object[]> rows = petRepository.fetchStatistics();
        for (Object[] row : rows) {
            String category = (String) row[0];
            Gender gender = (Gender) row[1];
            PetType type = (PetType) row[2];
            long count = (Long) row[3];
            petStatisticsDTO.incrementTotal(count);
            PetCategoryStatisticsDTO petCategoryStatisticsDTO = petStatisticsDTO.getOrCreateCategory(category);
            petCategoryStatisticsDTO.incrementTotal(count);
            PetGenderStatisticsDTO petGenderStatisticsDTO = petCategoryStatisticsDTO.getOrCreateGender(gender);
            petGenderStatisticsDTO.incrementTotal(count);
            petGenderStatisticsDTO.mergeOrCreateType(type, count);
        }
        return petStatisticsDTO;
    }

}