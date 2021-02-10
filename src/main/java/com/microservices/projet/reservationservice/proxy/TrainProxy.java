package com.microservices.projet.reservationservice.proxy;

import com.microservices.projet.reservationservice.models.Place;
import com.microservices.projet.reservationservice.models.Wagon;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainProxy {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackPlaces", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")

    })
    public List<Place> getPlaceList(Integer trainId){
/*
        List places = new ArrayList<Place>();
        Place[] place=restTemplate.getForObject("http://place-service/places",Place[].class);
        for(Place pl : place){
            if (pl.getWagon().getTrain().getNum_train() == trainId){
                places.add(pl);
            }
        }
        */
        List<Place> places = Arrays.asList(
                new Place(55,1,new Wagon()),
                new Place(31,1,new Wagon()),
                new Place(32,2,new Wagon()),
                new Place(33,3,new Wagon()),
                new Place(34,4,new Wagon())
        );
        return places;
    }

    public List<Place> getFallBackPlaces(Integer trainId){
         List<Place> places = Arrays.asList(
                new Place(0,0,new Wagon())
        );
         return places;
    }
}
