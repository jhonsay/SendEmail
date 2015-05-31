package enviaremail;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import enviaremail.EnviarEmailForm;

public class EnviarEmailFormTest
{
    EnviarEmailForm form;
    
    @Before
    public void setUp()
    {
        form = new EnviarEmailForm();
    }
    
    @Test
    public void emailFormOpened()
    {
        assertNotNull(this.form);
    }
    
    @Test
    public void emailFormVaciar()
    {
        this.form.direccionTextField.setText("Algo");
        this.form.asuntoTextField.setText("Algo");
        this.form.mensajeTextArea.setText("Algo");
        this.form.vaciar();
        assertEquals("", this.form.direccionTextField.getText());
        assertEquals("", this.form.asuntoTextField.getText());
        assertEquals("", this.form.mensajeTextArea.getText());
    }
    
}
