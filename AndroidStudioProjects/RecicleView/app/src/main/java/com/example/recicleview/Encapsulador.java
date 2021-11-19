package com.example.recicleview;

public class Encapsulador {
    public int idImagen;
    public String textoTitulo;
    public String textoContenido;

    public Encapsulador(int idImagen, String textoTitulo, String textoContenido) {
        this.idImagen = idImagen;
        this.textoTitulo = textoTitulo;
        this.textoContenido = textoContenido;

        C
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getTextoTitulo() {
        return textoTitulo;
    }

    public void setTextoTitulo(String textoTitulo) {
        this.textoTitulo = textoTitulo;
    }

    public String getTextoContenido() {
        return textoContenido;
    }

    public void setTextoContenido(String textoContenido) {
        this.textoContenido = textoContenido;
    }

}
