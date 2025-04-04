package ru.atc.smartbudget.dto.outlay;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.model.DBOutlay;
import ru.atc.smartbudget.model.DBOutlayCategory;

@Mapper(componentModel = "spring")
public interface OutlayMapping {
    GetOutlay toDto(DBOutlay outlay);

    @Mapping(target = "outlayId", ignore = true)
    DBOutlay postToEntity(PostOutlay dto, Long userId, DBOutlayCategory outlayCategory);
}
