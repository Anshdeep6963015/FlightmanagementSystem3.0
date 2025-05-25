# ✈️ Flight Management System 3.0 – Java Console Application  
_By Anshdeep_

---

## 📖 Overview  
Flight Management System 3.0 is a console-based Java application simulating a complete airline ticketing and booking platform. This version brings significant upgrades over 2.0 with enhanced features like:

- 🔐 Role-based access (Admin, Agent, Passenger)  
- 📩 HTML-based email booking confirmations  
- 📷 QR code ticket generation  
- 🍱 Food preference selection  
- 💺 Seat class management  
- 💳 Simulated payment flow  
- 📂 File-based storage & backup  
- ✅ Polished console UI for real-world use simulation  

---

## 🛠️ Features (Version 3.0)

### ✅ Implemented in 3.0  
- 🎫 Booking and Cancellation System  
- 🔐 Role-Based Access: Admin, Agent, Passenger  
- 🛫 Flight Info: Flight ID, Route, Date, Time  
- 💺 Seat Classes: Economy, Business, First  
- 🍱 Food Options: Veg, Non-Veg  
- 💳 Simulated Payment Confirmation  
- 📬 Email Confirmation (HTML)  
- 📷 QR Code Ticket Generation (PNG)  
- 📁 File-based Input/Output and Logs  
- 📦 CSV Export of Bookings  
- 📑 Clean and modular Java structure  

### 🧭 Planned Enhancements

| Step | Feature            | Status   | Description                         |
|-------|--------------------|----------|-----------------------------------|
| 1️⃣    | Admin Analytics    | Pending  | View total revenue, passenger stats|
| 2️⃣    | GUI Interface      | Planned  | Dialog/JavaFX-based UI             |
| 3️⃣    | Password Hashing   | Pending  | Secure login with SHA-256          |
| 4️⃣    | OTP Login          | Pending  | Secure one-time password login     |
| 5️⃣    | Booking History    | Pending  | Per-user booking log               |
| 6️⃣    | Flight Filters     | Pending  | Search by route/date/seat class    |
| 7️⃣    | Web/Mobile Version | Planned  | Spring Boot backend + React frontend |

---

## 🧾 Booking Confirmation Sample

### Email Confirmation Screenshot

Here is a screenshot of the confirmation email received after booking:

![Confirmation Email](images/Screenshot%202025-05-25%20135011.png)



✅ Booking ID, Flight ID  
🛫 Flight details (e.g., FL102 (IND–DEL, 6:00PM))  
💺 Seat class & 🍱 food option  
📬 HTML confirmation + 📷 QR Ticket  

---

## 🛠 How It Works  
- 📥 Takes user input via Java Scanner  
- 📤 Outputs confirmation and status in output.txt  
- 📦 Saves data in structured files (booking_log.txt, bookings.csv)  
- 📨 Sends confirmation email with ticket details (HTML format)  
- 📷 Generates QR code for each booking using ZXing  
- 💳 Simulates payment without real transactions  

---

## 🖥 Technologies Used  
- Java (Core + File I/O)  
- JavaMail API  
- ZXing QR Code Library  
- Simple HTML/CSS for Email Format  
- Git for version control  

---

## 📁 Project Structure

FlightManagementSystem3.0/
├── Booking.class
├── bookings.csv
├── booking_log.txt
├── Flight.class
├── FlightManagementSystem.class
├── FlightManagementSystem.java
├── input.txt
├── output.txt
├── Utils.java
├── admin/
│ └── AdminAnalytics.java
├── auth/
│ └── AuthUtil.java
├── booking/
│ ├── Booking.class
│ ├── Booking.java
│ ├── Flight.class
│ ├── FoodOption.java
│ └── SeatClass.java
├── email/
│ ├── booking_confirmation.html
│ ├── EmailConfig.class
│ ├── EmailConfig.java
│ ├── EmailService.class
│ ├── EmailService.java
│ └── output.txt
├── lib/
│ ├── core-3.5.1.jar
│ ├── javase-3.5.1.jar
│ ├── javax.activation-1.2.0.jar
│ └── javax.mail-1.6.2.jar
├── qr/
│ ├── QRGenerator.class
│ └── QRGenerator.java
├── qr_codes/
└── search/
├── SearchUtil.java
└── users.txt








##👨‍✈️ About the Developer Anshdeep CSE Student at Chitkara University

📧 Email: anshdeeep24072004@gmail.com 
🎓 University Email: anshdeep1779.be23@chitkara.edu.in
