package registro;

import java.util.Arrays;

public class ValidarCampo {

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
