package enviar;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {

    private EmailAuthenticator auth;
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public EmailSender(String username, String password) {
        auth = new EmailAuthenticator(username, password);
    }

    public boolean enviar(String destino, String asunto, String mensaje) {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.mail.yahoo.es");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, auth);
        session.setDebug(true);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(auth.getPasswordAuthentication().getUserName()));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            msg.setSubject(asunto);
            msg.setSentDate(new Date());

            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setText(mensaje);

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp);

            msg.setContent(mp);

            Transport.send(msg);

        } catch (Exception e1) {
            LOGGER.log(Level.WARNING, e1.getMessage(), e1);
            return false;
        }
        return true;
    }

}
