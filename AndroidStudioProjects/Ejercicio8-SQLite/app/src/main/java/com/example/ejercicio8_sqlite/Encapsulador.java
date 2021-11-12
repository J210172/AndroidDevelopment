package com.example.ejercicio8_sqlite;

public class Encapsulador {
    public String group;
    public String disk;
    public int idImage;

    public Encapsulador(String group, String disk, int idImage) {
        this.group = group;
        this.disk = disk;
        this.idImage = idImage;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
