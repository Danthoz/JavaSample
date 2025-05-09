package org.example.dto;

public class Client {
    private String id;
    private String nombre;
    private int edad;
    private String estado;

    // Constructor
    public Client(String id, String nombre, int edad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
    }

    public Client() {
        // Default constructor
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
