package com.example.lib_management.AAA.model;




import com.example.lib_management.AAA.Entity.Aapage;
import com.example.lib_management.AAA.Entity.Aarole;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class PageinfoDTO {

    private int code;




    @NotEmpty
    private String name;

    private String description;

    @NotBlank
    private String url;


    public PageinfoDTO(Aapage aapage)
    {
        this.code=aapage.getId();
        this.name=aapage.getName();
        this.description=aapage.getDescription();
        this.url=aapage.getUrl();
    }
    public PageinfoDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
