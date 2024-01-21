package com.example.lib_management.AAA.model;

import com.example.lib_management.costumValidator.annotation.Phone;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserinfoDTO {

    private int user_id;

    @Size(min = 4 , max = 10 ,message = "{size.message}")
    private String username;

    // this is validated by custom spring validator
    private String email;

    // a field for testing formatters
    // for writing custom validations
    @Phone(country_code_digits = 3 ,user_numbers_digits = 5 , message = "phone must have 3 and 5 digits in each field" )
    private PhoneDTO phone;

    // password validating using regex
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special symbol and have a minimum length of 8 characters")
    private String password;

    private RoleinfoDTO roleinfodto;












    public RoleinfoDTO getRoleinfodto() {
        return roleinfodto;
    }

    public void setRoleinfodto(RoleinfoDTO roleinfodto) {
        this.roleinfodto = roleinfodto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public PhoneDTO getPhone() {
        return phone;
    }

    public void setPhone(PhoneDTO phone) {
        this.phone = phone;
    }
}
