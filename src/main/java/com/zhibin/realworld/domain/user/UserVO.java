package com.zhibin.realworld.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String email;
    private String token;
    private String username;
    private String bio;
    private String image;
}
