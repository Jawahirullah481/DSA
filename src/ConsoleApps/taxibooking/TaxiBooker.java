package ConsoleApps.taxibooking;


import java.util.*;

public class TaxiBooker {
    private List<Taxi> taxis = new ArrayList<>();

    public void createTaxis(int count) {
        for(int i = 0; i < count; i++) {
            Taxi taxi = new Taxi();
            taxis.add(taxi);
        }
    }

    public void bookTaxi(Booking booking) {
        List<Taxi> freeTaxis = getAvailableTaxis(booking.pickupTime, booking.pickupPoint);
        if(freeTaxis.isEmpty()) {
            System.out.println("Sorry! No Taxi Available");
            return;
        }

        Taxi nearestTaxi = freeTaxis.get(0);

        if(freeTaxis.size() > 1) {
        // Logic to get nearest taxi
        int minimumDistance = (int)(Math.abs((freeTaxis.get(0).location - booking.pickupPoint)));

        for(int i = 1; i < freeTaxis.size(); i++) {
            Taxi taxi = freeTaxis.get(i);
            int distance = (int)(Math.abs(taxi.location - booking.pickupPoint));
            if(distance < minimumDistance) {
                minimumDistance = distance;
                nearestTaxi = taxi;
            } else if(distance == minimumDistance && taxi.totalEarning < nearestTaxi.totalEarning) {
                nearestTaxi = taxi;
            }
        }
        }

        nearestTaxi.bookTaxi(booking);

    }

    public void printTaxiDetails() {
        taxis.forEach(taxi -> {
            System.out.println("Taxi - " + taxi.id + "   Total Earnings : " + taxi.totalEarning);
            System.out.println("======================");
            System.out.printf("%-15s %-15s %-10s %-10s %-20s %-20s %-15s%n", "Booking ID", "Customer ID", "From", "To", "Pickup Time", "Drop Time", "Amount");
            taxi.bookings.forEach(booking -> {
                System.out.printf("%-15d %-15d %-10c %-10c %-20d %-20d %-15d%n", booking.id, booking.customerId, booking.pickupPoint, booking.dropPoint, booking.pickupTime, booking.dropTime, booking.cost);
            });
            System.out.println();
        });
    }

    public List<Taxi> getAvailableTaxis(int pickupTime, char pickupPoint) {
        /*
            1. Check if taxi is free at pickupTime.
            2. If it is free, then check
               A. time taken for taxi to reach pickup point.
               B. time difference between taxi's free time and pickuptime.
         */
        List<Taxi> freeTaxis = new ArrayList<>();
        for(Taxi taxi : taxis) {
            int distance = (int)Math.abs(((int)pickupPoint - taxi.location));
            int timeToReachPickupPoint = pickupTime - taxi.freeTime;

            if(timeToReachPickupPoint >= 0 && (distance <= timeToReachPickupPoint)) {
                freeTaxis.add(taxi);
            }
        }

        return freeTaxis;
    }

}
