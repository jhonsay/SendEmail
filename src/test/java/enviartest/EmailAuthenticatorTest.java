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
        assertTrue(this.emailAuth.equals(this.emailAuth));
    }
    
    @Test
    public void emailAuthenticatorEquals_C()
    {
        assertFalse(this.emailAuth.equals(null));
    }
    
    @Test
    public void emailAuthenticatorEquals_D()
    {
        assertFalse(this.emailAuth.equals(new String()));
    }
    
    @Test
    public void emailAuthenticatorEquals_E()
    {
        EmailAuthenticator emailAuth_B = new EmailAuthenticator(this.username, null);
        assertFalse(emailAuth_B.equals(this.emailAuth));
    }
    
    @Test
    public void emailAuthenticatorEquals_F()
    {
        EmailAuthenticator emailAuth_B = new EmailAuthenticator(null, this.password);
        assertFalse(emailAuth_B.equals(this.emailAuth));
    }

    @Test
    public void hashCodeTest()
    {
        assertEquals(-1439404585, this.emailAuth.hashCode());
    }
}
