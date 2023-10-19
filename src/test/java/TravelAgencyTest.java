import org.example.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;



public class TravelAgencyTest {

    private TravelPackage travelPackage;
    private Activity activity1;
    private Activity activity2;
    private Destination destination1;

    @Before
    public void setUp(){
        travelPackage = new TravelPackage("Adventure Trip", 20);
        activity1 = new Activity("Trekking", "Explore the mountains", 50.0, 10);
        activity2 = new Activity("Sightseeing", "Visit botanical garden", 30.0, 15);
        destination1 = new Destination("Kodaikanal");
        destination1.addActivity(activity1);
        destination1.addActivity(activity2);
        travelPackage.addDestination(destination1);
    }

    @Test
    public void testSignUpForActivityWithInsufficientBalance(){
        Passenger passenger = new Passenger(2, "Akash",20.0, PassengerType.STANDARD);
        travelPackage.addPassenger(passenger);
        passenger.registerForActivity(activity1);

        assertEquals(0, passenger.getSignedUpActivities().size());
    }

    @Test
    public void testAddPassenger() {
        Passenger passenger1 = new Passenger(1, "Mohan", 100.0, PassengerType.STANDARD);
        travelPackage.addPassenger(passenger1);

        assertEquals(1, travelPackage.getPassengerList().size());
    }

    @Test
    public void testGoldPassengerDiscount() {
        Passenger passenger2 = new Passenger(5, "Ram", 100.0,  PassengerType.GOLD);
        travelPackage.addPassenger(passenger2);
        passenger2.registerForActivity(activity1);

        assertEquals(55, passenger2.getBalance(), 0.01); // 10% discount applied on activity1, so cost is 45.
    }

    @Test
    public void testIsFull() {
        for (int i = 0; i < 10; i++) {
            Passenger passenger = new Passenger(i, "Passenger " + i,100.0 , PassengerType.STANDARD);
            travelPackage.addPassenger(passenger);
            passenger.registerForActivity(activity1);
        }

        assertFalse(activity1.isAvailable());
    }
}
