/*
 * import java.io.*;
 * import java.util.*;
 * import java.util.regex.*;
 * 
 * class Flight {
 * int flightNo;
 * String destination;
 * String departureTime;
 * int totalSeats;
 * int bookedSeats;
 * 
 * Flight(int flightNo, String destination, String time, int seats) {
 * this.flightNo = flightNo;
 * this.destination = destination;
 * this.departureTime = time;
 * this.totalSeats = seats;
 * this.bookedSeats = 0;
 * }
 * 
 * void showDetails(PrintWriter out) {
 * out.println("Flight No: " + flightNo + ", Destination: " + destination +
 * ", Time: " + departureTime
 * + ", Seats: " + bookedSeats + "/" + totalSeats);
 * }
 * 
 * boolean hasAvailableSeats() {
 * return bookedSeats < totalSeats;
 * }
 * 
 * void bookSeat() {
 * if (hasAvailableSeats()) {
 * bookedSeats++;
 * }
 * }
 * 
 * void cancelSeat() {
 * if (bookedSeats > 0) {
 * bookedSeats--;
 * }
 * }
 * }
 * 
 * public class FlightManagementSystem {
 * static final int MAX_FLIGHTS = 5;
 * static Flight[] flights = new Flight[MAX_FLIGHTS];
 * static Queue<Integer> bookingQueue = new java.util.LinkedList<>();
 * static HashMap<Integer, String> bookings = new HashMap<>();
 * 
 * public static void main(String[] args) {
 * try {
 * Scanner sc = new Scanner(new File("input.txt"));
 * PrintWriter out = new PrintWriter("output.txt");
 * initializeFlights();
 * 
 * int choice;
 * do {
 * // Menu for terminal only (not in output.txt)
 * System.out.
 * println("\n1. Show Flights\n2. Book Ticket\n3. Cancel Ticket\n4. View Bookings\n5. Exit"
 * );
 * System.out.print("Enter your choice: ");
 * choice = Integer.parseInt(sc.nextLine());
 * 
 * switch (choice) {
 * case 1:
 * showFlights(out);
 * break;
 * case 2:
 * bookTicket(sc, out);
 * break;
 * case 3:
 * cancelTicket(sc, out);
 * break;
 * case 4:
 * viewBookings(out);
 * break;
 * case 5:
 * out.println("Exiting system.");
 * break;
 * default:
 * out.println("Invalid choice.");
 * out.println();
 * }
 * 
 * } while (choice != 5);
 * 
 * sc.close();
 * out.close();
 * 
 * } catch (Exception e) {
 * System.out.println("Error: " + e.getMessage());
 * }
 * }
 * 
 * static void initializeFlights() {
 * flights[0] = new Flight(101, "Delhi", "10:00 AM", 3);
 * flights[1] = new Flight(102, "Mumbai", "11:30 AM", 2);
 * flights[2] = new Flight(103, "Chennai", "01:00 PM", 4);
 * flights[3] = new Flight(104, "Kolkata", "03:15 PM", 3);
 * flights[4] = new Flight(105, "Bangalore", "06:00 PM", 5);
 * }
 * 
 * static void showFlights(PrintWriter out) {
 * out.println("Available Flights:");
 * for (Flight flight : flights) {
 * flight.showDetails(out);
 * }
 * out.println(); // Blank line after flight list
 * }
 * 
 * static void bookTicket(Scanner sc, PrintWriter out) {
 * int flightNo = Integer.parseInt(sc.nextLine());
 * String name = sc.nextLine();
 * 
 * for (Flight flight : flights) {
 * if (flight.flightNo == flightNo) {
 * if (flight.hasAvailableSeats()) {
 * flight.bookSeat();
 * int bookingID = new Random().nextInt(10000);
 * bookings.put(bookingID, name + " (Flight " + flightNo + ")");
 * bookingQueue.offer(bookingID);
 * out.println("Ticket booked successfully! Booking ID: " + bookingID);
 * out.println(); // Blank line after booking
 * } else {
 * out.println("No seats available!");
 * out.println();
 * }
 * return;
 * }
 * }
 * 
 * out.println("Flight not found.");
 * out.println();
 * }
 * 
 * static void cancelTicket(Scanner sc, PrintWriter out) {
 * int bookingID = Integer.parseInt(sc.nextLine());
 * 
 * if (bookings.containsKey(bookingID)) {
 * String details = bookings.remove(bookingID);
 * Pattern pattern = Pattern.compile("Flight (\\d+)");
 * Matcher matcher = pattern.matcher(details);
 * int flightNo = -1;
 * 
 * if (matcher.find()) {
 * flightNo = Integer.parseInt(matcher.group(1));
 * }
 * 
 * for (Flight flight : flights) {
 * if (flight.flightNo == flightNo) {
 * flight.cancelSeat();
 * break;
 * }
 * }
 * 
 * bookingQueue.remove(bookingID);
 * out.println("Booking cancelled for: " + details);
 * out.println();
 * } else {
 * out.println("Booking ID not found.");
 * out.println();
 * }
 * }
 * 
 * static void viewBookings(PrintWriter out) {
 * out.println("All Bookings:");
 * for (Map.Entry<Integer, String> entry : bookings.entrySet()) {
 * out.println("Booking ID: " + entry.getKey() + ", Passenger: " +
 * entry.getValue());
 * }
 * out.println(); // Blank line after booking list
 * }
 * }
 * correct code at 4April 10:20
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * import java.io.*;
 * import java.util.*;
 * 
 * class Flight {
 * String flightNo;
 * String destination;
 * String departureTime;
 * int totalSeats;
 * int bookedSeats;
 * 
 * Flight(String flightNo, String destination, String departureTime, int
 * totalSeats) {
 * this.flightNo = flightNo;
 * this.destination = destination;
 * this.departureTime = departureTime;
 * this.totalSeats = totalSeats;
 * this.bookedSeats = 0;
 * }
 * 
 * boolean bookSeat() {
 * if (bookedSeats < totalSeats) {
 * bookedSeats++;
 * return true;
 * }
 * return false;
 * }
 * 
 * boolean cancelSeat() {
 * if (bookedSeats > 0) {
 * bookedSeats--;
 * return true;
 * }
 * return false;
 * }
 * }
 * 
 * class Booking {
 * String bookingID;
 * String flightNo;
 * String passengerName;
 * String bookingDate;
 * String contactInfo;
 * 
 * Booking(String bookingID, String flightNo, String passengerName, String
 * bookingDate, String contactInfo) {
 * this.bookingID = bookingID;
 * this.flightNo = flightNo;
 * this.passengerName = passengerName;
 * this.bookingDate = bookingDate;
 * this.contactInfo = contactInfo;
 * }
 * }
 * 
 * public class FlightManagementSystem {
 * static final int MAX_FLIGHTS = 100;
 * static Flight[] flights = new Flight[MAX_FLIGHTS];
 * static int flightCount = 0;
 * static Map<String, Booking> bookings = new HashMap<>();
 * static final String ADMIN_PASSWORD = "admin123";
 * 
 * public static void main(String[] args) {
 * try {
 * Scanner sc = new Scanner(new File("input.txt"));
 * PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
 * 
 * while (sc.hasNext()) {
 * String command = sc.next();
 * switch (command) {
 * case "ADD_FLIGHT":
 * if (adminLogin(sc)) {
 * String flightNo = sc.next();
 * String destination = sc.next();
 * String departureTime = sc.next();
 * int totalSeats = sc.nextInt();
 * addFlight(flightNo, destination, departureTime, totalSeats, out);
 * } else {
 * out.println("Access denied.");
 * }
 * break;
 * 
 * case "DISPLAY_FLIGHTS":
 * displayFlights(out);
 * break;
 * 
 * case "BOOK_TICKET":
 * String bookingID = sc.next();
 * String flightNo = sc.next();
 * String passengerName = sc.next();
 * String bookingDate = sc.next();
 * String contactInfo = sc.next();
 * bookTicket(bookingID, flightNo, passengerName, bookingDate, contactInfo,
 * out);
 * break;
 * 
 * case "CANCEL_TICKET":
 * bookingID = sc.next();
 * cancelTicket(bookingID, out);
 * break;
 * 
 * case "EXPORT_SYSTEM":
 * exportSystemData(out);
 * break;
 * 
 * default:
 * out.println("Invalid command: " + command);
 * break;
 * }
 * }
 * 
 * sc.close();
 * out.close();
 * 
 * } catch (IOException e) {
 * System.out.println("Error: " + e.getMessage());
 * }
 * }
 * 
 * static boolean adminLogin(Scanner sc) {
 * System.out.println("Enter admin password:");
 * String password = sc.next();
 * return ADMIN_PASSWORD.equals(password);
 * }
 * 
 * static void addFlight(String flightNo, String destination, String
 * departureTime, int totalSeats, PrintWriter out) {
 * if (flightCount < MAX_FLIGHTS) {
 * flights[flightCount++] = new Flight(flightNo, destination, departureTime,
 * totalSeats);
 * out.println("Flight added successfully.");
 * } else {
 * out.println("Flight limit reached.");
 * }
 * out.println();
 * }
 * 
 * static void displayFlights(PrintWriter out) {
 * out.println("Flight List:");
 * for (int i = 0; i < flightCount; i++) {
 * Flight f = flights[i];
 * out.
 * printf("Flight No: %s, Destination: %s, Departure: %s, Total Seats: %d, Booked Seats: %d%n"
 * ,
 * f.flightNo, f.destination, f.departureTime, f.totalSeats, f.bookedSeats);
 * }
 * out.println();
 * }
 * 
 * static void bookTicket(String bookingID, String flightNo, String
 * passengerName, String bookingDate,
 * String contactInfo, PrintWriter out) {
 * Flight flight = findFlight(flightNo);
 * if (flight != null && flight.bookSeat()) {
 * bookings.put(bookingID, new Booking(bookingID, flightNo, passengerName,
 * bookingDate, contactInfo));
 * out.println("Ticket booked successfully.");
 * } else {
 * out.println("Booking failed. Flight full or does not exist.");
 * }
 * out.println();
 * }
 * 
 * static void cancelTicket(String bookingID, PrintWriter out) {
 * Booking booking = bookings.remove(bookingID);
 * if (booking != null) {
 * Flight flight = findFlight(booking.flightNo);
 * if (flight != null && flight.cancelSeat()) {
 * out.println("Ticket cancelled successfully.");
 * } else {
 * out.println("Cancellation failed. Flight not found.");
 * }
 * } else {
 * out.println("Booking ID not found.");
 * }
 * out.println();
 * }
 * 
 * static Flight findFlight(String flightNo) {
 * for (int i = 0; i < flightCount; i++) {
 * if (flights[i].flightNo.equals(flightNo)) {
 * return flights[i];
 * }
 * }
 * return null;
 * }
 * 
 * static void exportSystemData(PrintWriter out) {
 * try {
 * // Export Flights to CSV
 * PrintWriter flightCsv = new PrintWriter("flights.csv");
 * flightCsv.
 * println("Flight No,Destination,Departure Time,Total Seats,Booked Seats");
 * for (int i = 0; i < flightCount; i++) {
 * Flight f = flights[i];
 * flightCsv.println(f.flightNo + "," + f.destination + "," + f.departureTime +
 * "," + f.totalSeats + ","
 * + f.bookedSeats);
 * }
 * flightCsv.close();
 * 
 * // Export Bookings to CSV
 * PrintWriter bookingCsv = new PrintWriter("bookings.csv");
 * bookingCsv.
 * println("Booking ID,Flight No,Passenger Name,Booking Date,Contact Info");
 * for (Booking b : bookings.values()) {
 * bookingCsv.println(b.bookingID + "," + b.flightNo + "," + b.passengerName +
 * "," + b.bookingDate + ","
 * + b.contactInfo);
 * }
 * bookingCsv.close();
 * 
 * out.
 * println("System data exported successfully to flights.csv and bookings.csv."
 * );
 * out.println();
 * } catch (Exception e) {
 * out.println("Error exporting system data: " + e.getMessage());
 * out.println();
 * }
 * }
 * }
 * 
 * 22 April 2025 7:16pm
 */

