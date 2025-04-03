package ru.atc.smartbudget.dto.outlayCategory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.model.DBOutlayCategory;

@Mapper(componentModel = "spring")
public interface OutlayCategoryMapping {
    @Mapping(source = "outlayCategoryId", target = "outlayCategoryId")

    GetOutlayCategory toDto(DBOutlayCategory entity);

//    @Mapping(target = "incomeCategoryId", ignore = true)
//    DBIncomeCategory postToEntity(PostOutlayCategory dto);
//
//    @Mapping(target = "incomeCategoryId", ignore = true)
//    DBIncomeCategory putToEntity(PutOutlayCategory dto);
}
