package prog06_tarea_validadores;

import java.time.LocalDate;
import franluna.prog06_tarea.Principal;

/** 
 * En esta clase vamos a incorporar una serie de validadores,
 * para poder evitar diferentes casos que no queremos que se den en nuestro progama.
 * @author Francisco Luna Raya
 */
public class Validadores {
    
    /**
      * Función para validar la fecha. Nos retorna un error en caso de que la fecha introducida sea posterior a la actual.
      * @param fechaMatriculacion
      */
    public static void validadorFecha(LocalDate fechaMatriculacion){
        if(fechaMatriculacion.isAfter(LocalDate.now()) || fechaMatriculacion.isEqual(LocalDate.now())){
            throw new IllegalArgumentException("\nLa fecha debe de ser anterior a la actual. La fecha actual es: " + LocalDate.now());
        }
    }


    /**
     * Función para validar el DNI. Nos retorna un error en caso de que el DNI sea igual al regex que hemos realizado
     * @param dniPropietario
     */
    public static void validadorDni(String dniPropietario){
        if (!dniPropietario.matches("^\\d{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$")){
            throw new IllegalArgumentException("\nEl DNI es incorrecto, el DNI debe incluir 8 números y 1 letra válida en mayúsculas.");
        }
    }


    /**
      * Función para validar los kilómetros al actualizarlos. Nos retorna un error en caso de que los kilometros introducidos sean superiores al anterior kilometraje introducido.
      * @param kilometros
      */
    public static void validadorKilometros(double kilometros){
        if (kilometros <= Principal.vehiculo.getKilometros() ) {
            throw new IllegalArgumentException("\nEl número debe de ser superior al anterior kilometraje, el anterior kilometraje es : " + Principal.vehiculo.getKilometros());
            } 
        }


        /**
         * Función para validar los kilometros iniciales al crear el objeto. Nos retorna un error en caso de que los kilometros iniciales sean superiores a 0.
         * @param kilometros
         */
    public static void validadorKilometrosInicial(double kilometros){
        if (kilometros < 0) {
            throw new IllegalArgumentException("\nEl número de kilómetros debe de ser superior a 0.");
            } 
        }


    /**
     * Función para validar que el nombre del propietario contenga al menos un nombre y dos apellidos (no tratar nombres compuestos) y su longitud no excede de 40 caracteres.
     * @param nombrePropietario
     */
    public static void validadorNombrePropietario (String nombrePropietario){
        
        if (nombrePropietario.length() > 40) {
            throw new IllegalArgumentException("El nombre debe de ser menor a 40 caracteres.");
        }

        // Dividir el nombre en partes: nombre y apellidos
        String[] partes = nombrePropietario.split("\\s+");

        // Verificar que haya al menos un nombre y dos apellidos
        if (partes.length < 3) {
            throw new IllegalArgumentException("El nombre debe de estar compuesto por 1 nombre y 2 apellidos.");
        }
    }


    /**
     * Función para validar matrículas del vehículo, que compruebe que el formato de matricula es correcto siendo N un numero entre 0000 y 9999 y L letra mayúscula cualquiera, NNNNLLL
     * @param matricula
     */
    public static void validadorMatricula(String matricula){
        if(!matricula.matches("^\\d{4}[A-Za-z]{3}$")){
            throw new IllegalArgumentException("La matrícula debe de contener 4 números seguidos de 3 letras.");
        }
    }
}
