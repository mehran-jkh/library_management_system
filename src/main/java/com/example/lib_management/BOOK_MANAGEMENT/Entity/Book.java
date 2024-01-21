package com.example.lib_management.BOOK_MANAGEMENT.Entity;

import com.example.lib_management.RESOURCE_MANAGEMENT.Entity.Library;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQueries
        ({
                @NamedQuery(name = "Library.findbybookinfo", query = "select e.library from Book e where (e.book_info.id=:bookinfo_id)")
        })
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "book_info_id")
    private Book_Information book_info;


    @ManyToOne
    @JoinColumn( name = "lib_info_id")
    private Library library;

    private Timestamp create_date;
    private Timestamp last_update_date;

    private Boolean is_reference;

    private Boolean is_active;

    private Boolean is_in_loan;



    public Library getLibrary()
    {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Boolean getIs_in_loan() {
        return is_in_loan;
    }

    public void setIs_in_loan(Boolean is_in_loan) {
        this.is_in_loan = is_in_loan;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book_Information getBook_info() {
        return book_info;
    }

    public void setBook_info(Book_Information book_info) {
        this.book_info = book_info;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Timestamp last_update_date) {
        this.last_update_date = last_update_date;
    }

    public Boolean getIs_reference() {
        return is_reference;
    }

    public void setIs_reference(Boolean is_reference) {
        this.is_reference = is_reference;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
}
