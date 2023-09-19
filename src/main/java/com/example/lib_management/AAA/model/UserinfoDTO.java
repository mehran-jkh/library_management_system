package com.example.lib_management.AAA.model;

import com.example.lib_management.AAA.Entity.Aarole;
import com.example.lib_management.AAA.Entity.Aauser;

public class UserinfoDTO {

    private int code;
    private String username;
    private String email;
    private String password;
    private String mobile_number;
    private RoleinfoDTO aarole;

    public UserinfoDTO(Aauser aauser)
    {
        this.code = aauser.getId();
        this.username = aauser.getUsername();
        this.email = aauser.getEmail();
        this.mobile_number = aauser.getMobile();
        this.password=aauser.getPassword();
        this.aarole=new RoleinfoDTO(aauser.getAarole());
    }
    public UserinfoDTO(){}

    public RoleinfoDTO getAarole() {
        return aarole;
    }

    public void setAarole(RoleinfoDTO aarole) {
        this.aarole = aarole;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
