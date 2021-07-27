package com.example.megacoffee.entity;

public class Coffee {

    private Long id;
    private String name;
    private String description;
    private String imgSrc;
    private Integer price;
    private Integer stock;
    private Long category_id;

    public Coffee(Long id, String name, String description, String imgSrc, Integer price, Integer stock, Long category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgSrc = imgSrc;
        this.price = price;
        this.stock = stock;
        this.category_id = category_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
