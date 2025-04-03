package ru.atc.smartbudget.dto.incomeCategory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.model.DBIncomeCategory;

@Mapper(componentModel = "spring")
public interface IncomeCategoryMapping {
    @Mapping(source = "incomeCategoryId", target = "incomeCategoryId")

    GetIncomeCategory toDto(DBIncomeCategory entity);

    @Mapping(target = "incomeCategoryId", ignore = true)
    DBIncomeCategory postToEntity(PostIncomeCategory dto);

//    @Mapping(target = "incomeCategoryId", ignore = true)
//    DBIncomeCategory putToEntity(PutIncomeCategory dto);
}
