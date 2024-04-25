import acciones.*;
import animales.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("\n\t===Bienvenidos al Sistema de Adopción de Animales rescatados===");
        System.out.println("\n====Menu====");
        System.out.println("1. Ingresar al systema de refugio");
        System.out.println("2. Ingresar al Systema de Solicitudes");
        System.out.println("3. Salir");

        try {
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    registrar.SysRefugio();
                    break;
                case 2:
                    Solicitud.SysSolicitud();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } catch (
                InputMismatchException e) {
            System.err.println("Opción no válida. Intente nuevamente.");
            scanner.nextLine(); // Consumir el salto de línea
        } catch (NumberFormatException e) {
            System.err.println("Opción (número) no válida. Intente nuevamente.");
            scanner.nextLine(); // Consumir el salto de línea
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado. Intente nuevamente.");
            e.printStackTrace();
            scanner.nextLine(); // Consumir el salto de línea
        }
        scanner.close();
    }
}