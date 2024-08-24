package ConsoleApps.flightreservation;

import java.util.HashMap;
import java.util.Map;

public class Flight {
    private static int idCount = 1;
    private int id;
    private String name;
    private int availableSeats = 50;
    private int currentTicketCost = 5000;
    private Map<Integer, Passenger> passengers = new HashMap<>();
    private static final int TICKET_INCREMENT_COST = 200;

    public Flight(String name) {
        this.id = idCount++;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public boolean bookTicket(Passenger passenger) {
        if(availableSeats < passenger.getBookedSeats()) {
            System.out.println("Required seats not available");
            return false;
        }
        int ticketCost = passenger.getBookedSeats() * currentTicketCost;
        passenger.setAmountPaid(ticketCost);
        passengers.put(passenger.getId(), passenger);
        System.out.println("Ticket Booked Successfully. Total Cost : " + ticketCost);

        availableSeats -= passenger.getBookedSeats();
        currentTicketCost += (passenger.getBookedSeats() * TICKET_INCREMENT_COST);
        return true;
    }

    public boolean cancelTicket(int passengerId) {
        Passenger passenger = passengers.remove(passengerId);
        if(passenger == null) {
            System.out.println("Passenger Not available on Flight " + this.id);
            return false;
        }

        availableSeats += passenger.getBookedSeats();
        currentTicketCost -= (passenger.getBookedSeats() * TICKET_INCREMENT_COST);
        System.out.println("Ticket Booked Successfully! Amount Refund : " + passenger.getAmountPaid());
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        str += String.format("Flight Id : %d | ", this.id);
        str += String.format("Flight Name : %s", this.name);
        str += "\n";
        str += "Passengers : \n";
        str += "=============\n";
        for(Passenger passenger : passengers.values()) {
            str += passenger.toString();
        }

        return str;
    }
}
