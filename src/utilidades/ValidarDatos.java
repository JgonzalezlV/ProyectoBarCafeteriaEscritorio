package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos {

    /*
	 * private boolean validarDieta(String dieta) { String patron =
	 * "(?i)(normal|blanda|liquida|sin sal|sin gluten|sin lactosa|otra)"; return
	 * validar(dieta, patron); }
	 * 
	 * private boolean validarHabitacionCama(String habitacionCama) { //(000-00)
	 * //String patron = "[0-9]{3}-[01|02]"; String patron = "[0-9]{3}-[0-9]{2}";
	 * return validar(habitacionCama, patron); }
	 * 
	 * private boolean validarApellidos(String apellidos) { //String patron =
	 * "[a-zA-Z] {1,40}";//Ojo Cuidado con espacios String patron =
	 * "[a-zA-Z]{1,40}"; return validar(apellidos, patron); }
     */
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
        // String patron = "[0-9]{6,8}";
        String patron = "[a-zA-Z0-9]{6,8}";
        return validar(password, patron);
    }

    public static boolean validar(String cadena, String patron) {
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(cadena);

        // cadena.matches(patron)
        if (m.matches()) {
            return true;
        }

        return false;
    }

    public static boolean validarCodProducto(String codigo) {
        String patron = "[a-zA-Z0-9]{4,12}";
        return validar(codigo, patron);
    }

    public static boolean validarFamiliaProducto(String codigo) {
        String patron = "(?i)(EBOOK|ORDENA|MP3|TV|NETBOK|CAMARA|MEMFLA|VIDEOC|IMPRES|MULTIF)";
        return validar(codigo, patron);
    }

    /*
	 * public static boolean comprobarTituloMeta(String valor) { String patron =
	 * "[a-zA-Z]{5,56}"; return validar(valor, patron);
	 * 
	 * 
	 * }
	 * 
	 * public static boolean comprobarDescripcionMeta(String valor) { String patron
	 * = "[a-zA-Z]{5,128}"; return validar(valor, patron);
	 * 
	 * return (valor.length()>=5 && valor.length()<=128); }
	 * 
	 * public static boolean comprobarPrioridadMeta(String valor) { String patron
	 * ="(?i)(Alta|Baja|Media)"; return validar(valor, patron); }
	 * 
	 * public static void comprobarFechaLimiteMeta(String valor) throws
	 * ParseException { Date fecha=convertirAFecha(valor);
	 * 
	 * 
	 * }
	 * 
	 * public static boolean comprobarCategoriaMeta(String valor) { String patron
	 * ="(?i)(Salud|Finanzas|Espiritual|Profesional|Material)"; return
	 * validar(valor, patron); }
	 * 
	 * private static java.sql.Date convertirAFecha( String strFecha) throws
	 * ParseException { SimpleDateFormat formatoDelTexto = new
	 * SimpleDateFormat("yyyy-MM-dd");
	 * 
	 * Date fecha = null; try {
	 * 
	 * fecha = formatoDelTexto.parse(strFecha);
	 * 
	 * } catch (ParseException ex) {
	 * 
	 * ex.printStackTrace();
	 * 
	 * } return new java.sql.Date(fecha.getTime());
	 * 
	 * // System.out.println(fecha.toString()); }
	 * 
	 * public static void actualizarMeta(Meta m, int opcion, Object valor) { switch
	 * (opcion) { case 1://Titulo m.setTitulo((String)valor); break; case 2:
	 * //Descripcion m.setDescripcion((String) valor); break; case 3: //prioridad
	 * m.setPrioridad((String) valor); break; case 4: //fecha limite
	 * m.setFechalim((String) valor); break; case 5://categoria
	 * m.setCategoria((String) valor); break; }
	 * 
	 * }
     */
}
