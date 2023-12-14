package com.example.books.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_fk")
    private Country country;
}
