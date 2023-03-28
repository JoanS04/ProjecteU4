package registro;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

/**
* Clase ValidarCampo que contiene métodos para validar campos de entrada en un formulario de registro.
*/

public class ValidarCampo 
{
    /**
     *Constante que contiene los caracteres permitidos para generar un código aleatorio.
     */
    private final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{}|;:,.<>/?";

    /**
     *Variable que almacena el código aleatorio generado.
     */
    String codigo = "";

    /**
     *Objeto Scanner para leer datos de entrada del usuario.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Genera un código aleatorio de la longitud especificada y lo muestra por pantalla.
     * @param longitud Longitud del código aleatorio a generar.
     */
    private void generarCodigoAleatorio(int longitud) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(CARACTERES.length());
            codigo += CARACTERES.charAt(index);
        }
        System.out.println(codigo);
    }

    /**
     * Verifica si el código ingresado por el usuario es igual al código generado aleatoriamente.
     * @return true si el código ingresado es igual al código generado, false en caso contrario.
     */
    public Boolean verificarCodigo() 
    {
        generarCodigoAleatorio(8);
        System.out.print("Ingresa el código generado: ");
        String codigoIngresado = sc.nextLine();
        if (codigo.equals(codigoIngresado))
        {
            System.out.println("BIEN");
            return true;
        }
        else {
            System.out.println("MAL");
            return false;
        }
    }

    /**
     * Comprueba si la contraseña cumple con un patrón específico.
     * @param password Contraseña a comprobar.
     * @return true si la contraseña cumple con el patrón, false en caso contrario.
    */
    public boolean compruebaPassword(String password) {
        String patron = "^[A-Z][\\w]*[@#\\-_]\\d{2}$";
        
        Pattern p = Pattern.compile(patron);
        
        Matcher m = p.matcher(password);
        
        return m.matches();
    }

    public ValidarCampo(){

    }
    
    
    /**
     * Comprueba si el nombre de usuario cumple con un patrón específico y si no existe ya en el sistema.
     * @param nombreDeUsuario Nombre de usuario a comprobar.
     * @param usuarios Lista de usuarios registrados en el sistema.
     * @return true si el nombre de usuario cumple con el patrón y no existe en el sistema, false en caso contrario.
     */
    public boolean compruebaNombre(String nombreDeUsuario, String[] usuarios) {
        boolean nombreValido = nombreDeUsuario.matches("^[A-Z][a-z]+[_-]\\d{3}$") && nombreDeUsuario.length() <= 16;
        boolean nombreExiste = Arrays.stream(usuarios).anyMatch(n -> n != null && n.equalsIgnoreCase(nombreDeUsuario));

        if (nombreValido && !nombreExiste){
            return true;
        }
        return false;
    }
    
    /**
     * Comprueba si el correo electrónico cumple con un patrón específico y si el dominio es uno de los aceptados.
     * @param email Correo electrónico a comprobar.
     * @return true si el correo electrónico cumple con el patrón y el dominio es uno de los aceptados, false en caso contrario.
     */
    public boolean compruebaEmail(String email) {
        String[] dominiosAceptados = {"paucasesnovescifp", "yahoo", "gmail", "hotmail"};
        String regexEmail = ".+@.+.(com|es|cat)$";
        String[] partes = email.split("@");

        if (!email.matches(regexEmail)) {
            System.out.println("El formato del correo no es valido");
            return false;
        }
        
        String dominio = partes[1].split("\\.")[0];
        
        if (!Arrays.asList(dominiosAceptados).contains(dominio.toLowerCase())) {
            System.out.println("El dominio inicado no es aceptado");
            return false;
        }
        
        return true;
    }

}
