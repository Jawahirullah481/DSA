package ConsoleApps.railwayreservation.chatsCode;

public class Passenger {
    private final int id;
    private final String name;
    private final int age;
    private final String preferredBerth;
    private String allocatedBerth;
    private int seatNumber;
    private static int idCount = 1;

    public Passenger(String name, int age, String preferredBerth) {
        this.id = idCount++;
        this.name = name;
        this.age = age;
        this.preferredBerth = preferredBerth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPreferredBerth() {
        return preferredBerth;
    }

    public String getAllocatedBerth() {
        return allocatedBerth;
    }

    public void setAllocatedBerth(String allocatedBerth) {
        this.allocatedBerth = allocatedBerth;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Passenger id: %d%nPassenger Name: %s%nPassenger age: %d%nAllocated Berth: %s%nSeat No: %d%n==========================",
                id, name, age, allocatedBerth, seatNumber
        );
    }
}
