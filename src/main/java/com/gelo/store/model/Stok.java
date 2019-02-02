package com.gelo.store.model;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Stok {
    private String stokId;
    private Map<Long, StokArticle> stokArticle;
    private BigDecimal total;

    public Stok() {
        setStokArticle(new HashMap<>());
        setTotal(new BigDecimal(0));
    }

    public Stok(String stokId) {
        this();
        this.setStokId(stokId);
    }

    public String getStokId() {
        return stokId;
    }

    public void setStokId(String stokId) {
        this.stokId = stokId;
    }

    public Map<Long, StokArticle> getStokArticle() {
        return stokArticle;
    }

    public void setStokArticle(Map<Long, StokArticle> stokArticle) {
        this.stokArticle = stokArticle;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void addStokArticle(StokArticle item){
        long id = item.getArticle().getId();
        if (stokArticle.containsKey(id)){
            StokArticle existingStokArticle = stokArticle.get(id);
            existingStokArticle.setQuantity(existingStokArticle.getQuantity() + item.getQuantity());
            stokArticle.put(id, existingStokArticle);
        } else {
            stokArticle.put(id, item);
        }

        updateTotal();
    }

    public void removeStokArticle(StokArticle item) {
        long id = item.getArticle().getId();
        stokArticle.remove(id);
        updateTotal();
    }

    public void updateTotal() {
        total = new BigDecimal(0);
        for (StokArticle item : stokArticle.values()) total = total.add(item.getPrice());

    }
}


