package ru.atc.smartbudget.dto.income;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.model.Income;

@Mapper(componentModel = "spring")
public interface IncomeMapping {
    @Mapping(source = "incomeId", target = "incomeId")
    IncomeDetail toDto(Income income);

    @Mapping(target = "incomeId", ignore = true)
    Income postToEntity(CreateIncome dto, Long userId);

    Income putToEntity(Long incomeId, EditIncome dto );
}
