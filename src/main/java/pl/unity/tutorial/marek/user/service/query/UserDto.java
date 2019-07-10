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

package pl.unity.tutorial.marek.user.service.query;

public class UserDto {

	private final Long id;

	private final String name;

	private final String surname;

	private final String telephone;

	private final String email;

	public UserDto() {

		this.id = null;
		this.name = null;
		this.surname = null;
		this.telephone = null;
		this.email = null;

	}

	public UserDto(Long id, String name, String surname, String email, String telephone) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;

	}

	public Long getId() {

		return id;
	}

	public String getName() {

		return name;
	}

	public String getSurname() {

		return surname;
	}

	public String getTelephone() {

		return telephone;
	}

	public String getEmail() {

		return email;
	}

}
