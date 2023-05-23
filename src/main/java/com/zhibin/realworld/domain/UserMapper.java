package com.zhibin.realworld.domain;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserVO userToUserVO(User user);
}
