package com.zhibin.realworld.domain.article;

import com.zhibin.realworld.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID articleId;
    private String slug;
    private String title;
    private String description;
    private String body;
    private Set<Tag> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private Set<User> favorites;
    private User author;
}
