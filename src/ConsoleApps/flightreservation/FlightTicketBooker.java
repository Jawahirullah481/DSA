package ConsoleApps.flightreservation;

import java.util.HashMap;
import java.util.Map;

public class FlightTicketBooker {
    private static final int FLIGHT_SEATS = 50;
    private Map<Integer, Flight> flights = new HashMap<>();
    private Map<Integer, Passenger> passengers = new HashMap<>();

    public void bookTicket(Passenger passenger) {
        Flight flight = flights.get(passenger.getFlightId());
        if(flight == null) {
            System.out.println("No available flight");
            return;
        }

        if(flight.bookTicket(passenger)) {
            passengers.put(passenger.getId(), passenger);
        }
    }

    public void cancelTicket(int passengerId) {
        if(!passengers.containsKey(passengerId)) {
            System.out.println("Passenger Not Available");
            return;
        }

        int flightId = passengers.get(passengerId).getFlightId();
        Flight flight = flights.get(flightId);
        if(flight.cancelTicket(passengerId)) {
            passengers.remove(passengerId);
        }
    }

    public void createFlight(String name) {
        Flight flight = new Flight(name);
        flights.put(flight.getId(), flight);
    }

    public void printFlightDetails() {
        flights.values().forEach(System.out::println);
        System.out.println("\n\n");
    }

    public void printAvailableTickets() {
        flights.values().forEach(flight -> {
            System.out.println("Flight Id : " + flight.getId() + " | Flight Name : " + flight.getName() + " | Available Seats : " + flight.getAvailableSeats());
        });
        System.out.println("\n");
    }
}
