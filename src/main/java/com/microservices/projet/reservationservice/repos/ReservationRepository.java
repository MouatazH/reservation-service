package com.microservices.projet.reservationservice.repos;

import com.microservices.projet.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select r from Reservation r where r.voyageId = :voyageid and r.placeId = :placeid")
    Reservation findReservationsByVoyageAndPlace(@Param("voyageid") String voyageid, @Param("placeid") String placeid);

    @Query("select r from Reservation r where r.voyageId = :voyageid")
    List<Reservation> findReservationsByVoyage(@Param("voyageid") String voyageid);
}
