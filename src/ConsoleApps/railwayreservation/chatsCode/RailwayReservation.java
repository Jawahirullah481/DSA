package ConsoleApps.railwayreservation.chatsCode;

import java.util.Scanner;

public class RailwayReservation {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean loop = true;
        while(loop) {
            printOptions();
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> bookTicket();
                case 2 -> cancelTicket();
                case 3 -> TicketBooker.printAvailableTickets();
                case 4 -> TicketBooker.printAllPassengers();
                case 5 -> loop = false;
                default -> System.out.println("Enter Valid Option");
            }
        }
        scanner.close();
    }

    private static void printOptions() {
        System.out.println("1. Book Ticket");
        System.out.println("2. Cancel Ticket");
        System.out.println("3. Available Tickets");
        System.out.println("4. Booked Tickets");
        System.out.println("5. Exit");
    }

    private static void bookTicket() {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter preferred Berth [U/L/M]: ");
        String berth = scanner.next();

        TicketBooker.bookTicket(new Passenger(name, age, berth));
    }

    private static void cancelTicket() {
        System.out.print("Enter passenger Id: ");
        int id = scanner.nextInt();
        TicketBooker.cancelTicket(id);
    }
}
