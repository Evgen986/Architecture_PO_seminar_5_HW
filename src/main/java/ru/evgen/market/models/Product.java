package ru.evgen.market.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class Product{

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    private String number;
    @Column(name = "name")
    private String name;
    @Column(name = "applying")
    private String applying;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "balance")
    private Double balance;
}
