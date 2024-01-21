package com.example.lib_management.RESOURCE_MANAGEMENT.Entity;


import com.example.lib_management.AAA.Entity.Aauser;


import javax.persistence.*;
@NamedQueries({
		@NamedQuery(name = "Librarian.FindbyUserid", query = "select e from Librarian e where (e.user_id=:user_id)")
			  })
@Entity
public class Librarian extends Aauser
{


	@ManyToOne
	@JoinColumn(name = "library_fk")
	private Library library;

	@Column(unique = true)
	private String personnel_code;








	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public String getPersonnel_code() {
		return personnel_code;
	}

	public void setPersonnel_code(String personnel_code) {
		this.personnel_code = personnel_code;
	}
}
