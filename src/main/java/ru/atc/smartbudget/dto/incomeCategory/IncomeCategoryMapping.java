package ru.atc.smartbudget.dto.incomeCategory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.model.IncomeCategory;
import ru.atc.smartbudget.model.User;

@Mapper(componentModel = "spring")
public interface IncomeCategoryMapping {
    @Mapping(source = "incomeCategoryId", target = "incomeCategoryId")
    IncomeCategoryDetail toDto(IncomeCategory entity);

    @Mapping(target = "incomeCategoryId", ignore = true)
    IncomeCategory postToEntity(User user, CreateIncomeCategory dto);

//    @Mapping(target = "incomeCategoryId", ignore = true)
//    DBIncomeCategory putToEntity(PutIncomeCategory dto);
}
