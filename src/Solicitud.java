import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solicitud {

    private String nombreCliente;
    private String correo;
    private String telefono;
    private String tipoMascotaPreferida;
    private boolean solicitudAprobada;


    private static List<Solicitud> registroSolicitudes = new ArrayList<>();

    // Constructor
    public Solicitud(String nombreCliente, String correo, String telefono, String tipoMascotaPreferida) {
        this.nombreCliente = nombreCliente;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoMascotaPreferida = tipoMascotaPreferida;
        this.solicitudAprobada = false;
    }



    public void imprimirSolicitud() {
        System.out.println("Nombre del cliente: " + nombreCliente);
        System.out.println("Correo: " + correo);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Tipo de mascota preferida: " + tipoMascotaPreferida);
        System.out.println("Estado de la solicitud: " + (solicitudAprobada ? "Aprobada" : "Pendiente"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) { // 3 para salir del menú
            System.out.println("\nMenú de opciones");
            System.out.println("1. Registrar nueva solicitud");
            System.out.println("2. Ver registro de solicitudes");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción:");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarSolicitud(scanner);
                    break;
                case 2:
                    verRegistroSolicitudes();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
        scanner.close();
    }

    public static void registrarSolicitud(Scanner scanner) {
        System.out.println("\nIngrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su correo:");
        String correo = scanner.nextLine();

        System.out.println("Ingrese su telefono:");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese el tipo de mascota que prefiere:");
        String tipoMascota = scanner.nextLine();

        Solicitud solicitud = new Solicitud(nombre, correo, telefono, tipoMascota);
        registroSolicitudes.add(solicitud);

        System.out.println("Solicitud registrada exitosamente.");
    }

    public static void verRegistroSolicitudes() {
        if (registroSolicitudes.isEmpty()) {
            System.out.println("No hay solicitudes registradas.");
            return;
        }

        System.out.println("\nRegistro de solicitudes:");
        for (int i = 0; i < registroSolicitudes.size(); i++) {
            System.out.println("Solicitud " + (i + 1) + ":");
            registroSolicitudes.get(i).imprimirSolicitud();
            System.out.println("------------------------------");
        }
    }
}
