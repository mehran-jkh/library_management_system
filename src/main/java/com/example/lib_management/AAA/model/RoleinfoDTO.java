package com.example.lib_management.AAA.model;

import com.example.lib_management.AAA.Entity.Aarole;

public class RoleinfoDTO {


    private String name;
    private String description;
    private Integer maxuser;
    private int code;


    public RoleinfoDTO(Aarole aarole)
    {
        this.name=aarole.getName();
        this.maxuser=aarole.getMaxuser();
        this.description=aarole.getDescription();
        this.code=aarole.getId();
    }
    public RoleinfoDTO(){}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
