package franluna.prog06_tarea;
import franluna.prog06_tarea.Vehiculo;

/**
 *  En esta clase vamos a almacenar los vehículos, hasta un tamaño total de 50 vehículos, para ello hacemos uso de un array,
 *  además tenemos diferentes funciones o métodos, donde podemos listar los vehículos, actualizar sus datos, etc...
 * @author Francisco Luna Raya
 */
public class Concesionario {
    
    private Vehiculo[] vehiculos;
    private int numVehiculo;

    //Aquí se crea un constructor vacío del Concesionario, donde declaramos el número inicial de vehículo y el tamaño de nuestro array.
    public Concesionario (){
        this.numVehiculo = 0;
        this.vehiculos = new Vehiculo[50];
    }
    //Recibe como parámetro una matrícula, buscar el vehículo en el concesionario y devuelve una cadena con los datos del vehículo o null si el vehículo buscado no existe.
    public Vehiculo buscaVehiculo (String matricula){

        for (int i = 0; i < numVehiculo; i++) {
            Vehiculo vehiculo = this.vehiculos[i];

            if(vehiculo.getMatricula().equals(matricula)){
                return vehiculo;
            }
        }
        return null;
    }

    /** 
     * Recibe todos los datos de un vehículo y trata de insertarlo en el concesionario. 
     * Devuelve 0 si se hizo con éxito, -1 si el concesionario está lleno y -2 si la matrícula ya existe.
     */
    public int insertarVehiculo(Vehiculo vehiculo){
        if(this.numVehiculo == this.vehiculos.length){
            return -1;
        }
        if(this.buscaVehiculo(vehiculo.getMatricula()) != null){
            return -2;
        }else{
            this.vehiculos[this.numVehiculo++] = vehiculo;
            return 0;
        }
    }
    //Lista por pantalla los datos de todos los vehículos del concesionario.
    public void listarVehiculos(){
        for (int i = 0; i < numVehiculo; i++) {
            Vehiculo vehiculo = this.vehiculos[i];
            System.out.println(vehiculo.toString());
        }
    }
    /** 
     *  Recibe por parámetro una matrícula y un número de kilómetros, busca el vehículo con la cuya matrícula coincida y actualiza sus kilómetros. 
     *  Devuelve true si se hizo con éxito y false en caso contrario.
     */
    public boolean actualizaKms (String matricula, double kilometros){

        for (int i = 0; i < numVehiculo; i++) {
            Vehiculo vehiculo = this.vehiculos[i];

            if(vehiculo.getMatricula().equals(matricula)){
                vehiculo.setKilometros(kilometros);
                return true;
            }
        }
        return false;
    }




}
