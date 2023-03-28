package registro;

import java.util.Scanner;

public class RegistroUsuario {
    
    ValidarCampo v = new ValidarCampo();

    String[] usuarios = {"Carles_345", "Sara-238", "Juan_912", "Ana-605", "Luisa_123", "Pablo-896", "Elena_321", "Pedro-789", "Maria_456", "Marta-234"};

    public RegistroUsuario(){
        init();
    }

    private void init() {
        try (Scanner scanner = new Scanner(System.in)) {
            String username = getStringFromScanner(scanner, "Introduce un nombre de usuario: ", 1);
            String email = getStringFromScanner(scanner, "Introduce un correo electrónico: ", 2);
            String password = getStringFromScanner(scanner, "Introduce una contraseña: ", 3);

            System.out.println("Los datos introducidos son:");
            System.out.println("Nombre de usuario: " + username);
            System.out.println("Correo electrónico: " + email);
            System.out.println("Contraseña: " + password);
        } catch (Exception e) {
            System.out.println("Error durante el scanner");
        }
    }

    private String getStringFromScanner(Scanner scanner, String message, int comprovacio) {
        boolean acceptat = false;
        String valor = "";

        while (acceptat != true){
            System.out.print(message);
            valor = scanner.nextLine();
            switch (comprovacio){
                case 1 -> acceptat = v.compruebaNombre(valor, usuarios);
                case 2 -> acceptat = v.compruebaEmail(valor);
                case 3 -> acceptat = v.compruebaEmail(valor);
            }

        }

        return valor;
    }
    
    public static void main(String[] args) {
        new RegistroUsuario();
    }
    
}
