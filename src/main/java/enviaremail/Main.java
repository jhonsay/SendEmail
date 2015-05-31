package enviaremail;
/**
 * Clase principal para enviar emails.
 * 
 * @author      Pavel
 * @author      Cristo
 * @version     %I%, %G%
 * @since       1.0
 */
public class Main {

    private Main(){
        
    }
    
    /**
    * Funcion main inicial
    * @author      Pavel
    * @author      Cristo
    * @version     %I%, %G%
    * @param       argumentos por defecto
    */
    public static void main(String[] args) {
        EnviarEmailForm f = new EnviarEmailForm();
        f.setVisible(true);
    }
}
