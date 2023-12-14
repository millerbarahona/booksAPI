package com.example.books.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long isbn;
    private String title;
    private String synopsis;
    private String poster;
    private String epub_url;
    private int authorId;
}
