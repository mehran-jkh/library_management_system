package com.example.lib_management.RESOURCE_MANAGEMENT.model;

import com.example.lib_management.AAA.model.UserinfoDTO;

import javax.validation.constraints.Size;

public class LibrarianDTO extends UserinfoDTO
{

	private LibraryDTO libraryDTO;

	@Size(min = 6 , max = 6)
	private String personnel_code;

	public LibraryDTO getLibraryDTO()
	{
		return libraryDTO;
	}

	public void setLibraryDTO(LibraryDTO libraryDTO) {
		this.libraryDTO = libraryDTO;
	}

	public String getPersonnel_code() {
		return personnel_code;
	}

	public void setPersonnel_code(String personnel_code) {
		this.personnel_code = personnel_code;
	}
}
