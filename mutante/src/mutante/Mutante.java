package mutante;

import java.util.Scanner;

public class Mutante {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean continuar = true;
        
        while(continuar == true){
            String[] adn = new String[6];
            
            System.out.println("Ingrese las secuencias de ADN en la matriz: ");
            for (int i = 0; i < 6; i++) {
                String secuencia = sc.next();
                if(secuenciaValida(secuencia)){
                    adn[i] = secuencia;
                } else {
                    System.out.println("Secuencia invalida");
                    System.out.println("Ingresar solamente las letras G,C,A,T");
                    i--;
                }
            }

            //instancio una clase tipo AnalizarADN
            AnalizarADN mutante = new AnalizarADN();

            //le asigno al booleano isMutant el valor de TRUE o FALSE que me devuelve el metodo isMutant() de la clase AnalizarADN
            boolean isMutant = mutante.isMutant(adn);

            if (isMutant) {
                System.out.println("El ADN ingresado corresponde a un mutante");
            } else {
                System.out.println("El ADN ingresado NO corresponde a un mutante");
            }
            
            System.out.println("Desea cargar otra secuencia?(s/n)");
            String respuesta = sc.next();
            if (respuesta.equals("s") || respuesta.equals("S")) {
                continuar = true;
            } else {
                continuar = false;
            }
        }
    }
    
    public static boolean secuenciaValida(String secuencia){
        for (char c : secuencia.toCharArray()) {
            if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                return false;
            }
        }
        return true;
    }
}
