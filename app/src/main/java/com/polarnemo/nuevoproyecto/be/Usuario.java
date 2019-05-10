package com.polarnemo.nuevoproyecto.be;

public class Usuario {

    String nombre, distrito, carrera;
    int dni, edad;

    public Usuario() {
        this.nombre = "Nemo";
        this.distrito = "Anknow";
        this.carrera = "Latin Languages";
        this.dni = 555;
        this.edad = 33;
    }

    public Usuario(String nombre, String distrito, String carrera, int dni, int edad) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.carrera = carrera;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
