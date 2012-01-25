package mmorpg.project;

import java.util.*;

import javax.validation.constraints.Size;

public class Account {

	String name;
	List<Character> listOfCharacters = new ArrayList<Character>();
	Date dateOfCreate;

	public Account(String name, Date dateOfCreate) {
		this.name = name;
		this.listOfCharacters = new ArrayList<Character>();
		this.dateOfCreate 
		= dateOfCreate;
	}
	
	@Size(min = 1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Character> getListOfCharacters() {
		return listOfCharacters;
	}

	public void setListOfGame(List<Character> listOfCharacters) {
		this.listOfCharacters = listOfCharacters;
	}

	public Date getDateOfCreate() {
		return dateOfCreate;
	}

	public void setDateOfCreate(Date dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}
	


}
