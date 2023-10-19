package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/** This is the Passenger class
 * It hosts details about the passengers
 *
 * @author Rahul Kumar
 * @version 1.0
 * @since 2023-10-18
 */

@Getter
@Setter
public class Passenger {

    private int passengerNumber;
    private String passengerName;
    private double balance;
    private PassengerType passengerType;
    private List<Activity> signedUpActivities;

    public Passenger(int passengerNumber, String passengerName, double balance, PassengerType passengerType){
        this.passengerName = passengerName;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }

    public void registerForActivity(Activity activity){
        if(passengerType == PassengerType.PREMIUM){
            signedUpActivities.add(activity);
        }

        else if(balance >= activity.getCost()){
            signedUpActivities.add(activity);
            if(passengerType == PassengerType.GOLD)
                balance-= 0.9 * activity.getCost();  //10% discount
            else
                balance-= activity.getCost();
        }
        activity.getSignedUpPassengers().add(this);
    }
}
