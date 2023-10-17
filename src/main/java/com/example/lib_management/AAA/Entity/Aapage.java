package com.example.lib_management.AAA.Entity;



import com.example.lib_management.AAA.model.PageinfoDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aapage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String name;
    private String pagename;
    private String url;


    public Aapage(PageinfoDTO pageinfoDTO){
        this.setUrl(pageinfoDTO.getUrl());
        this.name=pageinfoDTO.getName();
        this.description=pageinfoDTO.getDescription();
        this.id=pageinfoDTO.getId();
    }
    public Aapage(){}

    @OneToMany(mappedBy="aapage", cascade = CascadeType.ALL)
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

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
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
