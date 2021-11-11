package com.example.ejercicio8_sqlite;

public class Encapsulador {
    public String group;
    public String disk;

    public Encapsulador(String group, String disk) {
        this.group = group;
        this.disk = disk;
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

}
