package com.zhibin.realworld.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileVO {
    private String username;
    private String bio;
    private String image;
    private boolean following;

    public ProfileVO(User me, User to){
        this(to.getUsername(),to.getBio(),to.getImage(),me.isFollowing(to));
    }
}
