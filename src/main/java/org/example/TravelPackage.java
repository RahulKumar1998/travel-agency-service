package org.example;

/** This is the travel package class
 * It hosts different activities and destinations
 *
 * @author Rahul Kumar
 * @version 1.0
 * @since 2023-10-18
 */

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TravelPackage {
    private String packageName;
    private int passengerCapacity;
    private List<Destination> destinationList;
    private List<Passenger> passengerList;


    public TravelPackage(String packageName, int passengerCapacity){
        this.packageName = packageName;
        this.passengerCapacity = passengerCapacity;
        this.destinationList = new ArrayList<>();
        this.passengerList = new ArrayList<>();
    }

    public void addDestination(Destination destination){
        destinationList.add(destination);
    }

    public void addPassenger(Passenger passenger){
        if(passengerList.size() < passengerCapacity)
                passengerList.add(passenger);
        else
            System.out.println("Error adding the passenger: "+ passenger.getPassengerName()+ " ERROR= Passenger limit has been reached for this tour package!");
    }


}