/*
 * import java.io.*;
 * import java.util.*;
 * import java.util.regex.*;
 * 
 * class Flight {
 * int flightNo;
 * String destination;
 * String departureTime;
 * int totalSeats;
 * int bookedSeats;
 * 
 * Flight(int flightNo, String destination, String time, int seats) {
 * this.flightNo = flightNo;
 * this.destination = destination;
 * this.departureTime = time;
 * this.totalSeats = seats;
 * this.bookedSeats = 0;
 * }
 * 
 * void showDetails(PrintWriter out) {
 * out.println("Flight No: " + flightNo + ", Destination: " + destination +
 * ", Time: " + departureTime
 * + ", Seats: " + bookedSeats + "/" + totalSeats);
 * }
 * 
 * boolean hasAvailableSeats() {
 * return bookedSeats < totalSeats;
 * }
 * 
 * void bookSeat() {
 * if (hasAvailableSeats()) {
 * bookedSeats++;
 * }
 * }
 * 
 * void cancelSeat() {
 * if (bookedSeats > 0) {
 * bookedSeats--;
 * }
 * }
 * }
 * 
 * public class FlightManagementSystem {
 * static final int MAX_FLIGHTS = 5;
 * static Flight[] flights = new Flight[MAX_FLIGHTS];
 * static Queue<Integer> bookingQueue = new java.util.LinkedList<>();
 * static HashMap<Integer, String> bookings = new HashMap<>();
 * 
 * public static void main(String[] args) {
 * try {
 * Scanner sc = new Scanner(new File("input.txt"));
 * PrintWriter out = new PrintWriter("output.txt");
 * initializeFlights();
 * 
 * int choice;
 * do {
 * // Menu for terminal only (not in output.txt)
 * System.out.
 * println("\n1. Show Flights\n2. Book Ticket\n3. Cancel Ticket\n4. View Bookings\n5. Exit"
 * );
 * System.out.print("Enter your choice: ");
 * choice = Integer.parseInt(sc.nextLine());
 * 
 * switch (choice) {
 * case 1:
 * showFlights(out);
 * break;
 * case 2:
 * bookTicket(sc, out);
 * break;
 * case 3:
 * cancelTicket(sc, out);
 * break;
 * case 4:
 * viewBookings(out);
 * break;
 * case 5:
 * out.println("Exiting system.");
 * break;
 * default:
 * out.println("Invalid choice.");
 * out.println();
 * }
 * 
 * } while (choice != 5);
 * 
 * sc.close();
 * out.close();
 * 
 * } catch (Exception e) {
 * System.out.println("Error: " + e.getMessage());
 * }
 * }
 * 
 * static void initializeFlights() {
 * flights[0] = new Flight(101, "Delhi", "10:00 AM", 3);
 * flights[1] = new Flight(102, "Mumbai", "11:30 AM", 2);
 * flights[2] = new Flight(103, "Chennai", "01:00 PM", 4);
 * flights[3] = new Flight(104, "Kolkata", "03:15 PM", 3);
 * flights[4] = new Flight(105, "Bangalore", "06:00 PM", 5);
 * }
 * 
 * static void showFlights(PrintWriter out) {
 * out.println("Available Flights:");
 * for (Flight flight : flights) {
 * flight.showDetails(out);
 * }
 * out.println(); // Blank line after flight list
 * }
 * 
 * static void bookTicket(Scanner sc, PrintWriter out) {
 * int flightNo = Integer.parseInt(sc.nextLine());
 * String name = sc.nextLine();
 * 
 * for (Flight flight : flights) {
 * if (flight.flightNo == flightNo) {
 * if (flight.hasAvailableSeats()) {
 * flight.bookSeat();
 * int bookingID = new Random().nextInt(10000);
 * bookings.put(bookingID, name + " (Flight " + flightNo + ")");
 * bookingQueue.offer(bookingID);
 * out.println("Ticket booked successfully! Booking ID: " + bookingID);
 * out.println(); // Blank line after booking
 * } else {
 * out.println("No seats available!");
 * out.println();
 * }
 * return;
 * }
 * }
 * 
 * out.println("Flight not found.");
 * out.println();
 * }
 * 
 * static void cancelTicket(Scanner sc, PrintWriter out) {
 * int bookingID = Integer.parseInt(sc.nextLine());
 * 
 * if (bookings.containsKey(bookingID)) {
 * String details = bookings.remove(bookingID);
 * Pattern pattern = Pattern.compile("Flight (\\d+)");
 * Matcher matcher = pattern.matcher(details);
 * int flightNo = -1;
 * 
 * if (matcher.find()) {
 * flightNo = Integer.parseInt(matcher.group(1));
 * }
 * 
 * for (Flight flight : flights) {
 * if (flight.flightNo == flightNo) {
 * flight.cancelSeat();
 * break;
 * }
 * }
 * 
 * bookingQueue.remove(bookingID);
 * out.println("Booking cancelled for: " + details);
 * out.println();
 * } else {
 * out.println("Booking ID not found.");
 * out.println();
 * }
 * }
 * 
 * static void viewBookings(PrintWriter out) {
 * out.println("All Bookings:");
 * for (Map.Entry<Integer, String> entry : bookings.entrySet()) {
 * out.println("Booking ID: " + entry.getKey() + ", Passenger: " +
 * entry.getValue());
 * }
 * out.println(); // Blank line after booking list
 * }
 * }
 * correct code at 4April 10:20
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * import java.io.*;
 * import java.util.*;
 * 
 * class Flight {
 * String flightNo;
 * String destination;
 * String departureTime;
 * int totalSeats;
 * int bookedSeats;
 * 
 * Flight(String flightNo, String destination, String departureTime, int
 * totalSeats) {
 * this.flightNo = flightNo;
 * this.destination = destination;
 * this.departureTime = departureTime;
 * this.totalSeats = totalSeats;
 * this.bookedSeats = 0;
 * }
 * 
 * boolean bookSeat() {
 * if (bookedSeats < totalSeats) {
 * bookedSeats++;
 * return true;
 * }
 * return false;
 * }
 * 
 * boolean cancelSeat() {
 * if (bookedSeats > 0) {
 * bookedSeats--;
 * return true;
 * }
 * return false;
 * }
 * }
 * 
 * class Booking {
 * String bookingID;
 * String flightNo;
 * String passengerName;
 * String bookingDate;
 * String contactInfo;
 * 
 * Booking(String bookingID, String flightNo, String passengerName, String
 * bookingDate, String contactInfo) {
 * this.bookingID = bookingID;
 * this.flightNo = flightNo;
 * this.passengerName = passengerName;
 * this.bookingDate = bookingDate;
 * this.contactInfo = contactInfo;
 * }
 * }
 * 
 * public class FlightManagementSystem {
 * static final int MAX_FLIGHTS = 100;
 * static Flight[] flights = new Flight[MAX_FLIGHTS];
 * static int flightCount = 0;
 * static Map<String, Booking> bookings = new HashMap<>();
 * static final String ADMIN_PASSWORD = "admin123";
 * 
 * public static void main(String[] args) {
 * try {
 * Scanner sc = new Scanner(new File("input.txt"));
 * PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
 * 
 * while (sc.hasNext()) {
 * String command = sc.next();
 * switch (command) {
 * case "ADD_FLIGHT":
 * if (adminLogin(sc)) {
 * String flightNo = sc.next();
 * String destination = sc.next();
 * String departureTime = sc.next();
 * int totalSeats = sc.nextInt();
 * addFlight(flightNo, destination, departureTime, totalSeats, out);
 * } else {
 * out.println("Access denied.");
 * }
 * break;
 * 
 * case "DISPLAY_FLIGHTS":
 * displayFlights(out);
 * break;
 * 
 * case "BOOK_TICKET":
 * String bookingID = sc.next();
 * String flightNo = sc.next();
 * String passengerName = sc.next();
 * String bookingDate = sc.next();
 * String contactInfo = sc.next();
 * bookTicket(bookingID, flightNo, passengerName, bookingDate, contactInfo,
 * out);
 * break;
 * 
 * case "CANCEL_TICKET":
 * bookingID = sc.next();
 * cancelTicket(bookingID, out);
 * break;
 * 
 * case "EXPORT_SYSTEM":
 * exportSystemData(out);
 * break;
 * 
 * default:
 * out.println("Invalid command: " + command);
 * break;
 * }
 * }
 * 
 * sc.close();
 * out.close();
 * 
 * } catch (IOException e) {
 * System.out.println("Error: " + e.getMessage());
 * }
 * }
 * 
 * static boolean adminLogin(Scanner sc) {
 * System.out.println("Enter admin password:");
 * String password = sc.next();
 * return ADMIN_PASSWORD.equals(password);
 * }
 * 
 * static void addFlight(String flightNo, String destination, String
 * departureTime, int totalSeats, PrintWriter out) {
 * if (flightCount < MAX_FLIGHTS) {
 * flights[flightCount++] = new Flight(flightNo, destination, departureTime,
 * totalSeats);
 * out.println("Flight added successfully.");
 * } else {
 * out.println("Flight limit reached.");
 * }
 * out.println();
 * }
 * 
 * static void displayFlights(PrintWriter out) {
 * out.println("Flight List:");
 * for (int i = 0; i < flightCount; i++) {
 * Flight f = flights[i];
 * out.
 * printf("Flight No: %s, Destination: %s, Departure: %s, Total Seats: %d, Booked Seats: %d%n"
 * ,
 * f.flightNo, f.destination, f.departureTime, f.totalSeats, f.bookedSeats);
 * }
 * out.println();
 * }
 * 
 * static void bookTicket(String bookingID, String flightNo, String
 * passengerName, String bookingDate,
 * String contactInfo, PrintWriter out) {
 * Flight flight = findFlight(flightNo);
 * if (flight != null && flight.bookSeat()) {
 * bookings.put(bookingID, new Booking(bookingID, flightNo, passengerName,
 * bookingDate, contactInfo));
 * out.println("Ticket booked successfully.");
 * } else {
 * out.println("Booking failed. Flight full or does not exist.");
 * }
 * out.println();
 * }
 * 
 * static void cancelTicket(String bookingID, PrintWriter out) {
 * Booking booking = bookings.remove(bookingID);
 * if (booking != null) {
 * Flight flight = findFlight(booking.flightNo);
 * if (flight != null && flight.cancelSeat()) {
 * out.println("Ticket cancelled successfully.");
 * } else {
 * out.println("Cancellation failed. Flight not found.");
 * }
 * } else {
 * out.println("Booking ID not found.");
 * }
 * out.println();
 * }
 * 
 * static Flight findFlight(String flightNo) {
 * for (int i = 0; i < flightCount; i++) {
 * if (flights[i].flightNo.equals(flightNo)) {
 * return flights[i];
 * }
 * }
 * return null;
 * }
 * 
 * static void exportSystemData(PrintWriter out) {
 * try {
 * // Export Flights to CSV
 * PrintWriter flightCsv = new PrintWriter("flights.csv");
 * flightCsv.
 * println("Flight No,Destination,Departure Time,Total Seats,Booked Seats");
 * for (int i = 0; i < flightCount; i++) {
 * Flight f = flights[i];
 * flightCsv.println(f.flightNo + "," + f.destination + "," + f.departureTime +
 * "," + f.totalSeats + ","
 * + f.bookedSeats);
 * }
 * flightCsv.close();
 * 
 * // Export Bookings to CSV
 * PrintWriter bookingCsv = new PrintWriter("bookings.csv");
 * bookingCsv.
 * println("Booking ID,Flight No,Passenger Name,Booking Date,Contact Info");
 * for (Booking b : bookings.values()) {
 * bookingCsv.println(b.bookingID + "," + b.flightNo + "," + b.passengerName +
 * "," + b.bookingDate + ","
 * + b.contactInfo);
 * }
 * bookingCsv.close();
 * 
 * out.
 * println("System data exported successfully to flights.csv and bookings.csv."
 * );
 * out.println();
 * } catch (Exception e) {
 * out.println("Error exporting system data: " + e.getMessage());
 * out.println();
 * }
 * }
 * }
 * 
 * 
 * 22 april 2025 7:49pm
 */
