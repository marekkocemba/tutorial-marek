/*
 * Created on 05-07-2019 13:41 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.user.service.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


public class UserForm {

	private Long id;
	@NotNull
	@Size(min = 2, max = 30)
	private String name;
	@NotNull
	@Size(min = 2, max = 30)
	private String surname;
	private String telephone;
	@Email
	private String email;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getSurname() {

		return surname;
	}

	public void setSurname(String surname) {

		this.surname = surname;
	}

	public String getTelephone() {

		return telephone;
	}

	public void setTelephone(String telephone) {

		this.telephone = telephone;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}
}
