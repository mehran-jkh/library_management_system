package com.example.lib_management.MEMBER_MANAGEMENT.Entity;

import com.example.lib_management.AAA.Entity.Aauser;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "SystemMember.findbyNationalcode", query = "select e FROM System_Member e where e.national_code=:national_code")
        }
)
public class System_Member extends Aauser
{

    // it uses the super_id

    private String name;

    @Column(unique = true)
    private String national_code ;

    private String address ;
    private String job ;
    private String degree ;


    @ManyToOne
    @JoinColumn(name = "membertype_fk")
    private Memeber_Type memeber_type;


    @OneToMany(mappedBy = "systemMember" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Library_Member> libraryMemberList;













    public String getNational_code() {
        return national_code;
    }

    public void setNational_code(String national_code) {
        this.national_code = national_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


    public Memeber_Type getMemeber_type() {
        return memeber_type;
    }

    public void setMemeber_type(Memeber_Type memeber_type) {
        this.memeber_type = memeber_type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<Library_Member> getLibraryMemberList() {
        return libraryMemberList;
    }

    public void setLibraryMemberList(List<Library_Member> libraryMemberList) {
        this.libraryMemberList = libraryMemberList;
    }
}
