package com.gelo.store.service;


import com.gelo.store.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface ArticleService {
    List<Article> getAllArticles();
    List<Article> getArticlesByType(String type);
    Set<Article> getArticleByFilter(Map<String, List<String>> filterParams);
    Article getArticleById(String articleId);
    void addArticle(Article article);
    public String getFileExtension(String fileName);


}
