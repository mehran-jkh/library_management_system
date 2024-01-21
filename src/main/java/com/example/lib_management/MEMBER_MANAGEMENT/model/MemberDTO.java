package com.example.lib_management.MEMBER_MANAGEMENT.model;

import com.example.lib_management.AAA.model.UserinfoDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MemberDTO extends UserinfoDTO
{
	@NotBlank(message =  "{not-blank.message}"  )
	private String name;

	@Size(min = 10 , max = 10 ,message = "national code should have exactly 10 digits")
	private String national_code ;

	private String address ;
	private String job ;
	private String degree ;
	private MemberTypeDTO memberTypeDTO;












	public MemberTypeDTO getMemberTypeDTO() {
		return memberTypeDTO;
	}

	public void setMemberTypeDTO(MemberTypeDTO memberTypeDTO) {
		this.memberTypeDTO = memberTypeDTO;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
}
