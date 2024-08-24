package ConsoleApps.taxibooking;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private static int taxiCount = 1;
    int id;
    char location;
    int freeTime;
    int totalEarning;
    List<Booking> bookings = new ArrayList<>();

    public Taxi() {
        this.id = taxiCount++;
        this.location = 'A';
        this.freeTime = 6;
        this.totalEarning = 0;
    }

    public void bookTaxi(Booking booking) {
        location = booking.dropPoint;
        totalEarning += booking.cost;
        freeTime = booking.pickupTime + ((int)Math.abs(booking.pickupPoint - booking.dropPoint));
        bookings.add(booking);
        System.out.println("Taxi " + this.id + " booked. Amount = " + booking.cost);
    }
}
