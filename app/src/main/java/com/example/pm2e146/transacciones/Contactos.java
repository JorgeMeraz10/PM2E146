package com.example.pm2e146.transacciones;

public class Contactos {

    private Integer id;
    private String nombre;
    private String pais;
    private String telefono;
    private String nota;
    private String imagen;

    public Contactos(Integer id, String nombre, String pais, String telefono, String nota, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.telefono = telefono;
        this.nota = nota;
        this.imagen = imagen;
    }
    public Contactos(){}

    public Contactos(String nombre, String pais, String telefono, String nota , String imagen){
        this.nombre = nombre;
        this.pais = pais;
        this.telefono = telefono;
        this.nota = nota;
        this.imagen = imagen;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }












}
