package edu.upc.dsa;
import edu.upc.dsa.utils.RandomUtils;
public class Caso {
    String nombre;
    String apellidos;
    String id;
    String nacimiento;
    String fechaInforme;
    String riesgo;
    String genero;
    String correo;
    int telefono;
    String direccion;
    String clasificacion;

    public Caso(){
        this.id=RandomUtils.getId();
    }

    public Caso(String nombre, String apellidos, String nacimiento, String fechaInforme, String riesgo, String genero, String correo, int telefono, String direccion, String clasificacion){
        this();
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.nacimiento=nacimiento;
        this.fechaInforme=fechaInforme;
        this.riesgo=riesgo;
        this.genero=genero;
        this.correo=correo;
        this.telefono=telefono;
        this.direccion=direccion;
        this.clasificacion=clasificacion;
    }
    public String GetId(){
        return this.id;
    }

}
