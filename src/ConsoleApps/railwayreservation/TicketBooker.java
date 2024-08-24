package ConsoleApps.railwayreservation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketBooker {

    private static final int UPPER_BERTH_COUNT = 1;
    private static final int LOWER_BERTH_COUNT = 1;
    private static final int MIDDLE_BERTH_COUNT = 1;
    private static final int RAC_COUNT = 1;
    private static final int WL_COUNT = 1;

    private static Queue<Integer> waitingList = new LinkedList<>();
    private static Queue<Integer> rac = new LinkedList<>();

    private static List<Integer> lowerBerthPositions = IntStream.range(1, LOWER_BERTH_COUNT + 1).boxed().collect(Collectors.toList());
    private static List<Integer> upperBerthPositions = IntStream.range(1, UPPER_BERTH_COUNT + 1).boxed().collect(Collectors.toList());
    private static List<Integer> middleBerthPositions = IntStream.range(1, MIDDLE_BERTH_COUNT + 1).boxed().collect(Collectors.toList());

    private static Map<Integer, Passenger> passengers = new HashMap<>();
    private static List<Integer> bookedPassengers = new ArrayList<>();

    public static void bookTicket(Passenger passenger) {

        int passengerId = passenger.id;
        if(passengers.containsKey(passengerId)) {
            System.out.println("Passenger Already available");
            return;
        }

        if((passenger.preferredBerth.equals("U") && !upperBerthPositions.isEmpty()) ||
           (passenger.preferredBerth.equals("L") && !lowerBerthPositions.isEmpty()) ||
           (passenger.preferredBerth.equals("M") && !middleBerthPositions.isEmpty())) {

            switch(passenger.preferredBerth) {
                case "U" : {
                    allocateBerth(passenger, "U");
                };break;
                case "L" : {
                    allocateBerth(passenger, "L");
                };break;
                case "M" : {
                    allocateBerth(passenger, "M");
                };break;
                default : {
                    System.out.println("Invalid Berth !");
                    return;
                }
            }
        } else if(!upperBerthPositions.isEmpty()) {
            allocateBerth(passenger, "U");
        } else if(!lowerBerthPositions.isEmpty()) {
            allocateBerth(passenger, "L");
        } else if(!middleBerthPositions.isEmpty()) {
            allocateBerth(passenger, "M");
        } else if(rac.size() < RAC_COUNT) {
            passenger.allocatedBerth = "R";
            passenger.seatNumber = rac.size() + 1;
            rac.add(passengerId);
            passengers.put(passengerId, passenger);
            System.out.println("Ticket booked in RAC");
        } else if(waitingList.size() < WL_COUNT) {
            passenger.allocatedBerth = "W";
            passenger.seatNumber = waitingList.size() + 1;
            waitingList.add(passengerId);
            passengers.put(passengerId, passenger);
            System.out.println("Ticket booked in Waiting List");
        } else {
            System.out.println("Tickets Not Available!");
        }
    }

    public static void cancelTicket(int passengerId) {
        if(!passengers.containsKey(passengerId)) {
            System.out.println("Passenger Not Available. Unable to Cancel Ticket !");
            return;
        }

        Passenger passenger = passengers.get(passengerId);
        if(passenger.allocatedBerth.equals("U") || passenger.allocatedBerth.equals("L") || passenger.allocatedBerth.equals("M")) {
            removeFromBerth(passenger);
            if(!rac.isEmpty()) {
                Passenger racPassenger = removeFromRAC();
                bookTicket(racPassenger);
            }
            if(!waitingList.isEmpty()) {
                Passenger waitingListPassenger = removeFromWL();
                bookTicket(waitingListPassenger);
            }
        } else if(passenger.allocatedBerth.equals("R")) {
            rac.remove(passengerId);
            passengers.remove(passengerId);
            if(!waitingList.isEmpty()) {
                Passenger waitingListPassenger = removeFromWL();
                bookTicket(waitingListPassenger);
            }
        } else if(passenger.allocatedBerth.equals("W")) {
           waitingList.remove(passengerId);
           passengers.remove(passengerId);
        }
    }

    public static void printAllPassengers() {
        System.out.println("=========== All Passengers ===========");
        passengers.values().forEach(System.out::println);
        System.out.println("=================================");
    }

    public static void printAvailableTickets() {
        System.out.println("============ Available Tickets ============");
        System.out.println("Upper Berth : " + upperBerthPositions.size());
        System.out.println("Lower Berth : " + lowerBerthPositions.size());
        System.out.println("Middle Berth : " + middleBerthPositions.size());
        System.out.println("RAC : " + (RAC_COUNT - rac.size()));
        System.out.println("Waiting List : " + (WL_COUNT - waitingList.size()));
        System.out.println("===========================================");
    }


    // Helper methods
    private static void allocateBerth(Passenger passenger, String berth) {
        switch(berth) {
            case "U" : {
                passenger.allocatedBerth = "U";
                passenger.seatNumber = upperBerthPositions.get(0);
                upperBerthPositions.remove(0);
            }; break;
            case "L" : {
                passenger.allocatedBerth = "L";
                passenger.seatNumber = lowerBerthPositions.get(0);
                lowerBerthPositions.remove(0);
            }; break;
            case "M" : {
                passenger.allocatedBerth = "M";
                passenger.seatNumber = middleBerthPositions.get(0);
                middleBerthPositions.remove(0);
            }
        }
        bookedPassengers.add(passenger.id);
        passengers.put(passenger.id, passenger);
        System.out.println("Ticket Booked Successfully | Berth : " + passenger.allocatedBerth + " | Seat No : " + passenger.seatNumber);
    }

    public static void removeFromBerth(Passenger passenger) {
        int passengerId = passenger.id;
        String berth = passenger.allocatedBerth;
        int seatNo = passenger.seatNumber;
        switch(berth) {
            case "U" : {
                upperBerthPositions.add(seatNo);
            }; break;
            case "L" : {
                lowerBerthPositions.add(seatNo);
            }; break;
            case "M" : {
                middleBerthPositions.add(seatNo);
            };
        }
        bookedPassengers.remove(passengerId);
        passengers.remove(passengerId);
    }

    public static Passenger removeFromRAC() {
        Integer id = rac.poll();
        Passenger p = passengers.get(id);
        passengers.remove(id);
        return p;
    }

    public static Passenger removeFromWL() {
        Integer id = waitingList.poll();
        Passenger p = passengers.get(id);
        passengers.remove(id);
        return p;
    }
}
