package registro;

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.regex.*;

public class ValidarCampo 
{
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{}|;:,.<>/?";
    static String codigo = "";
    static Scanner sc = new Scanner(System.in);

    private static void generarCodigoAleatorio(int longitud) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(CARACTERES.length());
            codigo += CARACTERES.charAt(index);
        }
        System.out.println(codigo);
    }

    private static Boolean verificarCodigo() 
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

    
    
    public static boolean compruebaPassword(String password) {
        String patron = "^[A-Z][\\w]*[@#\\-_]\\d{2}$";
        
        Pattern p = Pattern.compile(patron);
        
        Matcher m = p.matcher(password);
        
        return m.matches();
    }

    public ValidarCampo(){

    }
    
    public boolean compruebaNombre(String nombreUsuario, String[] usuarios) {
        boolean nombreValido = nombreUsuario.matches("^[A-Z][a-z]+[_-]\\d{3}$") && nombreUsuario.length() <= 16;
        boolean nombreExiste = Arrays.stream(usuarios).anyMatch(n -> n != null && n.equalsIgnoreCase(nombreUsuario));

        if (nombreValido && !nombreExiste){
            return true;
        }
        return false;
    }
    
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
