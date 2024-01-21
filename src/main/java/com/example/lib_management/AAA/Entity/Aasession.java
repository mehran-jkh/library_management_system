package com.example.lib_management.AAA.Entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Aasession {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cilent;

    private Boolean ismanuallylogout;

    private Timestamp logindate;

    private Timestamp logoutdate;

    //uni-directional many-to-one association to Aauser
    @ManyToOne
    @JoinColumn(name = "userid")
    private Aauser aauser;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCilent() {
        return cilent;
    }

    public void setCilent(String cilent) {
        this.cilent = cilent;
    }

    public Boolean getIsmanuallylogout() {
        return ismanuallylogout;
    }

    public void setIsmanuallylogout(Boolean ismanuallylogout) {
        this.ismanuallylogout = ismanuallylogout;
    }

    public Timestamp getLogindate() {
        return logindate;
    }

    public void setLogindate(Timestamp logindate) {
        this.logindate = logindate;
    }

    public Timestamp getLogoutdate() {
        return logoutdate;
    }

    public void setLogoutdate(Timestamp logoutdate) {
        this.logoutdate = logoutdate;
    }

    public Aauser getAauser() {
        return aauser;
    }

    public void setAauser(Aauser aauser) {
        this.aauser = aauser;
    }

}