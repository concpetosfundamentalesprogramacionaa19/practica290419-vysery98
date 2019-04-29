package matricula_estudiante;

import java.util.Scanner;
import porcentajes.Porcentajes;

/**
 *
 * @author vysery98
 */
public class Principal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Scanner para ingreso de datos

        // declaración de variables
        double costo_matricula = 1330; // costo de la matricula inicial
        // variables de entrada
        String ciudad;
        int edad;
        String estado_civil;
        int cargas_familiares;
        // variables para operar (valor de descuentos y totales)
        double dctoProced;
        double dctoEdad;
        double dctoEstCiv;
        double dctoCargFam;
        double costTramAdm;
        double subTotal;
        double total;

        // ingreso de datos por teclado
        System.out.println("___INGRESO DE DATOS DEL ESTUDIANTE___");

        System.out.println("Ciudad de procedencia: ");
        ciudad = scan.nextLine();

        System.out.println("Edad: ");
        edad = scan.nextInt();
        scan.nextLine(); // para limpieza del buffer

        System.out.println("Estado civil: ");
        estado_civil = scan.nextLine();

        System.out.println("Número de cargas familiares: ");
        cargas_familiares = scan.nextInt();
        scan.nextLine(); // para limpieza del buffer

        // Verificacion de Datos para asignar descuento
        
        // Para datos numéricos ->__ == __ ; Para cadenas -> ____.equals(____)
        if ("Loja".equals(ciudad) || "Zamora".equals(ciudad)) {
            dctoProced = costo_matricula * Porcentajes.porcProcedencia;
            // Si es Loja o Zamora hay dcto del 20%
        } else {
            dctoProced = 0;
        }

        if (edad >= 17 && edad < 20) {
            dctoEdad = costo_matricula * Porcentajes.porcEdad;
            // Si (17 <= edad < 20) hay dcto de l0%
        } else {
            dctoEdad = 0;
        }

        if ("casado".equals(estado_civil)) {
            dctoEstCiv = costo_matricula * Porcentajes.porcEstadoCiv;
            // Si es casado hay dcto del 5%
        } else {
            dctoEstCiv = 0;
        }

        if (cargas_familiares > 0) {
            dctoCargFam = costo_matricula * Porcentajes.porcCargFam;
            // Si tiene cargas familiares hay dcto del 3%
        } else {
            dctoCargFam = 0;
        }

        // proceso
        subTotal = costo_matricula - dctoProced - dctoEdad - dctoEstCiv
                - dctoCargFam;

        costTramAdm = subTotal * Porcentajes.porcAdministrativo;
        // Se agrega 2% por trámites administrativos

        total = subTotal + costTramAdm;

        // salida
        System.out.printf("Costo final de la matrícula = $%.2f", total);
    }

}
