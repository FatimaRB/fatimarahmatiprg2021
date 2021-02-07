/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawbank;

import java.util.Scanner;


/**
 *
 * @author Fatima
 */
public class DawBank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* Creamos la cuenta bancaria.
        1. Pedimos el nombre completo. 
        2. Generamos un número de cuenta iban, que esté compuesto por 24 caracteres, siendo los últimos aleatorios
         */

        System.out.println("Introduce tu nombre y apellidos para crear la cuenta:");
        String titular = sc.nextLine();

        int iban1[] = {6, 6, 2, 1, 0, 0, 0, 4, 1, 8, 4, 0};//14 caracteres
        int iban2[] = new int[10];
        int iban[] = new int[22];

        for (int i = 0; i < iban2.length; i++) {
            int aleatorio = (int) (0 + Math.random() * (8+1));
            iban2[i] = aleatorio;
        }
        
        CuentaBancaria cuenta = new CuentaBancaria(iban, titular);
        
        
        System.out.println("El número asignado de IBAN al nombre " + titular + " es:");
        iban = combinaIban(iban1, iban2);
        System.out.print("ES");
        for (int i = 0; i < iban.length; i++) {
            System.out.print(iban[i]);
        }
        System.out.println("\n");
        
       

        String opcion;

        do {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Datos de la cuenta");
            System.out.println("2. IBAN");
            System.out.println("3. Titular");
            System.out.println("4. Saldo");
            System.out.println("5. Ingreso");
            System.out.println("6. Retirada");
            System.out.println("7. Movimientos");
            System.out.println("8. Salir");
            System.out.println("Elige una OPCIÓN y presiona INTRO");

            opcion = sc.nextLine();
            float importe = 0f;

            switch (opcion) {

                case "1":
                    System.out.println("El IBAN es: " + cuenta.getIban());
                    System.out.println("El titular de la cuenta es: " + cuenta.getTitular());
                    System.out.println("El saldo disponible es: " + cuenta.getSaldo());
                    break;
                case "2":
                    System.out.println("El IBAN es: " + cuenta.getIban());
                    break;
                case "3":
                    System.out.println("El titular de la cuenta es: " + cuenta.getTitular());
                    break;
                case "4":
                    System.out.println("El saldo disponible es: " + cuenta.getSaldo());
                    break;
                case "5":
                    System.out.println("Indique cantidad a ingresar: ");
                    if (importe >= 0) {
                        importe = sc.nextFloat();
                        cuenta.ingreso(importe);
                    }else System.out.println("Introduzca un importe válido");
                    break;
                case "6":
                    System.out.println("Indique cantidad a retirar: ");
                    if (importe >= 0) {
                        importe = sc.nextFloat();
                        cuenta.retirada(importe);
                    }else System.out.println("Introduzca un importe válido");
                    break;
                case "7":
                    float[] movimientos = cuenta.getMovimientos();
                    for (int i = 0; i < movimientos.length; i++) {
                        if (movimientos[i] != 0){
                        System.out.println(movimientos[i]);
                        }
                    }
                    break;
                case "8":
                    System.out.println("Va a salir del panel DawBank. Gracias y vuelva pronto.");
                    break;
                default:
                    System.out.println("Escoja una opción válida");
                    break;
            }
           
        } while (!"8".equals(opcion));
        
    }

    public static int[] combinaIban(int[] iban1, int[] iban2) {
        int[] iban = new int[iban1.length + iban2.length];
        System.arraycopy(iban1, 0, iban, 0, iban1.length);
        System.arraycopy(iban2, 0, iban, iban1.length, iban2.length);
        return iban;
    }

}
