package franluna.prog06_tarea;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 *  En esta clase vamos a crear el constructor del Objeto "Vehiculo",
 *  creando también todos los Getters y Setters de cada variable del objeto,
 *  y por último una función que nos permite calcular los años desde que se matriculó el coche
 *  hasta el día de hoy.
 * @author Francisco Luna Raya
 */
public class Vehiculo {

    Scanner scanner = new Scanner(System.in);

    /**
     *  Declaramos las variables a usar
     *  @param marca
     *  @param matricula
     *  @param kilometros
     *  @param fechaMatriculacion
     *  @param descripcion
     *  @param precio
     *  @param nombrePropietario
     *  @param dniPropietario
     */
    private String marca;
    private String matricula;
    private double kilometros;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private double precio;
    private String nombrePropietario;
    private String dniPropietario;
    
    
    //Creamos un constructor vacío del vehículo
    public Vehiculo (){
        this.marca = "";
        this.matricula = "";
        this.kilometros = 0;
        this.fechaMatriculacion = null;
        this.descripcion = "";
        this.precio = 0;
        this.nombrePropietario = "";
        this.dniPropietario = "";
    }


    //Creamos el constructor del vehículo
    public Vehiculo (String marca, String matricula, double kilometros, LocalDate fechaMatriculacion, String descripcion, double precio, String nombrePropietario, String dniPropietario){
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }


    //A partir de aquí van los Getter y Setters de cada uno de los parámetros declarados anteriormente.
    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public double getKilometros(){
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
        
    }

    public LocalDate getFechaMatriculacion(){
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion){
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String getNombrePropietario(){
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario){
        this.nombrePropietario = nombrePropietario;
    }

    public String getDniPropietario(){
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario){
        this.dniPropietario = dniPropietario;
    }


    //Función para obtener los años de antigüedad
    public int getAnios(){
        Period aniosAntiguedad = Period.between(fechaMatriculacion, LocalDate.now());
        return aniosAntiguedad.getYears();
    }


    //Aquí hacemos un Override para la función toString() para que nos devuelva los valores deseados por mensaje.
    @Override
    public String toString() {
        return "Vehiculo {" + "Marca = " + marca + " | Matricula = " + matricula + " | Precio = " + precio + " | Kilómetros = " + kilometros + " | Descripción = " + descripcion +"}";
    }

}
