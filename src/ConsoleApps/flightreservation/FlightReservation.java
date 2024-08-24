package ConsoleApps.flightreservation;

import java.util.Scanner;

public class FlightReservation {
    private static final Scanner get = new Scanner(System.in);

    public static void main(String[] args) {
        FlightTicketBooker booker = new FlightTicketBooker();
        createFlights(booker);

        boolean loop = true;
        while(loop) {
           printOptions();
           int option = get.nextInt();
           switch(option) {
               case 1: { bookTicket(booker); }; break;
               case 2: { cancelTicket(booker); }; break;
               case 3: { booker.printAvailableTickets(); }; break;
               case 4: { booker.printFlightDetails(); }; break;
               case 5: { loop = false; }; break;
               default:{ System.out.println("Enter Valid Option"); };
            }
        }
    }

    public static void printOptions() {
        System.out.println("1. Book Ticket");
        System.out.println("2. Cancel Ticket");
        System.out.println("3. Available Tickets");
        System.out.println("4. Passenger Details");
        System.out.println("5. Exit");
    }

    public static void bookTicket(FlightTicketBooker booker) {
        System.out.println("Enter passenger Name");
        String name = get.next();
        System.out.println("Enter Flight Id");
        int flightId = get.nextInt();
        System.out.println("Enter Required Seats");
        int seats = get.nextInt();

        Passenger passenger = new Passenger(name, flightId, seats);
        booker.bookTicket(passenger);
    }

    public static void cancelTicket(FlightTicketBooker booker) {
        System.out.println("Enter passenger Id : ");
        int passengerId = get.nextInt();
        booker.cancelTicket(passengerId);
    }

    public static void createFlights(FlightTicketBooker booker) {
        booker.createFlight("Air Asia");
        booker.createFlight("Fly Emirates");
        booker.createFlight("Qatar Airways");
    }
}
