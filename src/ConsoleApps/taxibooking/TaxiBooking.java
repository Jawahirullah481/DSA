package ConsoleApps.taxibooking;

import java.util.Scanner;

public class TaxiBooking {
    private static Scanner get = new Scanner(System.in);
    private static int customerCount = 1;

    public static void main(String[] args) {
        TaxiBooker booker = new TaxiBooker();
        booker.createTaxis(4);

        boolean loop = true;
        while(loop) {
            printOptions();
            int choice = get.nextInt();
            switch(choice) {
                case 1: { bookTaxi(booker); }; break;
                case 2: { booker.printTaxiDetails(); }; break;
                case 3: { loop = false; }; break;
                default:{ System.out.println("Invalid Input"); };
            }
        }
    }

    public static void printOptions() {
        System.out.println("1. Book Taxi");
        System.out.println("2. Print Taxi Details");
        System.out.println("3. Exit");
    }

    public static void bookTaxi(TaxiBooker booker) {
        System.out.println("Enter Pickup Point (A, B, C, D, E, F) : ");
        char pickupPoint = get.next().charAt(0);
        System.out.println("Enter Drop Point (A, B, C, D, E, F) : ");
        char dropPoint = get.next().charAt(0);
        System.out.println("Enter Pickup Time");
        int pickupTime = get.nextInt();

        Booking booking = new Booking(pickupPoint, dropPoint, pickupTime, customerCount++);
        booker.bookTaxi(booking);
    }
}
