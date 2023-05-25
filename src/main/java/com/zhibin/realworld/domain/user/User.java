package com.zhibin.realworld.domain.user;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String email;
    private String password;
    @Transient
    private String token;
    private String username;
    private String bio;
    private String image;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "follows",
            joinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "following_id", referencedColumnName = "id"))
    private Set<User> followings = new HashSet<>();

    @Builder.Default
    @ManyToMany(mappedBy = "followings", cascade = CascadeType.ALL)
    private Set<User> followers = new HashSet<>();

    public User(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
        this.followings = new HashSet<>();
        this.followers = new HashSet<>();
    }

    public boolean isFollowing(User to) {
        return this.followings.contains(to);
    }
}
