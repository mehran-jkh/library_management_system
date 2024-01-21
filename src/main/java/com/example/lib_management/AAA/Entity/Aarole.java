package com.example.lib_management.AAA.Entity;


import javax.persistence.*;

import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Aarole.findbyId", query = "select e FROM Aarole e where e.id=:RoleId")
        }
)
public class Aarole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String name;
    private Integer maxuser;

    @OneToMany(mappedBy = "aarole", cascade = CascadeType.REMOVE)
    private List<Aauser> aausers;

    @OneToMany(mappedBy = "aarole", cascade = CascadeType.REMOVE)
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
