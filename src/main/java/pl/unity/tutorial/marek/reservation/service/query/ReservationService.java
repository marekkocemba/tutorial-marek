/*
 * Created on 08-07-2019 12:50 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.reservation.service.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.reservation.repository.ReservationRepository;
import pl.unity.tutorial.marek.reservation.service.ReservationMapper;


@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;

	@Autowired
	private ReservationService(ReservationRepository reservationRepository) {

		this.reservationRepository = reservationRepository;
	}

	public List<ReservationDto> getReservationsWhereBooksNotReturned() {

		return reservationRepository.getReservationList()
			.stream()
			.map(ReservationMapper::toReservationDto)
			.collect(Collectors.toList());
	}
}