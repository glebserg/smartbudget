package ru.atc.smartbudget.dto.outlay;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.dto.outlay.GetOutlay;
import ru.atc.smartbudget.model.DBIncome;
import ru.atc.smartbudget.model.DBOutlay;

@Mapper(componentModel = "spring")
public interface OutlayMapping {
    @Mapping(source = "outlayId", target = "outlayId")
    GetOutlay toDto(DBOutlay outlay);

    @Mapping(target = "outlayId", ignore = true)
    DBOutlay postToEntity(PostOutlay dto, Long userId);
}
