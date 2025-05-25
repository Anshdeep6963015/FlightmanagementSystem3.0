package email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class EmailService {

    public static void sendBookingConfirmation(
            String toEmail,
            String userName,
            String bookingId,
            String flightId,
            String seatClass,
            String foodOption,
            String qrCodeFilePath) throws MessagingException, IOException {

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

        String templatePath = "email/booking_confirmation.html";
        String htmlBody = new String(Files.readAllBytes(Paths.get(templatePath)));
        htmlBody = htmlBody.replace("{{name}}", userName)
                .replace("{{bookingId}}", bookingId)
                .replace("{{flightId}}", flightId)
                .replace("{{seatClass}}", seatClass)
                .replace("{{foodOption}}", foodOption);

        // Create the HTML part
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(htmlBody, "text/html");

        // Create the image part
        MimeBodyPart imagePart = new MimeBodyPart();
        DataSource fds = new FileDataSource(qrCodeFilePath);
        imagePart.setDataHandler(new DataHandler(fds));
        imagePart.setHeader("Content-ID", "<qrCodeImage>");
        imagePart.setDisposition(MimeBodyPart.INLINE);

        // Combine parts into a multipart/related container
        Multipart multipart = new MimeMultipart("related");
        multipart.addBodyPart(htmlPart);
        multipart.addBodyPart(imagePart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
