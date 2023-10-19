package org.example;
/**
 *  This is the driver class
 *  For this project Console based program run is followed.
 *
 * @author Rahul Kumar
 * @version 1.0
 * @since 2023-10-18
 */

public class TravelAgencyService {
    public static void main(String[] args) {
        Activity activity1 = new Activity("Trekking", "Explore the mountains", 50.0, 1);
        Activity activity2 = new Activity("Temple Visit", "Visit the Lakshmi Temple", 30.0, 15);
        Activity activity3 = new Activity("Lake Visit", "Spend time near Lake and go for water activities",100, 10);

        Destination destination = new Destination("Savandurga");
        destination.addActivity(activity1);
        destination.addActivity(activity2);

        Destination destination1 = new Destination("Coorg");
        destination1.addActivity(activity3);

        TravelPackage travelPackage = new TravelPackage("Adventure Trip", 1);
        travelPackage.addDestination(destination);

        TravelPackage travelPackage1 = new TravelPackage("Work-ation",10);
        travelPackage1.addDestination(destination1);


        Passenger passenger1 = new Passenger(1, "Rahul", 100.0, PassengerType.GOLD);
        Passenger passenger2 = new Passenger(2, "Harsh",200.0, PassengerType.STANDARD);
        Passenger passenger3 = new Passenger(3, "Rounak", 0.0, PassengerType.PREMIUM);

        passenger1.registerForActivity(destination.getActivities().get(0));
        passenger2.registerForActivity(destination.getActivities().get(1));
        passenger3.registerForActivity(destination1.getActivities().get(0));

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage1.addPassenger(passenger3);

        PrintUtil printUtil = new PrintUtil();
        printUtil.printItinerary(travelPackage);

        printUtil.printPassengersList(travelPackage);


        printUtil.printPassengerDetails(passenger1);
        printUtil.printAvailableActivities(destination);
    }
}