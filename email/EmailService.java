package email;

import javax.mail.*;
import javax.mail.internet.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Properties;

public class EmailService {

    public static void sendBookingConfirmation(
            String toEmail,
            String userName,
            String bookingId,
            String flightId,
            String seatClass,
            String foodOption) throws MessagingException, IOException {

        Properties props = EmailConfig.getEmailProperties();

        final String username = EmailConfig.SENDER_EMAIL;
        final String password = EmailConfig.SENDER_PASSWORD;

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject("Your Flight Booking Confirmation");

        // Load and customize HTML template
        String templatePath = "email/booking_confirmation.html";

        String htmlBody = new String(Files.readAllBytes(Paths.get(templatePath)));
        htmlBody = htmlBody.replace("{{name}}", userName)
                .replace("{{bookingId}}", bookingId)
                .replace("{{flightId}}", flightId)
                .replace("{{seatClass}}", seatClass)
                .replace("{{foodOption}}", foodOption);

        message.setContent(htmlBody, "text/html");

        Transport.send(message);
    }
}
