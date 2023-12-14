package com.example.books.model;

import com.example.books.model.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long isbn;
    @Column(length = 50)
    private String title;
    @Column(length = 500)
    private String synopsis;
    @Column(length = 200)
    private String poster;
    @Column(length = 200)
    private String epub_url;
    @ManyToOne
    @JoinColumn(name = "author_fk")
    private Author author;
    private Integer publicationYear;
}
