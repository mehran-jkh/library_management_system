package com.example.lib_management.AAA.Entity;


import javax.persistence.*;

@Entity
public class Aaaccesslist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "roleidx")
    private Aarole aarole;

    @ManyToOne
    @JoinColumn(name = "pagefkid")
    private Aapage aapage;

    public Aapage getAapage() {
        return aapage;
    }

    public void setAapage(Aapage aapage) {
        this.aapage = aapage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aarole getAarole() {
        return aarole;
    }

    public void setAarole(Aarole aarole) {
        this.aarole = aarole;
    }

}
