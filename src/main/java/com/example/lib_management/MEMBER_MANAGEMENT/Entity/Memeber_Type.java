package com.example.lib_management.MEMBER_MANAGEMENT.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Memeber_Type {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String membertype_name;

    private int penalty_per_day;

    private int max_books;

    private int max_days;

    private int registration_fee;










    public String getMembertype_name() {
        return membertype_name;
    }

    public void setMembertype_name(String membertype_name) {
        this.membertype_name = membertype_name;
    }

    public int getPenalty_per_day() {
        return penalty_per_day;
    }

    public void setPenalty_per_day(int penalty_per_day) {
        this.penalty_per_day = penalty_per_day;
    }

    public int getMax_books() {
        return max_books;
    }

    public void setMax_books(int max_books) {
        this.max_books = max_books;
    }

    public int getMax_days() {
        return max_days;
    }

    public void setMax_days(int max_days) {
        this.max_days = max_days;
    }

    public int getRegistration_fee() {
        return registration_fee;
    }

    public void setRegistration_fee(int registration_fee) {
        this.registration_fee = registration_fee;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
