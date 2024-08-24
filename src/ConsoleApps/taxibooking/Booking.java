package ConsoleApps.taxibooking;

public class Booking {
    private static int bookCount = 1;
    int id;
    char pickupPoint;
    char dropPoint;
    int pickupTime;
    int dropTime;
    int cost;
    int customerId;

    public Booking(char pickupPoint, char dropPoint, int pickupTime, int customerId) {
        this.id = bookCount++;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.customerId = customerId;
        this.pickupTime = pickupTime;
        this.dropTime = pickupTime + (Math.abs(pickupPoint - dropPoint));

        int totalDistance = ((int)(Math.abs(pickupPoint - dropPoint))) * 15;
        this.cost = 100 + (totalDistance - 5) * 10;
    }

}
