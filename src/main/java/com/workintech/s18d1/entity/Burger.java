package com.workintech.s18d1.entity;
import jakarta.persistence.*;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "burger" , schema = "public")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    private String contents;


    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }
}

