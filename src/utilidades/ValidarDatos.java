package utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos {

    public static boolean validarNombre(String nombre) {
        String patron
                = "[a-zA-Z]{1,20}";
        return validar(nombre, patron);
    }

    public static boolean validarNif(String nif) {
        String patron = "([0-9]{8})([a-zA-Z])";
        return validar(nif, patron);
    }
    
    public static boolean validarTelefono(String telefono) {
        String patron = "([0-9]{9})";
        return validar(telefono, patron);
    }

    public static boolean validarUser(String user) {
        String patron = "[a-zA-Z]{4,7}";
        return validar(user, patron);
    }

    public static boolean validarPassword(String password) {
        String patron = "[a-zA-Z0-9]{6,8}";
        return validar(password, patron);
    }

    public static boolean validar(String cadena, String patron) {
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(cadena);
        return m.matches();
    }
}
