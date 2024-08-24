package ConsoleApps.railwayreservation.chatsCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketBooker {

    private static final int UPPER_BERTH_COUNT = 1;
    private static final int LOWER_BERTH_COUNT = 1;
    private static final int MIDDLE_BERTH_COUNT = 1;
    private static final int RAC_COUNT = 1;
    private static final int WL_COUNT = 1;

    private static final Queue<Integer> waitingList = new LinkedList<>();
    private static final Queue<Integer> rac = new LinkedList<>();

    private static final List<Integer> lowerBerthPositions = IntStream.range(1, LOWER_BERTH_COUNT + 1).boxed().collect(Collectors.toList());
    private static final List<Integer> upperBerthPositions = IntStream.range(1, UPPER_BERTH_COUNT + 1).boxed().collect(Collectors.toList());
    private static final List<Integer> middleBerthPositions = IntStream.range(1, MIDDLE_BERTH_COUNT + 1).boxed().collect(Collectors.toList());

    private static final Map<Integer, Passenger> passengers = new HashMap<>();
    private static final List<Integer> bookedPassengers = new ArrayList<>();

    public static void bookTicket(Passenger passenger) {
        synchronized (passengers) {
            if (passengers.containsKey(passenger.getId())) {
                System.out.println("Passenger Already available");
                return;
            }

            if (allocateBerth(passenger)) return;
            if (allocateRAC(passenger)) return;
            if (allocateWaitingList(passenger)) return;

            System.out.println("Tickets Not Available!");
        }
    }

    public static void cancelTicket(int passengerId) {
        synchronized (passengers) {
            if (!passengers.containsKey(passengerId)) {
                System.out.println("Passenger Not Available. Unable to Cancel Ticket!");
                return;
            }

            Passenger passenger = passengers.get(passengerId);
            deallocateBerth(passenger);
            handleWaitListAndRAC();
        }
    }

    public static void printAllPassengers() {
        System.out.println("=========== All Passengers ===========");
        passengers.values().forEach(System.out::println);
        System.out.println("=================================");
    }

    public static void printAvailableTickets() {
        System.out.println("============ Available Tickets ============");
        System.out.printf("Upper Berth: %d%n", upperBerthPositions.size());
        System.out.printf("Lower Berth: %d%n", lowerBerthPositions.size());
        System.out.printf("Middle Berth: %d%n", middleBerthPositions.size());
        System.out.printf("RAC: %d%n", (RAC_COUNT - rac.size()));
        System.out.printf("Waiting List: %d%n", (WL_COUNT - waitingList.size()));
        System.out.println("===========================================");
    }

    private static boolean allocateBerth(Passenger passenger) {
        switch (passenger.getPreferredBerth()) {
            case "U" -> {
                return allocateSpecificBerth(passenger, upperBerthPositions, "U");
            }
            case "L" -> {
                return allocateSpecificBerth(passenger, lowerBerthPositions, "L");
            }
            case "M" -> {
                return allocateSpecificBerth(passenger, middleBerthPositions, "M");
            }
            default -> {
                return false;
            }
        }
    }

    private static boolean allocateSpecificBerth(Passenger passenger, List<Integer> berthPositions, String berth) {
        if (!berthPositions.isEmpty()) {
            passenger.setAllocatedBerth(berth);
            passenger.setSeatNumber(berthPositions.remove(0));
            passengers.put(passenger.getId(), passenger);
            bookedPassengers.add(passenger.getId());
            System.out.printf("Ticket Booked Successfully | Berth: %s | Seat No: %d%n", passenger.getAllocatedBerth(), passenger.getSeatNumber());
            return true;
        }
        return false;
    }

    private static boolean allocateRAC(Passenger passenger) {
        if (rac.size() < RAC_COUNT) {
            passenger.setAllocatedBerth("R");
            passenger.setSeatNumber(rac.size() + 1);
            rac.add(passenger.getId());
            passengers.put(passenger.getId(), passenger);
            System.out.println("Ticket booked in RAC");
            return true;
        }
        return false;
    }

    private static boolean allocateWaitingList(Passenger passenger) {
        if (waitingList.size() < WL_COUNT) {
            passenger.setAllocatedBerth("W");
            passenger.setSeatNumber(waitingList.size() + 1);
            waitingList.add(passenger.getId());
            passengers.put(passenger.getId(), passenger);
            System.out.println("Ticket booked in Waiting List");
            return true;
        }
        return false;
    }

    private static void deallocateBerth(Passenger passenger) {
        switch (passenger.getAllocatedBerth()) {
            case "U" -> upperBerthPositions.add(passenger.getSeatNumber());
            case "L" -> lowerBerthPositions.add(passenger.getSeatNumber());
            case "M" -> middleBerthPositions.add(passenger.getSeatNumber());
            case "R" -> rac.remove(passenger.getId());
            case "W" -> waitingList.remove(passenger.getId());
        }
        bookedPassengers.remove((Integer) passenger.getId());
        passengers.remove(passenger.getId());
    }

    private static void handleWaitListAndRAC() {
        if (!rac.isEmpty()) {
            Passenger racPassenger = passengers.remove(rac.poll());
            allocateBerth(racPassenger);
        }
        if (!waitingList.isEmpty()) {
            Passenger waitingListPassenger = passengers.remove(waitingList.poll());
            allocateRAC(waitingListPassenger);
        }
    }
}
