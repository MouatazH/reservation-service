package com.microservices.projet.reservationservice.models;

public class Place {

    int id;
    int num_place;
    private Wagon wagon;

    public Place() {
    }

    public Place(int id, int num_place, Wagon wagon) {
        this.id = id;
        this.num_place = num_place;
        this.wagon = wagon;
    }

    public int getId() {
        return id;
    }

    public int getNum_place() {
        return num_place;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_place(int num_place) {
        this.num_place = num_place;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }
}
