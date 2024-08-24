package ConsoleApps.flightreservation;

public class Passenger {
    private static int idCount = 1;
    private int id;
    private String name;
    private int flightId;
    private int bookedSeats;
    private int amountPaid;

    public Passenger(String name, int flightId, int seats) {
        this.id = idCount++;
        this.name = name;
        this.flightId = flightId;
        this.bookedSeats = seats;
        this.amountPaid = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        String str = "";
        str += String.format("Passenger ID : %d%n", this.id);
        str += String.format("Passenger Name : %s%n", this.name);
        str += String.format("Booked Seats : %d%n", this.bookedSeats);
        str += String.format("Amount paid : %d%n", this.amountPaid);
        str += "========================%n";
        return str;
    }
}