/*
 * import java.io.*;
 * import java.util.*;
 * 
 * class Flight {
 * String flightNo;
 * String destination;
 * String departureTime;
 * int economySeats, businessSeats, firstClassSeats;
 * int bookedEconomy, bookedBusiness, bookedFirst;
 * String status;
 * 
 * Flight(String flightNo, String destination, String departureTime,
 * int economySeats, int businessSeats, int firstClassSeats, String status) {
 * this.flightNo = flightNo;
 * this.destination = destination;
 * this.departureTime = departureTime;
 * this.economySeats = economySeats;
 * this.businessSeats = businessSeats;
 * this.firstClassSeats = firstClassSeats;
 * this.bookedEconomy = 0;
 * this.bookedBusiness = 0;
 * this.bookedFirst = 0;
 * this.status = status;
 * }
 * 
 * boolean bookSeat(String seatClass) {
 * switch (seatClass.toLowerCase()) {
 * case "economy":
 * if (bookedEconomy < economySeats) {
 * bookedEconomy++;
 * return true;
 * }
 * break;
 * case "business":
 * if (bookedBusiness < businessSeats) {
 * bookedBusiness++;
 * return true;
 * }
 * break;
 * case "first":
 * if (bookedFirst < firstClassSeats) {
 * bookedFirst++;
 * return true;
 * }
 * break;
 * }
 * return false;
 * }
 * 
 * boolean cancelSeat(String seatClass) {
 * switch (seatClass.toLowerCase()) {
 * case "economy":
 * if (bookedEconomy > 0) {
 * bookedEconomy--;
 * return true;
 * }
 * break;
 * case "business":
 * if (bookedBusiness > 0) {
 * bookedBusiness--;
 * return true;
 * }
 * break;
 * case "first":
 * if (bookedFirst > 0) {
 * bookedFirst--;
 * return true;
 * }
 * break;
 * }
 * return false;
 * }
 * 
 * void showFlight(PrintWriter out) {
 * out.printf("Flight No: %s | Destination: %s | Departure: %s | Status: %s%n",
 * flightNo, destination, departureTime, status);
 * out.printf("Economy: %d/%d | Business: %d/%d | First: %d/%d%n",
 * bookedEconomy, economySeats, bookedBusiness, businessSeats, bookedFirst,
 * firstClassSeats);
 * }
 * }
 * 
 * class Booking {
 * String bookingID;
 * String flightNo;
 * String passengerName;
 * String travelDate;
 * String phone;
 * String seatClass;
 * 
 * Booking(String bookingID, String flightNo, String passengerName, String
 * travelDate, String phone,
 * String seatClass) {
 * this.bookingID = bookingID;
 * this.flightNo = flightNo;
 * this.passengerName = passengerName;
 * this.travelDate = travelDate;
 * this.phone = phone;
 * this.seatClass = seatClass;
 * }
 * 
 * void showBooking(PrintWriter out) {
 * out.
 * printf("Booking ID: %s | Flight No: %s | Name: %s | Date: %s | Phone: %s | Class: %s%n"
 * ,
 * bookingID, flightNo, passengerName, travelDate, phone, seatClass);
 * }
 * }
 * 
 * public class FlightManagementSystem {
 * static Map<String, Flight> flights = new HashMap<>();
 * static Map<String, Booking> bookings = new HashMap<>();
 * 
 * public static void main(String[] args) {
 * try {
 * Scanner scanner = new Scanner(new File("input.txt"));
 * PrintWriter writer = new PrintWriter("output.txt");
 * 
 * while (scanner.hasNextLine()) {
 * String line = scanner.nextLine();
 * String[] cmd = line.split(" ");
 * String action = cmd[0];
 * 
 * switch (action) {
 * case "ADD_FLIGHT":
 * String flightNo = cmd[1];
 * String destination = cmd[2];
 * String departure = cmd[3];
 * int ecoSeats = Integer.parseInt(cmd[4]);
 * int busSeats = Integer.parseInt(cmd[5]);
 * int firstSeats = Integer.parseInt(cmd[6]);
 * String status = cmd[7];
 * flights.put(flightNo,
 * new Flight(flightNo, destination, departure, ecoSeats, busSeats, firstSeats,
 * status));
 * writer.println("Flight added: " + flightNo);
 * break;
 * 
 * case "BOOK_TICKET":
 * String bookingID = cmd[1];
 * flightNo = cmd[2];
 * String name = cmd[3];
 * String date = cmd[4];
 * String phone = cmd[5];
 * String seatClass = cmd[6].toLowerCase();
 * 
 * Flight flight = flights.get(flightNo);
 * if (flight != null && flight.bookSeat(seatClass)) {
 * Booking booking = new Booking(bookingID, flightNo, name, date, phone,
 * seatClass);
 * bookings.put(bookingID, booking);
 * writer.println("Booking successful: " + bookingID);
 * logBooking(booking);
 * } else {
 * writer.println("Booking failed for flight: " + flightNo + " in class: " +
 * seatClass);
 * }
 * break;
 * 
 * case "CANCEL_TICKET":
 * bookingID = cmd[1];
 * Booking cancelled = bookings.remove(bookingID);
 * if (cancelled != null) {
 * flight = flights.get(cancelled.flightNo);
 * if (flight != null && flight.cancelSeat(cancelled.seatClass)) {
 * writer.println("Booking cancelled: " + bookingID);
 * } else {
 * writer.println("Cancellation failed: " + bookingID);
 * }
 * } else {
 * writer.println("Booking ID not found: " + bookingID);
 * }
 * break;
 * 
 * case "SHOW_FLIGHTS":
 * for (Flight f : flights.values()) {
 * f.showFlight(writer);
 * }
 * break;
 * 
 * case "SHOW_BOOKINGS":
 * for (Booking b : bookings.values()) {
 * b.showBooking(writer);
 * }
 * break;
 * 
 * default:
 * writer.println("Invalid command: " + action);
 * }
 * }
 * 
 * scanner.close();
 * writer.close();
 * 
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * }
 * 
 * static void logBooking(Booking booking) {
 * try (PrintWriter log = new PrintWriter(new FileWriter("booking_log.txt",
 * true))) {
 * log.printf("BookingID: %s | Name: %s | Flight: %s | Class: %s%n",
 * booking.bookingID, booking.passengerName, booking.flightNo,
 * booking.seatClass);
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 * }
 * }
 * 
 * 
 * 
 * 
 * 
 * import java.io.*;
 * import java.util.*;
 * 
 * class Flight {
 * String flightNo;
 * String destination;
 * String departureTime;
 * int economySeats, businessSeats, firstClassSeats;
 * int bookedEconomy, bookedBusiness, bookedFirst;
 * String status;
 * 
 * Flight(String flightNo, String destination, String departureTime,
 * int economySeats, int businessSeats, int firstClassSeats, String status) {
 * this.flightNo = flightNo;
 * this.destination = destination;
 * this.departureTime = departureTime;
 * this.economySeats = economySeats;
 * this.businessSeats = businessSeats;
 * this.firstClassSeats = firstClassSeats;
 * this.bookedEconomy = 0;
 * this.bookedBusiness = 0;
 * this.bookedFirst = 0;
 * this.status = status;
 * }
 * 
 * boolean bookSeat(String seatClass) {
 * switch (seatClass.toLowerCase()) {
 * case "economy":
 * if (bookedEconomy < economySeats) {
 * bookedEconomy++;
 * return true;
 * }
 * break;
 * case "business":
 * if (bookedBusiness < businessSeats) {
 * bookedBusiness++;
 * return true;
 * }
 * break;
 * case "first":
 * if (bookedFirst < firstClassSeats) {
 * bookedFirst++;
 * return true;
 * }
 * break;
 * }
 * return false;
 * }
 * 
 * boolean cancelSeat(String seatClass) {
 * switch (seatClass.toLowerCase()) {
 * case "economy":
 * if (bookedEconomy > 0) {
 * bookedEconomy--;
 * return true;
 * }
 * break;
 * case "business":
 * if (bookedBusiness > 0) {
 * bookedBusiness--;
 * return true;
 * }
 * break;
 * case "first":
 * if (bookedFirst > 0) {
 * bookedFirst--;
 * return true;
 * }
 * break;
 * }
 * return false;
 * }
 * 
 * void showFlight(PrintWriter out) {
 * out.printf("Flight No: %s | Destination: %s | Departure: %s | Status: %s%n",
 * flightNo, destination, departureTime, status);
 * out.printf("Economy: %d/%d | Business: %d/%d | First: %d/%d%n",
 * bookedEconomy, economySeats, bookedBusiness, businessSeats, bookedFirst,
 * firstClassSeats);
 * }
 * }
 * 
 * class Booking {
 * String bookingID;
 * String flightNo;
 * String passengerName;
 * String travelDate;
 * String phone;
 * String seatClass;
 * 
 * Booking(String bookingID, String flightNo, String passengerName, String
 * travelDate, String phone,
 * String seatClass) {
 * this.bookingID = bookingID;
 * this.flightNo = flightNo;
 * this.passengerName = passengerName;
 * this.travelDate = travelDate;
 * this.phone = phone;
 * this.seatClass = seatClass;
 * }
 * 
 * void showBooking(PrintWriter out) {
 * out.
 * printf("Booking ID: %s | Flight No: %s | Name: %s | Date: %s | Phone: %s | Class: %s%n"
 * ,
 * bookingID, flightNo, passengerName, travelDate, phone, seatClass);
 * }
 * }
 * 
 * public class FlightManagementSystem {
 * static Map<String, Flight> flights = new HashMap<>();
 * static Map<String, Booking> bookings = new HashMap<>();
 * 
 * public static void main(String[] args) {
 * try {
 * Scanner scanner = new Scanner(new File("input.txt"));
 * PrintWriter writer = new PrintWriter("output.txt");
 * 
 * while (scanner.hasNextLine()) {
 * String line = scanner.nextLine().trim();
 * if (line.isEmpty())
 * continue;
 * 
 * String[] cmd = line.trim().split("\\s+");
 * String action = cmd[0];
 * 
 * switch (action) {
 * case "ADD_FLIGHT":
 * String flightNo = cmd[1];
 * String destination = cmd[2];
 * String departure = cmd[3];
 * int ecoSeats = Integer.parseInt(cmd[4]);
 * int busSeats = Integer.parseInt(cmd[5]);
 * int firstSeats = Integer.parseInt(cmd[6]);
 * String status = cmd[7];
 * flights.put(flightNo,
 * new Flight(flightNo, destination, departure, ecoSeats, busSeats, firstSeats,
 * status));
 * writer.println("Flight added: " + flightNo);
 * break;
 * 
 * case "BOOK_TICKET":
 * String bookingID = cmd[1];
 * flightNo = cmd[2];
 * String name = cmd[3];
 * String date = cmd[4];
 * String phone = cmd[5];
 * String seatClass = cmd[6].toLowerCase();
 * 
 * Flight flight = flights.get(flightNo);
 * if (flight != null && flight.bookSeat(seatClass)) {
 * Booking booking = new Booking(bookingID, flightNo, name, date, phone,
 * seatClass);
 * bookings.put(bookingID, booking);
 * writer.println("Booking successful: " + bookingID);
 * logBooking(booking);
 * } else {
 * writer.println("Booking failed for flight: " + flightNo + " in class: " +
 * seatClass);
 * }
 * break;
 * 
 * case "CANCEL_TICKET":
 * bookingID = cmd[1];
 * Booking cancelled = bookings.remove(bookingID);
 * if (cancelled != null) {
 * flight = flights.get(cancelled.flightNo);
 * if (flight != null && flight.cancelSeat(cancelled.seatClass)) {
 * writer.println("Booking cancelled: " + bookingID);
 * } else {
 * writer.println("Cancellation failed: " + bookingID);
 * }
 * } else {
 * writer.println("Booking ID not found: " + bookingID);
 * }
 * break;
 * 
 * case "SHOW_FLIGHTS":
 * for (Flight f : flights.values()) {
 * f.showFlight(writer);
 * }
 * break;
 * 
 * case "SHOW_BOOKINGS":
 * for (Booking b : bookings.values()) {
 * b.showBooking(writer);
 * }
 * break;
 * 
 * default:
 * writer.println("Invalid command: " + action);
 * }
 * }
 * 
 * scanner.close();
 * writer.close();
 * 
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * }
 * 
 * static void logBooking(Booking booking) {
 * try (PrintWriter log = new PrintWriter(new FileWriter("booking_log.txt",
 * true))) {
 * log.printf("BookingID: %s | Name: %s | Flight: %s | Class: %s%n",
 * booking.bookingID, booking.passengerName, booking.flightNo,
 * booking.seatClass);
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 * }
 * }
 * 
 * 29 April 2025 9:19pm
 

import java.io.*;
import java.util.*;

class Flight {
    String flightNo;
    String destination;
    String departureTime;
    int economySeats, businessSeats, firstClassSeats;
    int bookedEconomy, bookedBusiness, bookedFirst;
    String status;

    Flight(String flightNo, String destination, String departureTime,
            int economySeats, int businessSeats, int firstClassSeats, String status) {
        this.flightNo = flightNo;
        this.destination = destination;
        this.departureTime = departureTime;
        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
        this.firstClassSeats = firstClassSeats;
        this.bookedEconomy = 0;
        this.bookedBusiness = 0;
        this.bookedFirst = 0;
        this.status = status;
    }

    boolean bookSeat(String seatClass) {
        switch (seatClass.toLowerCase()) {
            case "economy":
                if (bookedEconomy < economySeats) {
                    bookedEconomy++;
                    return true;
                }
                break;
            case "business":
                if (bookedBusiness < businessSeats) {
                    bookedBusiness++;
                    return true;
                }
                break;
            case "first":
                if (bookedFirst < firstClassSeats) {
                    bookedFirst++;
                    return true;
                }
                break;
        }
        return false;
    }

    boolean cancelSeat(String seatClass) {
        switch (seatClass.toLowerCase()) {
            case "economy":
                if (bookedEconomy > 0) {
                    bookedEconomy--;
                    return true;
                }
                break;
            case "business":
                if (bookedBusiness > 0) {
                    bookedBusiness--;
                    return true;
                }
                break;
            case "first":
                if (bookedFirst > 0) {
                    bookedFirst--;
                    return true;
                }
                break;
        }
        return false;
    }

    void showFlight(PrintWriter out) {
        out.printf("Flight No: %s | Destination: %s | Departure: %s | Status: %s%n",
                flightNo, destination, departureTime, status);
        out.printf("Economy: %d/%d | Business: %d/%d | First: %d/%d%n",
                bookedEconomy, economySeats, bookedBusiness, businessSeats, bookedFirst, firstClassSeats);
    }
}

class Booking {
    String bookingID;
    String flightNo;
    String passengerName;
    String travelDate;
    String phone;
    String seatClass;

    Booking(String bookingID, String flightNo, String passengerName, String travelDate, String phone,
            String seatClass) {
        this.bookingID = bookingID;
        this.flightNo = flightNo;
        this.passengerName = passengerName;
        this.travelDate = travelDate;
        this.phone = phone;
        this.seatClass = seatClass;
    }

    void showBooking(PrintWriter out) {
        out.printf("Booking ID: %s | Flight No: %s | Name: %s | Date: %s | Phone: %s | Class: %s%n",
                bookingID, flightNo, passengerName, travelDate, phone, seatClass);
    }
}

public class FlightManagementSystem {
    static Map<String, Flight> flights = new HashMap<>();
    static Map<String, Booking> bookings = new HashMap<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            PrintWriter writer = new PrintWriter("output.txt");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty())
                    continue;

                String[] cmd = line.trim().split("\\s+");
                String action = cmd[0];

                switch (action) {
                    case "LOGIN":
                        String userType = cmd[1].toLowerCase();
                        writer.println("Logged in as: " + userType);
                        break;

                    case "ADD_FLIGHT":
                        if (cmd.length < 8) {
                            writer.println("Invalid ADD_FLIGHT command.");
                            break;
                        }
                        String flightNo = cmd[1];
                        String destination = cmd[2];
                        String departure = cmd[3];
                        int ecoSeats = Integer.parseInt(cmd[4]);
                        int busSeats = Integer.parseInt(cmd[5]);
                        int firstSeats = Integer.parseInt(cmd[6]);
                        String status = cmd[7];
                        flights.put(flightNo,
                                new Flight(flightNo, destination, departure, ecoSeats, busSeats, firstSeats, status));
                        writer.println("Flight added: " + flightNo);
                        break;

                    case "BOOK_TICKET":
                        if (cmd.length < 7) {
                            writer.println("Invalid BOOK_TICKET command.");
                            break;
                        }
                        String bookingID = cmd[1];
                        flightNo = cmd[2];
                        String name = cmd[3];
                        String date = cmd[4];
                        String phone = cmd[5];
                        String seatClass = cmd[6].toLowerCase();

                        Flight flight = flights.get(flightNo);
                        if (flight != null && flight.bookSeat(seatClass)) {
                            Booking booking = new Booking(bookingID, flightNo, name, date, phone, seatClass);
                            bookings.put(bookingID, booking);
                            writer.println("Booking successful: " + bookingID);
                            logBooking(booking);
                        } else {
                            writer.println("Booking failed for flight: " + flightNo + " in class: " + seatClass);
                        }
                        break;

                    case "CANCEL_TICKET":
                        bookingID = cmd[1];
                        Booking cancelled = bookings.remove(bookingID);
                        if (cancelled != null) {
                            flight = flights.get(cancelled.flightNo);
                            if (flight != null && flight.cancelSeat(cancelled.seatClass)) {
                                writer.println("Booking cancelled: " + bookingID);
                            } else {
                                writer.println("Cancellation failed: " + bookingID);
                            }
                        } else {
                            writer.println("Booking ID not found: " + bookingID);
                        }
                        break;

                    case "SHOW_FLIGHTS":
                        for (Flight f : flights.values()) {
                            f.showFlight(writer);
                        }
                        break;

                    case "SHOW_BOOKINGS":
                        for (Booking b : bookings.values()) {
                            b.showBooking(writer);
                        }
                        break;

                    default:
                        writer.println("Invalid command: " + action);
                }
            }

            scanner.close();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void logBooking(Booking booking) {
        try (PrintWriter log = new PrintWriter(new FileWriter("booking_log.txt", true))) {
            log.printf("BookingID: %s | Name: %s | Flight: %s | Class: %s%n",
                    booking.bookingID, booking.passengerName, booking.flightNo, booking.seatClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 file system only till 3rd May 2025 3:30pm   
 






import java.io.*;
import java.util.*;

class Flight {
    String flightId, source, destination, departureTime;
    int totalSeats;
    String flightStatus;

    public Flight(String flightId, String source, String destination, String departureTime, int totalSeats,
            String status) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.flightStatus = status;
    }

    public String toString() {
        return flightId + "," + source + "," + destination + "," + departureTime + "," + totalSeats + ","
                + flightStatus;
    }
}

class Booking {
    String bookingId, flightId, passengerName, seatClass, foodOption;

    public Booking(String bookingId, String flightId, String passengerName, String seatClass, String foodOption) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.seatClass = seatClass;
        this.foodOption = foodOption;
    }

    public String toString() {
        return bookingId + "," + flightId + "," + passengerName + "," + seatClass + "," + foodOption;
    }
}

public class FlightManagementSystem {
    static List<Flight> flights = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String OUTPUT_FILE = "output.txt";
    static final String LOG_FILE = "booking_log.txt";

    public static void main(String[] args) {
        loadInitialData();
        handleUserLogin();
    }

    static void loadInitialData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String flightId = parts[0];
                    if (getFlightById(flightId) == null) {
                        flights.add(new Flight(flightId, parts[1], parts[2], parts[3], Integer.parseInt(parts[4]),
                                parts[5]));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading input.txt. No flights loaded.");
        }
    }

    static void handleUserLogin() {
        while (true) {
            System.out.println("\n--- Flight Management System ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Agent Login");
            System.out.println("3. Passenger Login");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    agentMenu();
                    break;
                case 3:
                    passengerMenu();
                    break;
                case 4:
                    writeOutput("System exited by user.");
                    return;
                default:
                    writeOutput("Invalid choice.");
            }
        }
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Flight");
            System.out.println("2. Remove Flight");
            System.out.println("3. Update Flight Status");
            System.out.println("4. View All Bookings");
            System.out.println("5. Export Bookings to CSV");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    removeFlight();
                    break;
                case 3:
                    updateFlightStatus();
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    exportBookingsToCSV();
                    break;
                case 6:
                    return;
                default:
                    writeOutput("Invalid admin choice.");
            }
        }
    }

    static void agentMenu() {
        while (true) {
            System.out.println("\n--- Agent Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Flights");
            System.out.println("4. View All Bookings");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelBooking();
                    break;
                case 3:
                    viewFlights();
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    return;
                default:
                    writeOutput("Invalid agent choice.");
            }
        }
    }

    static void passengerMenu() {
        while (true) {
            System.out.println("\n--- Passenger Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Flights");
            System.out.println("3. View My Bookings");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    viewFlights();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    return;
                default:
                    writeOutput("Invalid passenger choice.");
            }
        }
    }

    static void addFlight() {
        System.out.print("Flight ID: ");
        String id = sc.nextLine();
        if (getFlightById(id) != null) {
            writeOutput("Flight ID already exists. Cannot add duplicate.");
            return;
        }
        System.out.print("Source: ");
        String src = sc.nextLine();
        System.out.print("Destination: ");
        String dst = sc.nextLine();
        System.out.print("Departure Time: ");
        String time = sc.nextLine();
        System.out.print("Total Seats: ");
        int seats = sc.nextInt();
        sc.nextLine();
        System.out.print("Flight Status (On Time / Delayed / Cancelled): ");
        String status = sc.nextLine();
        flights.add(new Flight(id, src, dst, time, seats, status));
        writeOutput("Flight added: " + id);
    }

    static void removeFlight() {
        System.out.print("Enter Flight ID to remove: ");
        String flightId = sc.nextLine();
        boolean removed = flights.removeIf(f -> f.flightId.equalsIgnoreCase(flightId));
        if (removed) {
            writeOutput("Flight " + flightId + " removed.");
        } else {
            writeOutput("Flight ID not found.");
        }
    }

    static void updateFlightStatus() {
        System.out.print("Enter Flight ID to update status: ");
        String flightId = sc.nextLine();
        Flight flight = getFlightById(flightId);
        if (flight != null) {
            System.out.print("Enter new status (On Time / Delayed / Cancelled): ");
            String status = sc.nextLine();
            flight.flightStatus = status;
            writeOutput("Flight " + flightId + " status updated to: " + status);
        } else {
            writeOutput("Flight ID not found.");
        }
    }

    static void viewFlights() {
        writeOutput("--- Available Flights ---");
        for (Flight f : flights) {
            writeOutput(f.toString());
        }
    }

    static void bookTicket() {
        System.out.print("Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Flight ID: ");
        String flightId = sc.nextLine();
        Flight flight = getFlightById(flightId);
        if (flight == null) {
            writeOutput("Flight not found.");
            return;
        }
        if (flight.totalSeats <= 0) {
            writeOutput("No available seats on this flight.");
            return;
        }
        System.out.print("Seat Class (Economy/Business/First): ");
        String seatClass = sc.nextLine();
        System.out.print("Food Option (Veg/Non-Veg): ");
        String food = sc.nextLine();
        simulatePayment();
        String bookingId = "B" + (bookings.size() + 1);
        Booking booking = new Booking(bookingId, flightId, name, seatClass, food);
        bookings.add(booking);
        flight.totalSeats -= 1;
        logBooking(booking);
        writeOutput("Booking successful: " + bookingId);
    }

    static void cancelBooking() {
        System.out.print("Enter Booking ID to cancel: ");
        String bid = sc.nextLine();
        boolean removed = bookings.removeIf(b -> b.bookingId.equalsIgnoreCase(bid));
        if (removed) {
            writeOutput("Booking " + bid + " cancelled.");
        } else {
            writeOutput("Booking ID not found.");
        }
    }

    static void viewBookings() {
        System.out.print("Enter your name to view bookings: ");
        String name = sc.nextLine();
        writeOutput("--- Your Bookings ---");
        for (Booking b : bookings) {
            if (b.passengerName.equalsIgnoreCase(name)) {
                writeOutput(b.toString());
            }
        }
    }

    static void exportBookingsToCSV() {
        try (PrintWriter writer = new PrintWriter("bookings.csv")) {
            writer.println("Booking ID,Flight ID,Passenger Name,Seat Class,Food Option");
            for (Booking b : bookings) {
                writer.println(b.toString());
            }
            writeOutput("Bookings exported to bookings.csv.");
        } catch (IOException e) {
            writeOutput("Error exporting bookings to CSV.");
        }
    }

    static void simulatePayment() {
        System.out.println("Processing payment...");
        System.out.println("Payment successful!");
    }

    static void logBooking(Booking booking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(booking.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error logging booking.");
        }
    }

    static Flight getFlightById(String flightId) {
        for (Flight f : flights) {
            if (f.flightId.equalsIgnoreCase(flightId)) {
                return f;
            }
        }
        return null;
    }

    static void writeOutput(String message) {
        System.out.println(message);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to output.");
        }
    }
}    
    
22 May 11pm

*/

