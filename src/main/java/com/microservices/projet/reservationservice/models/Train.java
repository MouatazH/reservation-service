package com.microservices.projet.reservationservice.models;

import java.util.List;

public class Train {
    private int id;
    private long num_train;
    private List<Wagon> wagons;

    public Train() {
    }

    public int getId() {
        return id;
    }

    public long getNum_train() {
        return num_train;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_train(long num_train) {
        this.num_train = num_train;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }
}
