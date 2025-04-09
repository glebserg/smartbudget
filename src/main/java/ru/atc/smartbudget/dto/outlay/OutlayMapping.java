package ru.atc.smartbudget.dto.outlay;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.model.Outlay;
import ru.atc.smartbudget.model.OutlayCategory;

@Mapper(componentModel = "spring")
public interface OutlayMapping {
    OutlayDetail toDto(Outlay outlay);

    @Mapping(target = "outlayId", ignore = true)
    Outlay postToEntity(CreateOutlay dto, Long userId, OutlayCategory outlayCategory);
}
