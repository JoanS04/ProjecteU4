import java.security.SecureRandom;
import java.util.Scanner;

public class RegistroUsuario {
    private static String[] usuaris = {"Carles_345", "Sara-238", "Juan_912", "Ana-605", "Luisa_123", "Pablo-896", "Elena_321", "Pedro-789", "Maria_456", "Marta-234"};
    
    public static boolean compruebaNombre(String nombre) {
        if (!nombre.matches("^[A-Z][a-z]+[_-]\\d{3}$") || nombre.length() > 16) {
            return false;
        }
        for (String n : usuaris) {
            if (n != null && n.equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        return true;
    }

    public static boolean compruebaEmail(String email) {
        if (!email.matches(".+@.+\\.(com|es|cat)$")) {
            return false;
        }
    
        String[] partes = email.split("@");
        String dominio = partes[1].split("\\.")[0];

        if (!dominio.equalsIgnoreCase("paucasesnovescifp") && !dominio.equalsIgnoreCase("yahoo") && !dominio.equalsIgnoreCase("gmail") && !dominio.equalsIgnoreCase("hotmail")) {
            return false;
        }
    
        return true;
    }

    public static boolean compruebaPassword(String password) {
        if (!password.matches("^[A-Z][a-zA-Z0-9_@#\\-]+\\d{2}$") || password.length() != 8) {
            return false;
        }

        return true;
    }

    public static boolean generaCodigoSeguridad() {       
        String codigoAutogenerado = generarCodigoAleatorio(8);

        System.out.println("El código autogenerado es: " + codigoAutogenerado);
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el código de seguridad: ");
        String codigoUsuario = scanner.nextLine();
        
        if (codigoAutogenerado.equals(codigoUsuario)) {
            System.out.println("El código introducido es correcto.");
            return true;
        } else {
            System.out.println("El código introducido no es correcto.");
            return false;
        }
    }
    
    private static String generarCodigoAleatorio(int longitud) {
        final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{}|;:,.<>/?";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Introduce un nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        boolean uName = compruebaNombre(nombreUsuario);
        if (uName) {
            System.out.println("El nombre de usuario es válido.");
        } else {
            System.out.println("El nombre de usuario no es válido.");
        }
    
        System.out.print("Introduce un correo electrónico: ");
        String correoElectronico = scanner.nextLine();
        boolean mail = compruebaEmail(correoElectronico);
        if (mail) {
            System.out.println("El correo electrónico es válido.");
        } else {
            System.out.println("El correo electrónico no es válido.");
        }
    
        System.out.print("Introduce una contraseña: ");
        String password = scanner.nextLine();
        boolean pwd = compruebaPassword(password);
        if (pwd) {
            System.out.println("La contraseña es válida.");
        } else {
            System.out.println("La contraseña no es válida.");
        }
    
        boolean secCode = generaCodigoSeguridad();

        if (uName && mail && pwd && secCode){
            System.out.println("Registro realizado con exito!");
        }



    }
    
}
