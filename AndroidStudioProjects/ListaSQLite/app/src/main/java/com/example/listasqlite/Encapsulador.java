package com.example.listasqlite;

public class Encapsulador {
    public String nombre;
    public String disco;

    public Encapsulador(String nombre, String disco) {
        this.nombre = nombre;
        this.disco = disco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

}
