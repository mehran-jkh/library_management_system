package com.example.lib_management.AAA.Entity;


import com.example.lib_management.AAA.Embedable.Phone;

import javax.persistence.*;
@NamedQueries({
        @NamedQuery(name = "Aauser.findAll", query = "select e from Aauser e ")
        ,
        @NamedQuery(name = "Aauser.findbyUsername", query = "select e from Aauser e where (e.username=:user_name)")
        ,
        @NamedQuery(name = "Aauser.findbyPassword", query = "select e from Aauser e where (e.password=:pass_word)")
        ,
        @NamedQuery(name = "Aauser.findbyUserPass", query = "select e from Aauser e where (e.username=:user_name and e.password=:pass_word)")
})




@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Aauser {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;


    private String username;

    @Column(unique = true)
    private String password;

    private String email;
    private String mobile;

    @Embedded
    private Phone phone;


    @ManyToOne
    @JoinColumn(name = "roleid")
    private Aarole aarole;

    private String Name;

    public Aauser(){}








    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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

    public int getMemmber_id() {
        return user_id;
    }

    public void setMemmber_id(int memmber_id) {
        this.user_id = memmber_id;
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

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
