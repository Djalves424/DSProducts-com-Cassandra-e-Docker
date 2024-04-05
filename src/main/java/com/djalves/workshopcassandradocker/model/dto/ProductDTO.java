package com.djalves.workshopcassandradocker.model.dto;

import com.djalves.workshopcassandradocker.model.embedded.Prop;
import com.djalves.workshopcassandradocker.model.entities.Product;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductDTO {

    private UUID id;
    private String department;
    private Double price;
    private Instant moment;
    private String name;
    private String description;

    private List<Prop> props = new ArrayList<>();

    public ProductDTO() {

    }

    public ProductDTO(UUID id, String department, Double price, Instant moment, String name, String description) {
        this.id = id;
        this.department = department;
        this.price = price;
        this.moment = moment;
        this.name = name;
        this.description = description;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        department = entity.getDepartment();
        price = entity.getPrice();
        moment = entity.getMoment();
        name = entity.getName();
        description = entity.getDescription();
        props.addAll(entity.getProps());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
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

    public List<Prop> getProps() {
        return props;
    }
}
