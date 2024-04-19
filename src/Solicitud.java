import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solicitud {

    private final String nombreCliente;
    private final String correo;
    private final String telefono;
    private final String tipoMascotaPreferida;
    private final boolean solicitudAprobada;

    private static final List<Solicitud> registroSolicitudes = new ArrayList<>();

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

            try {
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
            } catch (InputMismatchException e) {
                System.err.println("Opción no válida. Intente nuevamente.");
                scanner.nextLine(); // Consumir el salto de línea
            } catch (NumberFormatException e) {
                System.err.println("Opción (número) no válida. Intente nuevamente.");
                scanner.nextLine(); // Consumir el salto de línea
            } catch (Exception e) {
                System.err.println("Ocurrió un error inesperado. Intente nuevamente.");
                scanner.nextLine(); // Consumir el salto de línea
            }
        }
        scanner.close();
    }

    public static void registrarSolicitud(Scanner scanner) {
        System.out.println("\nIngrese su nombre:");
        String nombre = scanner.nextLine();

        // Validación del correo electrónico
        String correo;
        while (true) {
            System.out.println("Ingrese su correo:");
            correo = scanner.nextLine();
            if (validarCorreo(correo)) {
                break;
            } else {
                System.out.println("Correo electrónico no válido. Intente nuevamente.");
            }
        }

        System.out.println("Ingrese su teléfono:");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese el tipo de mascota preferida:");
        //se supone que aquí se le tiene que agregar la lista de las mascotas :)
        String tipoMascotaPreferida = scanner.nextLine();

        Solicitud solicitud = new Solicitud(nombre, correo, telefono, tipoMascotaPreferida);
        registroSolicitudes.add(solicitud);
        System.out.println("Solicitud registrada exitosamente.");
    }

    public static boolean validarCorreo(String correo) {
        String pattern = "^[\\w-+]+(\\.[\\w-+]+)*@[\\w-]+(\\.[\\w-]+)*(\\.\\w{2,})$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(correo);
        return matcher.matches();
    }

    public static void verRegistroSolicitudes() {
        System.out.println("\nRegistro de solicitudes:");
        for (Solicitud solicitud : registroSolicitudes) {
            solicitud.imprimirSolicitud();
            System.out.println();
        }
        System.out.println("\nRegistro de solicitudes:");
        for (int i = 0; i < registroSolicitudes.size(); i++) {
            System.out.println("Solicitud " + (i + 1) + ":");
            registroSolicitudes.get(i).imprimirSolicitud();
            System.out.println("------------------------------");
        }
    }
}
