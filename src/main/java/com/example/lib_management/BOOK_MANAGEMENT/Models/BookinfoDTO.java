package com.example.lib_management.BOOK_MANAGEMENT.Models;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

public class BookinfoDTO
{

    private int id;

    @NotBlank(message = "{not-blank.message}")
    private String title;

    @NotBlank(message = "{not-blank.message}")
    private String author;

    @Digits(integer = 10 ,fraction = 0 , message ="{digits.message}")
    private String isbn;

    private boolean is_creation_allowed;














    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isIs_creation_allowed() {
        return is_creation_allowed;
    }

    public void setIs_creation_allowed(boolean is_creation_allowed) {
        this.is_creation_allowed = is_creation_allowed;
    }
}
