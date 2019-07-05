/*
 * Created on 05-07-2019 15:54 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.unity.tutorial.marek.reservation.service.query.ReservationDto;


@Controller
@RequestMapping("/reservations")
public class ReservationEditController {

	@PostMapping("/user/random")
	private String addReservationByBookIdAndRandomUser(@ModelAttribute ReservationDto reservationDto, Model model) {

	//	bookEditService.saveOrUpdateBook(bookForm);
		return "reservation_success";
	}
}