// [All other imports stay the same]
import java.io.*;
import java.util.*;
import email.EmailService;
import qr.QRGenerator;

class Flight {
    String flightId, source, destination, departureTime;
    int totalSeats;
    String flightStatus;
    int economyPrice, businessPrice, firstClassPrice;

    public Flight(String flightId, String source, String destination, String departureTime, int totalSeats,
            String flightStatus, int economyPrice, int businessPrice, int firstClassPrice) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.flightStatus = flightStatus;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.firstClassPrice = firstClassPrice;
    }

    public String toString() {
        return flightId + "," + source + "," + destination + "," + departureTime + "," + totalSeats + ","
                + flightStatus + "," + economyPrice + "," + businessPrice + "," + firstClassPrice;
    }
}

class Booking {
    String bookingId, flightId, passengerName, seatClass, foodOption;

    public Booking(String bookingId, String flightId, String passengerName, String seatClass, String foodOption) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.seatClass = seatClass;
        this.foodOption = foodOption;
    }

    public String toString() {
        return bookingId + "," + flightId + "," + passengerName + "," + seatClass + "," + foodOption;
    }
}

public class FlightManagementSystem {
    static List<Flight> flights = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String OUTPUT_FILE = "output.txt";
    static final String LOG_FILE = "booking_log.txt";

