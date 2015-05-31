package enviartest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import enviar.EmailSender;

public class EmailSenderTest
{
    private String username;
    private String password;
    private EmailSender emailSender;
    
    @Before
    public void setUp()
    {
        this.username = "pavel";
        this.password = "jenkins";
        this.emailSender = new EmailSender(username, password);
    }
  
    @Test
    public void firstTest()
    {
        String destino = "cristo.mc@gmail.com";
        String asunto = "Que tal";
        String mensaje = "Que pasa cristo? Como va la vida?";
        boolean esEnviado = this.emailSender.enviar(destino, asunto, mensaje);
        assertTrue(esEnviado);
    }
}
