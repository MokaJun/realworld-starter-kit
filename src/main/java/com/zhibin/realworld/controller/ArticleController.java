package com.zhibin.realworld.controller;

import com.zhibin.realworld.domain.article.ArticleVO;
import com.zhibin.realworld.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/articles")
    public ArticleVO getArticles(@RequestParam(value = "tag", required = false) String tag,
                                 @RequestParam(value = "author", required = false) String author,
                                 @RequestParam(value = "favorited", required = false) String favorited,
                                 @RequestParam(value = "limit", required = false) int limit,
                                 @RequestParam(value = "offset", required = false) int offset) {
        return new ArticleVO();
    }
}
