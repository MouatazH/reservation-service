package com.microservices.projet.reservationservice.services;

import com.microservices.projet.reservationservice.entities.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation getReservation(Long id);
    List<Reservation> getAllReservations();
    Reservation addReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    void deleteReservation (Reservation r);
    void deleteReservationById(Long id);
    Reservation getReservationByVIdPId(String vId, String pId);
    List<Reservation> getReservationByVId(String vId);

}
