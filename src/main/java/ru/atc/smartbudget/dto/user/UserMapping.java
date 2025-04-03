package ru.atc.smartbudget.dto.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.model.DBUser;

@Mapper(componentModel = "spring")
public interface UserMapping {
    @Mapping(source = "userId", target = "userId")
    GetUser toDto(DBUser user);

    @Mapping(target = "userId", ignore = true)
    DBUser toEntity(PostUser userData);
}
