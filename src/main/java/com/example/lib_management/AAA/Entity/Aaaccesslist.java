package com.example.lib_management.AAA.Entity;


import javax.persistence.*;

@Entity
@NamedQueries(
        {
        @NamedQuery(name = "Aaaccesslist.findAll", query = "SELECT a FROM Aaaccesslist a")
        ,
        @NamedQuery(name = "Aaaccesslist.findAccessListbyRole", query = "SELECT a FROM Aaaccesslist a where a.aarole.id=:RoleId")
        ,
        @NamedQuery(name = "Aaaccesslist.deletebyid", query = "delete  FROM Aaaccesslist e where e.aarole.id=:RoleId")
        }
)

public class Aaaccesslist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "rolefkid")
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

    public Object getAarole() {
        return aarole;
    }

    public void setAarole(Aarole aarole) {
        this.aarole = aarole;
    }

}
