package ConsoleApps.railwayreservation;

import java.util.Scanner;

public class RailwayReservation {

    static Scanner get = new Scanner(System.in);

    public static void main(String[] args) {
        boolean loop = true;
        while(loop) {
            printOptions();
            int option = get.nextInt();

            switch (option) {
                case 1 : {
                    bookTicket();
                }; break;
                case 2 : {
                    cancelTicket();
                }; break;
                case 3 : {
                    TicketBooker.printAvailableTickets();
                }; break;
                case 4 : {
                    TicketBooker.printAllPassengers();
                }; break;
                case 5 : {
                    loop = false;
                }; break;
                default : {
                    System.out.println("Enter Valid Option");
                }
            }
        }
    }

    public static void printOptions() {
        System.out.println("1. Book Ticket");
        System.out.println("2. Cancel Ticket");
        System.out.println("3. Available Tickets");
        System.out.println("4. Booked Tickets");
        System.out.println("5. Exit");
    }

    public static void bookTicket() {
        System.out.println("Enter Name : ");
        String name = get.next();
        System.out.println("Enter Age : ");
        int age = get.nextInt();
        System.out.println("Enter prefereed Berth : [U/L/M]");
        String berth = get.next();

        TicketBooker.bookTicket(new Passenger(name, age, berth));
    }

    public static void cancelTicket() {
        System.out.println("Enter passenger Id :");
        int id = get.nextInt();
        TicketBooker.cancelTicket(id);
    }
}
