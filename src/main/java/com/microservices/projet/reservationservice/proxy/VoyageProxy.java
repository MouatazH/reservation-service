package com.microservices.projet.reservationservice.proxy;

import com.microservices.projet.reservationservice.models.Voyage;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class VoyageProxy {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackVoyage", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")

    })
    public Voyage getVoyage(@PathVariable String voyageId){
        //Voyage voyage = restTemplate.getForObject("http://voyage-service/voyages/"+voyageId, Voyage.class);
        Voyage voyage = new Voyage(LocalDate.now(),"Rabat", LocalTime.now(),"Casa",16,"8","366");
        return  voyage;
    }

    public Voyage getFallBackVoyage(String voyageId){
        return new Voyage(LocalDate.now(),"Voyage indisponibl", LocalTime.now(),"",0,"0","0");
    }
}
