package com.example.lib_management.AAA.model;


import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class RoleinfoDTO {

    private int id;

    @NotBlank(message = "{not-blank.message}")
    private String name;


    @NotBlank(message = "{not-blank.message}")
    private String description;



    @NotNull
    @Min(value = 0 , message = "{min.message}")
    @Digits(integer = 3 ,fraction = 0 , message ="{digits.message}")
    private Integer maxuser;





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
