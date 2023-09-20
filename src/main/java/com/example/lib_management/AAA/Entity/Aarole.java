package com.example.lib_management.AAA.Entity;

import com.example.lib_management.AAA.model.RoleinfoDTO;

import javax.persistence.*;

import java.util.List;

@Entity
public class Aarole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String name;
    private Integer maxuser;

    public Aarole(RoleinfoDTO roleinfoDTO)
    {
        this.name= roleinfoDTO.getName();
        this.maxuser= roleinfoDTO.getMaxuser();
        this.description= roleinfoDTO.getDescription();
        this.id=roleinfoDTO.getCode();
    }
    public Aarole(){}

    @OneToMany(mappedBy = "aarole", cascade = CascadeType.ALL)
    private List<Aauser> aausers;

    @OneToMany(mappedBy = "aarole", cascade = CascadeType.ALL)
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

    public Integer getMaxuser() {
        return maxuser;
    }

    public void setMaxuser(Integer maxuser) {
        this.maxuser = maxuser;
    }
}
