package com.example.lib_management.AAA.model;

import com.example.lib_management.AAA.Entity.Aarole;

public class RoleinfoDTO {


    private String name;
    private String description;
    private Integer maxuser;
    private int id;


    public RoleinfoDTO(Aarole aarole)
    {
        this.name=aarole.getName();
        this.maxuser=aarole.getMaxuser();
        this.description=aarole.getDescription();
        this.id=aarole.getId();
    }
    public RoleinfoDTO(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMaxuser() {
        return maxuser;
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

    public void setMaxuser(Integer maxuser) {
        this.maxuser = maxuser;
    }
}
