package com.example.lib_management.BOOK_MANAGEMENT.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQueries
({
        @NamedQuery(name = "BookInfo.findbyid", query = "select e from Book_Information e where (e.id=:id)")

})
public class Book_Information
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;



    private String title;
    private String author;
    private String isbn;
    private boolean is_creation_allowed;

    private Timestamp insert_date;

    private Timestamp last_update_date;












    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
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

    public Timestamp getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Timestamp insert_date) {
        this.insert_date = insert_date;
    }

    public Timestamp getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Timestamp last_update_date) {
        this.last_update_date = last_update_date;
    }
}
