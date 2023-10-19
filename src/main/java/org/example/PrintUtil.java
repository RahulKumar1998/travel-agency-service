package org.example;

/** This class is the Utility for Print functions present earlier
 * in the classes. These functions were segregated out to adhere to the
 * Single responsibility principle of SOLID principles.
 *
 * @author Rahul Kumar
 * @version 1.0
 * @since 2023-10-18
 */

public class PrintUtil {

    public void printItinerary(TravelPackage travelPackage){
        System.out.println("Travel Package: " + travelPackage.getPackageName());

        for(Destination destination : travelPackage.getDestinationList()){
            System.out.println("Destination: " + destination.getDestinationName());
            for (Activity activity : destination.getActivities()){
                System.out.println("Activity: " + activity.getName());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
                System.out.println("Description: " + activity.getDescription());
            }
        }
    }

    public void printPassengersList(TravelPackage travelPackage){
        System.out.println(">>> Printing passengers details for the following package: <<<");
        System.out.println("Travel Package: " + travelPackage.getPackageName());
        System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengerList().size());
        System.out.println("Passenger List:");
        for (Passenger passenger : travelPackage.getPassengerList()) {
            System.out.println("Name: " + passenger.getPassengerName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        }
    }
    public void printPassengerDetails(Passenger passenger){
        System.out.println(">>> Printing details for the following passenger: <<<");
        System.out.println("Passenger Name: " + passenger.getPassengerName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        System.out.println("remaining balance: "+ passenger.getBalance());
        for (Activity activity : passenger.getSignedUpActivities()) {
            System.out.println("Activity Name: " + activity.getName());
            System.out.println("Activity Destination: " + activity.getDestinationName());
            double price = 0.0;
            if(passenger.getPassengerType() == PassengerType.GOLD)
                price = activity.getCost() * 0.9;
            else if(passenger.getPassengerType() == PassengerType.STANDARD)
                price = activity.getCost();
            System.out.println("Price paid for the activity: "+ price);
        }
    }

    public void printAvailableActivities(Destination destination){
        System.out.println(">>> Printing details of available activities for the destination: " + destination.getDestinationName());

        for (Activity activity : destination.getActivities()){
            if(activity.getCapacity()-activity.getSignedUpPassengers().size()>0) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Capacity: " + (activity.getCapacity()-activity.getSignedUpPassengers().size()));
            }
        }
    }
}
