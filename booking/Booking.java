package booking;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

class Flight {
    private String flightId;
    private double economyPrice;
    private double businessPrice;
    private double firstClassPrice;

    public Flight(String flightId, double economyPrice, double businessPrice, double firstClassPrice) {
        this.flightId = flightId;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.firstClassPrice = firstClassPrice;
    }

    public String getFlightId() {
        return flightId;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public double getFirstClassPrice() {
        return firstClassPrice;
    }
}

public class Booking {
    private static final Scanner sc = new Scanner(System.in); // Shared scanner instance

    private String bookingId;
    private String passengerName;
    private String flightId;
    private String seatClass;
    private int numberOfSeats;
    private String foodOption;
    private double paymentAmount;

    public Booking(String bookingId, String passengerName, String flightId, String seatClass,
            int numberOfSeats, String foodOption, double paymentAmount) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.seatClass = seatClass;
        this.numberOfSeats = numberOfSeats;
        this.foodOption = foodOption;
        this.paymentAmount = paymentAmount;
    }

    public static Booking createBooking(Flight flight) {
        try {
            System.out.print("Enter your name: ");
            String name = sc.nextLine().trim();

            // Validate seat class input
            String seatClass;
            while (true) {
                System.out.print("Choose seat class (Economy/Business/First): ");
                seatClass = sc.nextLine().trim();
                if (seatClass.equalsIgnoreCase("economy") ||
                        seatClass.equalsIgnoreCase("business") ||
                        seatClass.equalsIgnoreCase("first")) {
                    break;
                } else {
                    System.out.println("Invalid seat class. Please enter Economy, Business, or First.");
                }
            }

            // Validate seat count input
            int seatCount = 0;
            while (true) {
                System.out.print("Enter number of seats to book: ");
                String seatCountStr = sc.nextLine().trim();
                try {
                    seatCount = Integer.parseInt(seatCountStr);
                    if (seatCount > 0)
                        break;
                    else
                        System.out.println("Number of seats must be greater than zero.");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer for seat count.");
                }
            }

            double seatPrice;
            switch (seatClass.toLowerCase()) {
                case "economy":
                    seatPrice = flight.getEconomyPrice();
                    break;
                case "business":
                    seatPrice = flight.getBusinessPrice();
                    break;
                case "first":
                    seatPrice = flight.getFirstClassPrice();
                    break;
                default:
                    // This case is theoretically unreachable due to validation above
                    System.out.println("Invalid seat class selected.");
                    return null;
            }

            double totalAmount = seatPrice * seatCount;

            System.out.print("Do you want food? (yes/no): ");
            String foodInput = sc.nextLine().trim();
            String foodOption = foodInput.equalsIgnoreCase("yes") ? "Included" : "Not Included";

            if (foodOption.equals("Included")) {
                totalAmount += 300 * seatCount; // ₹300 per seat for food
            }

            System.out.println("Total amount to pay: ₹" + totalAmount);
            System.out.print("Proceed to payment? (yes/no): ");
            String confirm = sc.nextLine().trim();
            if (!confirm.equalsIgnoreCase("yes")) {
                System.out.println("Booking cancelled.");
                return null;
            }

            // Generate booking ID: e.g. BKG202505241530
            String bookingId = "BKG" + LocalDateTime.now().toString()
                    .replaceAll("[-:.T]", "")
                    .substring(0, 12);

            Booking booking = new Booking(bookingId, name, flight.getFlightId(), seatClass,
                    seatCount, foodOption, totalAmount);
            booking.saveBookingToFile();

            System.out.println("Booking successful! Booking ID: " + bookingId);
            return booking;

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return null;
        }
    }

    public void saveBookingToFile() {
        try (FileWriter fw = new FileWriter("booking_log.txt", true)) {
            fw.write(this.toString() + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error writing booking to log: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return bookingId + "," + passengerName + "," + flightId + "," + seatClass + "," +
                numberOfSeats + "," + foodOption + "," + paymentAmount;
    }
}
