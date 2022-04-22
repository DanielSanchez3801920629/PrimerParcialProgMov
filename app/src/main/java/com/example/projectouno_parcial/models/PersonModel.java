package com.example.projectouno_parcial.models;

public class PersonModel {

    private String nombre;

    public PersonModel(){
        this.nombre = "";
    }
    public PersonModel(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
