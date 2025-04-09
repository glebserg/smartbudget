package ru.atc.smartbudget.dto.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.atc.smartbudget.model.User;

@Mapper(componentModel = "spring")
public interface UserMapping {
    @Mapping(source = "userId", target = "userId")
    UserDetail toDto(User user);

    @Mapping(target = "userId", ignore = true)
    User toEntity(CreateUser userData);
}
