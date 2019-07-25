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

import static org.springframework.util.Assert.notNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.unity.tutorial.marek.reservation.service.query.ReservationService;


@Controller
@RequestMapping("/reservations")
class ReservationController {

	public static final String RESERVATION_LIST_VIEW = "reservation_list";
	public static final String M_RESERVATION_LIST = "reservationList";

	private final ReservationService reservationService;

	@Autowired
	private ReservationController(ReservationService reservationService) {

		notNull(reservationService, "ReservationService should be not null");

		this.reservationService = reservationService;
	}

	@GetMapping("/book/available/false")
	private String getReservationsWhereBooksNotReturned(Model model) {

		model.addAttribute(M_RESERVATION_LIST, reservationService.getReservationsWhereBooksNotReturned());

		return RESERVATION_LIST_VIEW;
	}
}