package com.microservices.projet.reservationservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserveId;
    private String voyageId;
    private String departId;
    private String arriveeId;
    private String placeId;
    private String statut;

    public Reservation() {
    }

    public Reservation(String voyageId, String departId, String arriveeId, String placeId, String statut) {
        this.voyageId = voyageId;
        this.departId = departId;
        this.arriveeId = arriveeId;
        this.placeId = placeId;
        this.statut = statut;
    }

    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }

    public String getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(String voyageId) {
        this.voyageId = voyageId;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getArriveeId() {
        return arriveeId;
    }

    public void setArriveeId(String arriveeId) {
        this.arriveeId = arriveeId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reserveId=" + reserveId +
                ", voyageId='" + voyageId + '\'' +
                ", departId='" + departId + '\'' +
                ", arriveeId='" + arriveeId + '\'' +
                ", placeId='" + placeId + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}
