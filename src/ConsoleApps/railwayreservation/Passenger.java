package ConsoleApps.railwayreservation;

public class Passenger {
    int id;
    String name;
    int age;
    String preferredBerth;
    String allocatedBerth;
    int seatNumber;
    static int idCount = 1;

    public Passenger(String name, int age, String preferredBerth) {
        this.id = idCount++;
        this.name = name;
        this.age = age;
        this.preferredBerth = preferredBerth;
    }

    @Override
    public String toString() {
        String str = "";
        str += String.format("Passenger id : %d%n", this.id);
        str += String.format("Passenger Name : %s%n", this.name);
        str += String.format("Passenger age : %d%n", this.age);
        str += String.format("Allocated Berth : %s%n", this.allocatedBerth);
        str += String.format("Seat No : %s%n", this.seatNumber);
        str += "==========================";

        return str;
    }
}
