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

/**
 * Establece las propriedades de conexión con el servidor de correo
 * electronico y envia el correo electronico a su destinatorio
 * 
 * @author Pavel
 * @author Cristo
 *
 */

public class EmailSender {

    private EmailAuthenticator auth;
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    /**
     * Constructor publico
     * 
     * @param username nombre de usuario de correo electronico
     * @param password contraseña del usuario de correo electronico
     */
    public EmailSender(String username, String password) {
        auth = new EmailAuthenticator(username, password);
    }

    /**
     * Envia el correo electronico a su destinatario
     * 
     * @param  destino dirección del destinatario, ej: "pavel@gmail.com"
     * @param  asunto  asunto del correo electronico
     * @param  mensaje el contenido del correo electronico
     * @return boolean true si se ha enviado correcto, false si hubo fallos
     */
    public boolean enviar(String destino, String asunto, String mensaje) {
        try {
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.mail.yahoo.es");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(props, auth);
            session.setDebug(true);

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
