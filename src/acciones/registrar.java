package acciones;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import acciones.Verificacion;
import acciones.Solicitud;
public class registrar {
    public static void SysRefugio () {
        Scanner scanner = new Scanner(System.in);
        Refugio refugio = new Refugio();
        cargarDatos(refugio);
        String nombreAdoptante = null, cedulaAdoptante, correoAdoptante, apellidoAdoptante, direccionAdoptante, respuesta, porpio, CedulaV;
        int opcion = 0, opc = 0, edadAnimal;
        boolean usuarioRegistrado = false;
        Usuario adoptante = null;

        System.out.println("\n\t***Bienvenido al Sistema de registro para Adopcion de Animales***");
        System.out.println("\nEs usted un usuario ya registrado?");
        System.out.println("1. Si");
        System.out.println("2. No");
        try {
            opcion = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.err.println("Opción no válida. Intente nuevamente.");
            scanner.nextLine();
        } catch (NumberFormatException e) {
            System.err.println("Opción (número) no válida. Intente nuevamente.");
            scanner.nextLine();
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado. Intente nuevamente.");
            scanner.nextLine();
        }

        if (opcion == 1) {
            System.out.println("\nPorfavor ingrese su Cedula: ");
            CedulaV = scanner.nextLine();
            if ((!Verificacion.validarCed(CedulaV))) {
                System.out.println("Cedula invalida.");
                System.out.println("\nIngrese nuevamente su Cedula: ");
                CedulaV = scanner.nextLine();
            }

            File file = new File("Usuarios.dat");
            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    Usuario usuario = (Usuario) ois.readObject();
                    if (usuario.getCedula().equals(CedulaV)) {
                        System.out.println("Usuario encontrado");
                        usuarioRegistrado = true;
                    } else {
                        System.err.println("No se encontró usuario con esta cédula.");
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("No se encontró el archivo de usuarios.");
            }
        }
        if (!usuarioRegistrado) {
            System.out.println("\n\nIngrese sus datos para registrase como adoptante: ");

            System.out.println("\nNombre: ");
            nombreAdoptante = scanner.nextLine();
            if ((!Verificacion.validarNom(nombreAdoptante))) {
                System.out.println("El nombre debe iniciar con una letra Mayuscula y sin numeros.");
                System.out.println("\nIngrese nuevamente su Nombre: ");
                nombreAdoptante = scanner.nextLine();
            }

            System.out.println("\nApellido: ");
            apellidoAdoptante = scanner.nextLine();
            if ((!Verificacion.validarape(apellidoAdoptante))) {
                System.out.println("La primera letra del apellido debe ser mayuscula.");
                System.out.println("\nIngrese nuevamente su Apellido: ");
                apellidoAdoptante = scanner.nextLine();
            }

            System.out.println("\nCedula: ");
            cedulaAdoptante = scanner.nextLine();
            if ((!Verificacion.validarCed(cedulaAdoptante))) {
                System.out.println("Cedula invalida.");
                System.out.println("\nIngrese nuevamente su Cedula: ");
                cedulaAdoptante = scanner.nextLine();
            }

            System.out.println("1.Estoy interesado en adoptar una mascota.");
            System.out.println("2.Solo quiero ver la lista de animales en Adopción");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 2) {
                System.out.println("Lista de animales en adopcion Disponibles");
                opcion = scanner.nextInt();
                scanner.nextLine();
                refugio.mostrarAnimales();

            } else if (opcion == 1) {
                System.out.println("Ingrese datos para adopcion: ");
                System.out.println("Correo Electronico: ");
                correoAdoptante = scanner.nextLine();
                if ((!Verificacion.validarCorreo(correoAdoptante))) {
                    System.out.println("Correo electronico invalido.");
                    System.out.println("\nIngrese nuevamente su correo: ");
                    correoAdoptante = scanner.nextLine();
                }

                System.out.println("Ingrese su Direccion: ");
                direccionAdoptante = scanner.nextLine();

                System.out.println("Porque desea adoptar una mascota?");
                porpio = scanner.nextLine();

                System.out.println("Tiene suficionete ingresos para mantener una mascota? Si/No");
                respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("Si")) {
                    System.out.println("Felicidades puedes adoptar una mascota.");
                    System.out.println("\n!Registrado correctamente como adoptante!");
                    usuarioRegistrado = true;
                    adoptante = new Usuario(nombreAdoptante, apellidoAdoptante, cedulaAdoptante, correoAdoptante, direccionAdoptante, respuesta);
                    guardarUsurios(adoptante);
                } else {
                    System.out.println("\nNo eres apto para adoptar una mascota.");
                    usuarioRegistrado = false;
                }

            }
        }
            do {
                System.out.println("\nElige una de las siguientes opciones:");
                System.out.println("1.Ingresar animales al refugio.");
                System.out.println("2.Ver lista de animaes disponibles.");
                System.out.println("3.Adoptar un animal.");
                System.out.println("4.Salir.");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarAnimal(refugio, scanner);
                        guardarDatos(refugio);
                        break;
                    case 2:
                        refugio.mostrarAnimales();
                        break;
                    case 3:
                        Solicitud.SysSolicitud();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor, elija nuevamente.");
                        break;
                }
            }
            while (opcion != 4);
    }

    //Registro Animal///
    private static void registrarAnimal(Refugio refugio, Scanner scanner) {
        System.out.println("\nIngrese los datos del animal: ");
        System.out.println("Nombre: ");

        String nombreAnimal = scanner.nextLine();

        System.out.println("Edad: ");
        int edadAnimal = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Especie: ");
        String especieAnimal = scanner.nextLine();

        System.out.println("Estado de salud: ");
        String estadoSaludAnimal = scanner.nextLine();

        Animal animal = new Animal(nombreAnimal, edadAnimal, especieAnimal, estadoSaludAnimal);

        refugio.agregarAnimal(animal);
        System.out.println("Animal registrado en el refugio.");
    }

    //Guardar datos en archivo//
    private static void guardarDatos(Refugio refugio) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos_refugio.dat"))) {
            oos.writeObject(refugio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void guardarUsurios(Usuario adoptante) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Usuarios.dat"))) {
            oos.writeObject(adoptante);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //cargar datos de archivo//
    private static void cargarDatos(Refugio refugio) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos_refugio.dat"))) {
            Refugio refugioGuardado = (Refugio) ois.readObject();
            refugio.setListaAnimales(refugioGuardado.getListaAnimales());

        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
