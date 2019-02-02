package com.gelo.store.model;

import com.gelo.store.model.Article;

import java.math.BigDecimal;

public class StokArticle {
    private Article article;
    private int quantity;
    private BigDecimal price;

    public StokArticle() {
    }

    public StokArticle(Article article) {
        super();
        this.setArticle(article);
        this.setQuantity(1);
        this.setPrice(article.getPrice());
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
