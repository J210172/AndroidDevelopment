package com.example.intents;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private int edad;
    private int codigopostal;

    public Persona(String Nombre, int Edad, int Codigo){

        this.nombre = Nombre;
        this.edad = Edad;
        this.codigopostal = Codigo;

    }

    public String getNombre(){

        return this.nombre;

    }

    public int getEdad(){

        return this.edad;

    }

    public int getCP(){

        return this.codigopostal;

    }

    public String toString(){

        return "Nombre: " + this.nombre + ", Edad: " + this.edad + ", CP: " + this.codigopostal;

    }

}
