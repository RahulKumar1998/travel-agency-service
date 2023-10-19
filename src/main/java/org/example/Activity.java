package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *  This is the Activity class
 * @author Rahul Kumar
 * @version 1.0
 * @since 2023-10-18
 */

@Getter
@Setter
public class Activity {

    private String name;
    private String description;
    private double cost;
    private int capacity;
    private String destinationName;
    private List<Passenger> signedUpPassengers;

    public Activity(String name, String description, double cost, int capacity){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.signedUpPassengers = new ArrayList<>();
    }

    public boolean isAvailable(){
        return (signedUpPassengers.size() < capacity);
    }
}
