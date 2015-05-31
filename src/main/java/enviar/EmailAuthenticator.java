package enviar;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 
 * @author Pavel
 * @author Cristo
 * 
 * Autentica el usuario contra el servidor de correo electronico
 *
 */

public class EmailAuthenticator extends Authenticator {

    /**
     * Nombre de usuario
     */
    private String username;
    
    /**
     * Contraseña del usuario
     */
    private String password;

    /**
     * Constructor publico, asigna los parametros a los atributos de clase
     * @param username Nombre de usuario
     * @param password Contraseña del usuario
     */
    public EmailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Crea un objeto con las credenciales del usuario para la autenticación
     * 
     * @return PasswordAuthentication
     */
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
     }

    /**
     * Mejora de codigo, calculo el hash del objeto
     * 
     * @return int valor del hash calculado
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result
                + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    /**
     * Operador de igualdad para los objetos
     * 
     * @param obj       objecto de la misma clase EmailAuthenticator
     * @return boolean  true si son iguales, false si son distintos
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmailAuthenticator other = (EmailAuthenticator) obj;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

}