    public static void main(String[] args) {
        loadInitialData();
        handleUserLogin();
    }

    static void loadInitialData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 9) {
                    String flightId = parts[0];
                    if (getFlightById(flightId) == null) {
                        flights.add(new Flight(
                                parts[0], parts[1], parts[2], parts[3],
                                Integer.parseInt(parts[4]), parts[5],
                                Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8])));
                    }
                }
            }
        } catch (IOException e) {
            writeOutput("Error loading input.txt. No flights loaded.");
        }
    }

    static void handleUserLogin() {
        while (true) {
            System.out.println("\n--- Flight Management System ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Agent Login");
            System.out.println("3. Passenger Login");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = getIntInput();
            switch (choice) {
                case 1 -> adminMenu();
                case 2 -> agentMenu();
                case 3 -> passengerMenu();
                case 4 -> {
                    writeOutput("System exited by user.");
                    return;
                }
                default -> writeOutput("Invalid choice.");
            }
        }
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Flight");
            System.out.println("2. Remove Flight");
            System.out.println("3. Update Flight Status");
            System.out.println("4. View All Bookings");
            System.out.println("5. Export Bookings to CSV");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");
            int choice = getIntInput();
            switch (choice) {
                case 1 -> addFlight();
                case 2 -> removeFlight();
                case 3 -> updateFlightStatus();
                case 4 -> viewAllBookings();
                case 5 -> exportBookingsToCSV();
                case 6 -> {
                    return;
                }
                default -> writeOutput("Invalid admin choice.");
            }
        }
    }

    static void agentMenu() {
        while (true) {
            System.out.println("\n--- Agent Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Flights");
            System.out.println("4. View All Bookings");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            int choice = getIntInput();
            switch (choice) {
                case 1 -> bookTicket();
                case 2 -> cancelBooking();
                case 3 -> viewFlights();
                case 4 -> viewAllBookings();
                case 5 -> {
                    return;
                }
                default -> writeOutput("Invalid agent choice.");
            }
        }
    }

    static void passengerMenu() {
        while (true) {
            System.out.println("\n--- Passenger Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Flights");
            System.out.println("3. View My Bookings");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = getIntInput();
            switch (choice) {
                case 1 -> bookTicket();
                case 2 -> viewFlights();
                case 3 -> viewPassengerBookings();
                case 4 -> {
                    return;
                }
                default -> writeOutput("Invalid passenger choice.");
            }
        }
    }

    static void addFlight() {
        System.out.print("Flight ID: ");
        String id = sc.nextLine();
        if (getFlightById(id) != null) {
            writeOutput("Flight ID already exists.");
            return;
        }
        System.out.print("Source: ");
        String src = sc.nextLine();
        System.out.print("Destination: ");
        String dst = sc.nextLine();
        System.out.print("Departure Time: ");
        String time = sc.nextLine();
        System.out.print("Total Seats: ");
        int seats = getIntInput();
        System.out.print("Flight Status (On Time / Delayed / Cancelled): ");
        String status = sc.nextLine();
        System.out.print("Economy Price: ");
        int eco = getIntInput();
        System.out.print("Business Price: ");
        int bus = getIntInput();
        System.out.print("First Class Price: ");
        int first = getIntInput();

        flights.add(new Flight(id, src, dst, time, seats, status, eco, bus, first));
        writeOutput("Flight added: " + id);
    }

    static void removeFlight() {
        System.out.print("Enter Flight ID to remove: ");
        String flightId = sc.nextLine();
        boolean removed = flights.removeIf(f -> f.flightId.equalsIgnoreCase(flightId));
        writeOutput(removed ? "Flight " + flightId + " removed." : "Flight ID not found.");
    }

    static void updateFlightStatus() {
        System.out.print("Enter Flight ID to update status: ");
        String flightId = sc.nextLine();
        Flight flight = getFlightById(flightId);
        if (flight != null) {
            System.out.print("Enter new status (On Time / Delayed / Cancelled): ");
            flight.flightStatus = sc.nextLine();
            writeOutput("Flight status updated.");
        } else {
            writeOutput("Flight ID not found.");
        }
    }

    static void viewFlights() {
        writeOutput("--- Available Flights ---");
        for (Flight f : flights)
            writeOutput(f.toString());
    }

    static void bookTicket() {
        try {
            System.out.print("Passenger Name: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                writeOutput("Passenger name cannot be empty.");
                return;
            }

            System.out.print("Passenger Email: ");
            String email = sc.nextLine().trim();
            if (email.isEmpty()) {
                writeOutput("Passenger email cannot be empty.");
                return;
            }

            System.out.print("Flight ID: ");
            String flightId = sc.nextLine().trim();
            if (flightId.isEmpty()) {
                writeOutput("Flight ID cannot be empty.");
                return;
            }

            Flight flight = getFlightById(flightId);

            if (flight == null || flight.flightStatus == null || flight.flightStatus.equalsIgnoreCase("Cancelled")) {
                writeOutput("Invalid or cancelled flight.");
                return;
            }

            if (flight.totalSeats <= 0) {
                writeOutput("No seats available.");
                return;
            }

            System.out.print("Seat Class (Economy/Business/First): ");
            String seatClass = sc.nextLine().trim();
            if (!(seatClass.equalsIgnoreCase("Economy") || seatClass.equalsIgnoreCase("Business")
                    || seatClass.equalsIgnoreCase("First"))) {
                writeOutput("Invalid seat class.");
                return;
            }

            System.out.print("Food Option (Veg/Non-Veg): ");
            String food = sc.nextLine().trim();
            if (!(food.equalsIgnoreCase("Veg") || food.equalsIgnoreCase("Non-Veg"))) {
                writeOutput("Invalid food option.");
                return;
            }

            simulatePayment();

            String bookingId = "B" + (bookings.size() + 1);
            Booking booking = new Booking(bookingId, flightId, name, seatClass, food);
            bookings.add(booking);

            flight.totalSeats--; // Reduce available seats
            logBooking(booking);
            writeOutput("Booking successful: " + bookingId);

            // Ensure qr_codes directory exists
            File qrDir = new File("qr_codes");
            if (!qrDir.exists()) {
                if (!qrDir.mkdirs()) {
                    writeOutput("❌ Failed to create directory for QR codes.");
                    return;
                }
            }

            // Generate QR code text
            String qrText = "Booking ID: " + bookingId + "\n" +
                    "Name: " + name + "\n" +
                    "Flight: " + flight.flightId + " (" + flight.source + " to " + flight.destination + ")\n" +
                    "Departure: " + flight.departureTime + "\n" +
                    "Seat Class: " + seatClass + "\n" +
                    "Food: " + food;

            String qrPath = "qr_codes/" + bookingId + ".png";

            try {
                QRGenerator.generateQRCodeImage(qrText, 300, 300, qrPath);
            } catch (Exception e) {
                e.printStackTrace();
                writeOutput("❌ Failed to generate QR code.");
            }

            try {
                EmailService.sendBookingConfirmation(
                        email,
                        name,
                        bookingId,
                        flight.flightId + " (" + flight.source + "-" + flight.destination + ", " + flight.departureTime
                                + ")",
                        seatClass,
                        food,
                        qrPath);
            } catch (Exception e) {
                e.printStackTrace();
                writeOutput("❌ Failed to send booking confirmation email.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            writeOutput("An unexpected error occurred during booking.");
        }
    }

    static void cancelBooking() {
        System.out.print("Enter Booking ID to cancel: ");
        String bid = sc.nextLine();
        Booking found = null;
        for (Booking b : bookings) {
            if (b.bookingId.equalsIgnoreCase(bid)) {
                found = b;
                break;
            }
        }
        if (found != null) {
            bookings.remove(found);
            Flight f = getFlightById(found.flightId);
            if (f != null)
                f.totalSeats++;
            writeOutput("Booking cancelled: " + bid);
        } else {
            writeOutput("Booking ID not found.");
        }
    }

    static void viewAllBookings() {
        writeOutput("--- All Bookings ---");
        for (Booking b : bookings)
            writeOutput(b.toString());
    }

    static void viewPassengerBookings() {
        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();
        writeOutput("--- Bookings for " + name + " ---");
        for (Booking b : bookings) {
            if (b.passengerName.equalsIgnoreCase(name)) {
                writeOutput(b.toString());
            }
        }
    }

    static void exportBookingsToCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("bookings.csv"))) {
            pw.println("Booking ID,Flight ID,Passenger Name,Seat Class,Food Option");
            for (Booking b : bookings) {
                pw.println(b.bookingId + "," + b.flightId + "," + b.passengerName + "," + b.seatClass + ","
                        + b.foodOption);
            }
            writeOutput("Bookings exported to bookings.csv");
        } catch (IOException e) {
            writeOutput("Error exporting bookings to CSV.");
        }
    }

    static void writeOutput(String msg) {
        System.out.println(msg);
        try (PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_FILE, true))) {
            out.println(msg);
        } catch (IOException e) {
            System.out.println("Failed to write to output.txt");
        }
    }

    static Flight getFlightById(String id) {
        for (Flight f : flights) {
            if (f.flightId.equalsIgnoreCase(id))
                return f;
        }
        return null;
    }

    static int getIntInput() {
        while (true) {
            try {
                String input = sc.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    static void logBooking(Booking b) {
        try (PrintWriter log = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            log.println(b.bookingId + "," + b.passengerName);
        } catch (IOException e) {
            System.out.println("Failed to log booking.");
        }
    }

    static void simulatePayment() {
        System.out.println("Payment Options:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Net Banking");
        System.out.print("Choose payment method: ");
        int choice = getIntInput();
        switch (choice) {
            case 1 -> System.out.println("Payment done via Credit Card.");
            case 2 -> System.out.println("Payment done via Debit Card.");
            case 3 -> System.out.println("Payment done via Net Banking.");
            default -> System.out.println("Invalid payment method selected, payment failed.");
        }
    }
}
