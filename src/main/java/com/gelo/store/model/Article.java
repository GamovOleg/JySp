package com.gelo.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gelo.store.Status;
import com.gelo.store.Style;
import com.gelo.store.Type;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
public class Article {
    @Id
    private long id;
    private Type type;
    private String manufacturer;
    private String brand;
    private Calendar purchaspeDate;
    private BigDecimal cost;
    private BigDecimal price;
    private Style style;
    private Calendar dateOfSale;
    private Status status;

    @JsonIgnore
    private MultipartFile articleImage;

    public Article() {
        super();
    }

    public Article(long id, Type type, String manufacturer, String brand, Calendar purchaspeDate, BigDecimal cost, BigDecimal price, Style style, Calendar dateOfSale, Status status) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.purchaspeDate = purchaspeDate;
        this.setCost(cost);
        this.setPrice(price);
        this.style = style;
        this.dateOfSale = dateOfSale;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Calendar getPurchaspeDate() {
        return purchaspeDate;
    }

    public void setPurchaspeDate(Calendar purchaspeDate) {
        this.purchaspeDate = purchaspeDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Calendar getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Calendar dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MultipartFile getArticleImage(){
        return articleImage;
    }

    public void setArticleImage(MultipartFile articleImage){
        this.articleImage = articleImage;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", type=" + type +
                ", manufacturer='" + manufacturer + '\'' +
                ", brand='" + brand + '\'' +
                ", purchaspeDate=" + purchaspeDate +
                ", cost=" + cost +
                ", price=" + price +
                ", style=" + style +
                ", dateOfSale=" + dateOfSale +
                ", status=" + status +
                '}';
    }

}
