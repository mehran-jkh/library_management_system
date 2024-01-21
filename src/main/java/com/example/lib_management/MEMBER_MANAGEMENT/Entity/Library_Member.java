package com.example.lib_management.MEMBER_MANAGEMENT.Entity;

import com.example.lib_management.RESOURCE_MANAGEMENT.Entity.Library;


import javax.persistence.*;

@Entity
@NamedQueries
(
		{
				@NamedQuery(name = "LibraryMember.findbyNationalcodeAndLibrary", query = "select e FROM Library_Member e where e.systemMember.national_code=:national_code and e.library.id=:libid")
		}
)
public class Library_Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;



	@ManyToOne
	@JoinColumn(name = "library_id")
	private Library library;


	@ManyToOne
	@JoinColumn(name = "systemmember_id" , referencedColumnName = "user_id")
	private System_Member systemMember;






	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public System_Member getSystemMember() {
		return systemMember;
	}

	public void setSystemMember(System_Member systemMember) {
		this.systemMember = systemMember;
	}
}
