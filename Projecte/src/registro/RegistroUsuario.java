package registro;

import java.util.Scanner;


/**
 * La clase RegistroUsuario permite a un usuario introducir sus datos de registro y validarlos mediante
 * la clase ValidarCampo. Al finalizar la introducción de datos, muestra los datos introducidos por el usuario.
 */
public class RegistroUsuario {

    String[] usuarios = {"Carles_345", "Sara-238", "Juan_912", "Ana-605", "Luisa_123", "Pablo-896", "Elena_321", "Pedro-789", "Maria_456", "Marta-234"}; // base de datos de los usuarios
    
    private ValidarCampo v = new ValidarCampo(); // instancia de la clase ValidarCampo para validar los campos

    /**
     * Constructor de la clase RegistroUsuario que llama al método init para iniciar el registro de usuario.
     */
    public RegistroUsuario(){
        init();
    }

    /**
     * Método privado init que inicia el proceso de registro de usuario.
     * Solicita al usuario que introduzca su nombre de usuario, correo electrónico y contraseña,
     * y valida cada uno de los campos mediante la instancia de la clase ValidarCampo.
     * Una vez validados los campos, muestra los datos introducidos por el usuario.
     */
    private void init() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean valid = false;
            String username = getStringFromScanner(scanner, "Introduce un nombre de usuario: ", 1);
            String email = getStringFromScanner(scanner, "Introduce un correo electrónico: ", 2);
            String password = getStringFromScanner(scanner, "Introduce una contraseña: ", 3);
            while (valid!= true){
                valid = v.verificarCodigo();
            }

            System.out.println("Los datos introducidos son:");
            System.out.println("Nombre de usuario: " + username);
            System.out.println("Correo electrónico: " + email);
            System.out.println("Contraseña: " + password);
        } catch (Exception e) {
            System.out.println("Error durante el scanner");
        }
    }

    /**
     * Método privado getStringFromScanner que recibe un objeto Scanner, un mensaje para mostrar al usuario
     * y un número de comprovación. Según el número de comprovación, llama a un método de la clase ValidarCampo
     * para validar el campo introducido por el usuario. Retorna el valor introducido por el usuario una vez validado.
     * @param scanner objeto Scanner utilizado para recibir la entrada del usuario.
     * @param message mensaje que se muestra al usuario para solicitar el campo.
     * @param comprovacio número que indica qué campo se está validando (1=nombre de usuario, 2=correo electrónico,
     *                    3=contraseña, 4=código de verificación).
     * @return el valor introducido por el usuario una vez validado.
     */
    private String getStringFromScanner(Scanner scanner, String message, int comprovacio) {
        boolean acceptat = false;
        String valor = "";

        while (acceptat != true){
            System.out.print(message);
            valor = scanner.nextLine();
            switch (comprovacio){
                case 1 -> acceptat = v.compruebaNombre(valor, usuarios);
                case 2 -> acceptat = v.compruebaEmail(valor);
                case 3 -> acceptat = v.compruebaPassword(valor);
                case 4 -> acceptat = v.verificarCodigo();
            }

        }

        return valor;
    }

    /**
     * Método main que crea una instancia de la clase RegistroUsuario.
     */
    public static void main(String[] args) {
        new RegistroUsuario();
    }

}
