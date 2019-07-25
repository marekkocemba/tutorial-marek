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

import static org.springframework.util.Assert.notNull;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.reservation.repository.ReservationRepository;
import pl.unity.tutorial.marek.reservation.service.ReservationMapper;


@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;
	private final ReservationMapper reservationMapper;

	@Autowired
	private ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {

		notNull(reservationRepository, "reservationRepository must not be null");
		notNull(reservationMapper, "reservationMapper must not be null");

		this.reservationRepository = reservationRepository;
		this.reservationMapper = reservationMapper;

	}

	public List<ReservationDto> getReservationsWhereBooksNotReturned() {

		return reservationRepository.getReservationList()
			.stream()
			.map(reservationMapper::toReservationDto)
			.collect(Collectors.toList());
	}
}