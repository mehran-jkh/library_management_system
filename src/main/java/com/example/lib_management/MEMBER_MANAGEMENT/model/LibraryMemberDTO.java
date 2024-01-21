package com.example.lib_management.MEMBER_MANAGEMENT.model;

import com.example.lib_management.RESOURCE_MANAGEMENT.model.LibraryDTO;

public class LibraryMemberDTO
{
	private int id;
	private LibraryDTO library;
	private MemberDTO systemMember;













	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LibraryDTO getLibrary() {
		return library;
	}

	public void setLibrary(LibraryDTO library) {
		this.library = library;
	}

	public MemberDTO getSystemMember() {
		return systemMember;
	}

	public void setSystemMember(MemberDTO systemMember) {
		this.systemMember = systemMember;
	}


}
