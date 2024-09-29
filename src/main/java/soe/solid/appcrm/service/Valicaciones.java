package soe.solid.appcrm.service;

import java.util.regex.Pattern;

public class Valicaciones {
    private static final String NUMEROS_REGEX = "\\d+";

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private static final Pattern NUMEROS_PATTERN = Pattern.compile(NUMEROS_REGEX);
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Método para validar si un string contiene solo números
    public static boolean validarNumero(String str) {
        return str != null && NUMEROS_PATTERN.matcher(str).matches();
    }

    // Método para validar si un string es un correo válido
    public static boolean validarCorreo(String correo) {
        return correo != null && EMAIL_PATTERN.matcher(correo).matches();
    }
}
