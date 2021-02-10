package com.microservices.projet.reservationservice.ressources;

import com.microservices.projet.reservationservice.entities.Reservation;
import com.microservices.projet.reservationservice.models.Place;
import com.microservices.projet.reservationservice.models.Voyage;
import com.microservices.projet.reservationservice.proxy.TrainProxy;
import com.microservices.projet.reservationservice.proxy.VoyageProxy;
import com.microservices.projet.reservationservice.services.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationRessource {

    @Autowired
    ReservationServiceImpl reservationService;

    @Autowired
    VoyageProxy voyageProxy;
    @Autowired
    TrainProxy trainProxy;

    private DiscoveryClient discoveryClient;
    @GetMapping("/{voyageId}")
    public List<Reservation> createReservation(@PathVariable String voyageId){
        Voyage voy = voyageProxy.getVoyage(voyageId);
        List<Place> places = trainProxy.getPlaceList(voy.getTrainId());
        for(Place plc: places) {
            if(voy.getVoyageId() == "0") break;
            if(plc.getId()==0) break;
            Reservation reservationExists = reservationService.getReservationByVIdPId(voyageId, String.valueOf(plc.getId()));
            if (reservationExists == null) {
                Reservation rr = new Reservation(voy.getVoyageId(), voy.getStartStation(),
                        voy.getEndStation(), String.valueOf(plc.getId()), "nonconfirmé");
                     reservationService.addReservation(rr);
                break;
            }
        }
        return reservationService.getReservationByVId(voyageId);
    }

    @GetMapping("/{reservId}/show")
    public Reservation showReservation(@PathVariable Long reservId){
        return reservationService.getReservation(reservId);
    }

    @PutMapping
    public void modifReservation(@RequestBody Reservation reservation){
        reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{reservId}")
    public void suppReservation(@PathVariable Long reservId){
        reservationService.deleteReservationById(reservId);
    }
}
