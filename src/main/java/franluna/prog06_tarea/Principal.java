package franluna.prog06_tarea;

import java.time.LocalDate;
import java.util.Scanner;
import franluna.prog06_tarea.Concesionario;
import prog06_tarea_validadores.Validadores;

/**
 *  En esta clase vamos a inicializar nuestro programa.
 *  Incluyendo en el nuestra clase vehículo, haciendo import de él.
 *  Además vamos a crear las funciones para crear el menú y crear las diferentes funcionalidades.
 * @author Francisco Luna Raya
 */
public class Principal {

    public static Vehiculo vehiculo = null;
    static Scanner scanner = new Scanner(System.in);
    static LocalDate fechaMatriculacion = null;
    public static Concesionario concesionario = new Concesionario();
    public static void main(String[] args) {

        int eleccion;

        do {
            menuVisual();
            eleccion=scanner.nextInt();
            scanner.nextLine();
            if (eleccion < 1 || eleccion > 5) {
                System.out.println("\nDebe introducir un número acorde al menú (1-5)");
                scanner.nextLine();
                
            }else{
                if (eleccion != 1 && vehiculo == null){
                    System.out.println("\nERROR, antes de realizar cualquier acción debe crear un vehículo.");
                    scanner.nextLine();
                }else{
    
                    switch (eleccion) {
                        case 1:
                            crearVehiculo();
                            break;
                        case 2:
                            concesionario.listarVehiculos();
                            break;
                        case 3:
                            buscarVehiculo();
                            break;
                        case 4:
                            actualizaKms();
                            break;
                        case 5:
                            System.out.println("Hasta la próxima");
                            break;
                        default:
                            System.out.println("ERROR");
                            break;
                    }
                }
            } 
        }while (eleccion != 5);
    }

    private static void menuVisual(){
        System.out.println("\n----MENU----");
        System.out.println("1. Nuevo Vehículo");
        System.out.println("2. Listar Vehículo");
        System.out.println("3. Buscar Vehículo");
        System.out.println("4. Modificar Kms Vehículo");
        System.out.println("5. Salir");
        System.out.println("\nIntroduzca una opción");
    }

    //TODO: Cuando se acaben de ingresar todos los datos correctamente, se debe guardar este vehículo en concesionario. Hasta un máx de 50.
    //Esta función la vamos a usar para ingresar todos los datos necesarios para crear el objeto Vehiculo.
    private static void crearVehiculo() {
        vehiculo = new Vehiculo();

        System.out.println("-----Ingrese los datos del vehículo:-----");
        System.out.println("\n==== Ingrese la marca del vehículo: ====");
        String marca = scanner.nextLine();
        vehiculo.setMarca(marca);
        
        //TODO: Validador de matrículas del vehículo, que compruebe que el formato de matricula es correcto siendo N un numero entre 0000 y 9999 y L letra mayúscula cualquiera, NNNNLLL
        System.out.println("\n==== Ingrese la matrícula del vehículo ====");
        String matricula = scanner.nextLine();
        vehiculo.setMatricula(matricula);
        scanner.nextLine();
        

        boolean kilometrosValidos = false;
        do{
            System.out.println("\n ==== Ingrese los kilómetros del vehículo ====");
            double kilometros = scanner.nextDouble();
            
            try {  
                Validadores.validadorKilometrosInicial(kilometros);
                kilometrosValidos = true;
                vehiculo.setKilometros(kilometros);
            } catch (IllegalArgumentException ex) {                                                                                                             
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();
            
        }while(!kilometrosValidos);


        boolean fechaValida = false;
        do {
            System.out.println("\n==== Ingrese el dia de matriculación del vehículo ====");
            int dia = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("\n==== Ingrese el mes de matriculación del vehículo ====");
            int mes = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("\n==== Ingrese el año de matriculación del vehículo ====");
            int anio = scanner.nextInt();
            scanner.nextLine();
            
            try {
                fechaMatriculacion = LocalDate.of(anio, mes, dia);
                Validadores.validadorFecha(fechaMatriculacion);
                fechaValida = true;
                vehiculo.setFechaMatriculacion(fechaMatriculacion);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();
        } while (!fechaValida);
        

        System.out.println("\n==== Ingrese la descripción del vehículo ====");
        String descripcion = scanner.nextLine();
        vehiculo.setDescripcion(descripcion);
        scanner.nextLine();


        System.out.println("\n==== Ingrese el precio del vehículo ====");
        double precio = scanner.nextDouble();
        vehiculo.setPrecio(precio);
        scanner.nextLine();

        //TODO: Validador nombre del propietario con 1 nombre, 2 apellidos y no más de 40 caracteres
        System.out.println("\n==== Ingrese el nombre del propietario del vehículo ====");
        String nombrePropietario = scanner.nextLine();
        vehiculo.setNombrePropietario(nombrePropietario);
        scanner.nextLine();


        boolean dniValido = false;
        do{
            System.out.println("\n==== Ingrese el DNI del propietario del vehículo ====");
            String dniPropietario = scanner.nextLine();
                try {
                Validadores.validadorDni(dniPropietario);
                dniValido = true;
                vehiculo.setDniPropietario(dniPropietario);
                } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            scanner.nextLine();

        }while(!dniValido);

        vehiculo = new Vehiculo(marca, matricula, vehiculo.getKilometros(), fechaMatriculacion, descripcion, precio, nombrePropietario, vehiculo.getDniPropietario());

        switch (concesionario.insertarVehiculo(vehiculo)) {
            case -2:
                System.out.println("\nEl vehículo ya existía anteriormente");
                break;
            case -1:
                System.out.println("\nEl concesionario está lleno, \nno se puede insertar ningún coche en el concesionario");
                break;
            case 0:
                System.out.println("\nEl vehículo ha sido insertado en el concesionario correctamente");
                break;
            default:
            break;
        }
    }

    public static void buscarVehiculo(){
        System.out.println("\n==== Introduzca la matrícula del vehículo a buscar ====");
        String matricula = scanner.nextLine();
        scanner.nextLine();
        vehiculo = concesionario.buscaVehiculo(matricula);

        if(vehiculo != null){
            System.out.println("Marca = " + vehiculo.getMarca());
            System.out.println("\nMatricula = " + vehiculo.getMatricula());
            System.out.println("\nPrecio = " + vehiculo.getPrecio());
        }
        scanner.nextLine();
    }

    public static void actualizaKms(){
        boolean actualizaKmValido = false;

        do {
            System.out.println("==== Introduzca la matrícula del vehículo a actualizar ====");
            String matricula = scanner.nextLine();
            scanner.nextLine();

            System.out.println("==== Introduzca la nueva cantidad de kilómetros ====");
            double kilometros = scanner.nextDouble();
            scanner.nextLine();
            try {
                if (concesionario.actualizaKms(matricula, kilometros)){
                Validadores.validadorKilometros(kilometros);
                System.out.println("Actualizados los kilómetros del vehículo con matrícula " + matricula);
                actualizaKmValido = true;
                }
            } catch (IllegalArgumentException ex) {
                
            }
        } while(!actualizaKmValido);
        
    }
    
}
