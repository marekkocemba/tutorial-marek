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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.unity.tutorial.marek.book.service.query.BookDto;
import pl.unity.tutorial.marek.reservation.service.command.ReservationEditService;
import pl.unity.tutorial.marek.reservation.service.query.ReservationDto;


@Controller
@RequestMapping("/reservations")
public class ReservationEditController {

	private final ReservationEditService reservationEditService;

	@Autowired
	private ReservationEditController(ReservationEditService reservationEditService) {

		this.reservationEditService = reservationEditService;
	}

	@PostMapping("/user/random")
	private String addReservationByBookAndRandomUser(@ModelAttribute BookDto bookDto, Model model) {
		try {
			ReservationDto reservationDto = reservationEditService.addReservationByBookAndRandomUser(bookDto);
			model.addAttribute("reservation", reservationDto);
			return "reservation_success";
		}
		catch (Exception e){
			return "reservation_fail";
		}
	}

	@PostMapping("/return")
	private String returnReservationByBook(@ModelAttribute BookDto bookDto, Model model) {
		try {
			reservationEditService.returnReservationByBook(bookDto);
			return "reservation_success";
		}
		catch (Exception e){
			e.printStackTrace();
			return "reservation_fail";
		}
	}
}
