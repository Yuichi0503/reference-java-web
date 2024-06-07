
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Transport;

public class EmailService {
	//TODO

    private static final String SMTP_HOST_NAME = "smtp.example.com";
    private static final String SMTP_AUTH_USER = "username@example.com";
    private static final String SMTP_AUTH_PWD  = "password";

    public static void sendEmail(String to, String body) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST_NAME);
        properties.put("mail.smtp.auth", "true");

        SMTPAuthenticator auth = new SMTPAuthenticator();
        Session session = jakarta.mail.Session.getInstance(properties, auth);

        try {
            Message msg = new jakarta.mail.internet.MimeMessage(session);
            msg.setFrom(new jakarta.mail.internet.InternetAddress(SMTP_AUTH_USER));
            msg.setRecipient(Message.RecipientType.TO, new jakarta.mail.internet.InternetAddress(to));
            msg.setSubject("Verification Email");
            msg.setText(body);

            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static class SMTPAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
        }
    }
}
