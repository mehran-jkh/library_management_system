package com.example.lib_management.AAA.model;




import com.example.lib_management.AAA.Entity.Aapage;





public class PageinfoDTO {

    private int id;


    private String name;

    private String description;

    private String url;


    public PageinfoDTO(Aapage aapage)
    {
        this.id =aapage.getId();
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
