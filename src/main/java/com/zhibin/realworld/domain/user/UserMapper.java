package com.zhibin.realworld.domain.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserVO userToUserVO(User user);
}
