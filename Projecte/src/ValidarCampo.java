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




    // public static void main(String[] args) 
    // {

    //     verificarCodigo();
    //     System.out.print("Ingresa una contrasenya segura: ");
    //     String password1 = sc.nextLine();
        
    //     System.out.println(compruebaPassword(password1));
    // }
    

}
