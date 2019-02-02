package com.gelo.store.repository;

import com.gelo.store.model.Article;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ArticleRepository {
    List<Article> getAllArticles();
    List<Article> getArticlesByType(String type);
    Article getArticleById(String articleId);
    Set<Article> getArticlesByFilter(Map<String, List<String>> filterParams);
    void addArticle(Article article);
}
