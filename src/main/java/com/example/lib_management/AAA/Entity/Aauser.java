package com.example.lib_management.AAA.Entity;



import javax.persistence.*;
@NamedQueries({
        @NamedQuery(name = "Aauser.findAll", query = "select e from Aauser e ")
        ,
        @NamedQuery(name = "Aauser.findbyUsername", query = "select e from Aauser e where (e.username=:user_name)")
        ,
        @NamedQuery(name = "Aauser.findbyPassword", query = "select e from Aauser e where (e.password=:pass_word)")
})




@Entity
public class Aauser {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String email;
    private String mobile;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleid")
    private Aarole aarole;


    public Aarole getAarole() {
        return aarole;
    }

    public void setAarole(Aarole aarole) {
        this.aarole = aarole;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
