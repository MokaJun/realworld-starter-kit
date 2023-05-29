package com.zhibin.realworld.domain.article;

import com.zhibin.realworld.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="articles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID articleId;
    private String slug;
    private String title;
    private String description;
    private String body;
    @ManyToMany
    @JoinTable(
            name = "article_tag",
            joinColumns = @JoinColumn(name = "a_id", referencedColumnName = "articleId"),
            inverseJoinColumns = @JoinColumn(name = "t_id", referencedColumnName = "tagId"))
    private Set<Tag> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    @ManyToMany
    @JoinTable(
            name = "favorites",
            joinColumns = @JoinColumn(name = "a_id", referencedColumnName = "articleId"),
            inverseJoinColumns = @JoinColumn(name = "u_id", referencedColumnName = "userId"))
    private Set<User> favorites;
    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "userId")
    private User author;
}
