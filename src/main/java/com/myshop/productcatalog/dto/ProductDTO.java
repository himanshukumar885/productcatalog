package com.myshop.productcatalog.dto;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;

    // Constructor
    public ProductDTO(Long id, String name,
            String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters only! No setters needed!
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}