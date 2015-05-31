package enviartest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import enviar.EmailAuthenticator;;


public class EmailAuthenticatorTest
{
    private String username;
    private String password;
    private EmailAuthenticator emailAuth;
    
    @Before
    public void setUp()
    {
        this.username = "pavel";
        this.password = "jenkins";
        this.emailAuth = new EmailAuthenticator(this.username, this.password);
    }
    
    @Test
    public void emailAuthenticatorEquals()
    {
        EmailAuthenticator emailAuth_B = new EmailAuthenticator(this.username, this.password);
        assertTrue(emailAuth_B.equals(this.emailAuth));
    }

}
