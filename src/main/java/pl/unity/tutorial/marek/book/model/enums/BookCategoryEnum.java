/*
 * Created on 03-07-2019 14:23 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.book.model.enums;

public enum BookCategoryEnum {

	PROZA("proza"), DRAMAT("dramat"), OPOWIADANIE("opowiadanie"), PORADNIK("poradnik");

	private String minuscule;

	BookCategoryEnum(String minuscule) {

		this.minuscule = minuscule;
	}

	public String getMinuscule() {

		return this.minuscule;
	}
}
