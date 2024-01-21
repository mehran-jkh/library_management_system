package com.example.lib_management.AAA.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aapage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String name;
    private String url;


    @OneToMany(mappedBy="aapage", cascade = CascadeType.REMOVE)
    private List<Aaaccesslist> aaaccesslists;













    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Aaaccesslist> getAaaccesslists() {
        return aaaccesslists;
    }

    public void setAaaccesslists(List<Aaaccesslist> aaaccesslists) {
        this.aaaccesslists = aaaccesslists;
    }


























}
