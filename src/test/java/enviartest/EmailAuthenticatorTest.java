package enviartest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import enviar.EmailAuthenticator;

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
    
    @Test
    public void emailAuthenticatorEquals_B()
    {
        EmailAuthenticator emailAuth_B = new EmailAuthenticator(this.username, this.password);
        assertTrue(this.emailAuth.equals(this.emailAuth));
    }

    @Test
    public void hashCodeTest()
    {
        assertEquals(-1439404585, this.emailAuth.hashCode());
    }
}
