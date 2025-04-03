package ru.atc.smartbudget.dto.income;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.model.DBIncome;

@Mapper(componentModel = "spring")
public interface IncomeMapping {
    @Mapping(source = "incomeId", target = "incomeId")
    GetIncome toDto(DBIncome income);

    @Mapping(target = "incomeId", ignore = true)
    DBIncome postToEntity(PostIncome dto);
}
