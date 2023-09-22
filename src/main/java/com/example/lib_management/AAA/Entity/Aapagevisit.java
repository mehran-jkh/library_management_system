package com.example.lib_management.AAA.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Aapagevisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //bi-directional many-to-one association to Aapage
    @ManyToOne
    @JoinColumn(name = "pagefkid")
    private Aapage aapage;

    //bi-directional many-to-one association to Aasession
    @ManyToOne
    @JoinColumn(name = "sessionfkid")
    private Aasession aasession;

    private Timestamp indate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aapage getAapage() {
        return aapage;
    }

    public void setAapage(Aapage aapage) {
        this.aapage = aapage;
    }

    public Aasession getAasession() {
        return aasession;
    }

    public void setAasession(Aasession aasession) {
        this.aasession = aasession;
    }

    public Timestamp getIndate() {
        return indate;
    }

    public void setIndate(Timestamp indate) {
        this.indate = indate;
    }
}
