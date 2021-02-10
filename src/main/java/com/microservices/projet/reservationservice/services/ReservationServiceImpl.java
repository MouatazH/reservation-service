package com.microservices.projet.reservationservice.services;

import com.microservices.projet.reservationservice.entities.Reservation;
import com.microservices.projet.reservationservice.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void deleteReservation(Reservation r) {
        reservationRepository.delete(r);
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservationByVIdPId(String vId,String pId){
        return reservationRepository.findReservationsByVoyageAndPlace(vId,pId);
    }

    @Override
    public List<Reservation> getReservationByVId(String vId){
        return reservationRepository.findReservationsByVoyage(vId);
    }
}
