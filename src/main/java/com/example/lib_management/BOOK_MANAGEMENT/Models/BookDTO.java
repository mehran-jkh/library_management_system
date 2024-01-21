package com.example.lib_management.BOOK_MANAGEMENT.Models;

import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibraryDTO;

public class BookDTO
{
   private int id;
   private BookinfoDTO book_info;
   private Boolean is_reference;
   private Boolean is_active;
   private LibraryDTO library;;





    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookinfoDTO getBook_info() {
        return book_info;
    }

    public void setBook_info(BookinfoDTO book_info)
    {
        this.book_info = book_info;
    }

    public Boolean getIs_reference() {
        return is_reference;
    }

    public void setIs_reference(Boolean is_reference) {
        this.is_reference = is_reference;
    }

    public LibraryDTO getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDTO library) {
        this.library = library;
    }




}
