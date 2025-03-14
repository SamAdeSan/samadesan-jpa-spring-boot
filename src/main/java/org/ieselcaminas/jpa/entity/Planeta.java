package org.ieselcaminas.jpa.entity;

import java.util.ArrayList;
import java.util.List;

public class Planeta {
    private int posicionEnSS;
    private String nombre;
    private String descripcion;
    private List<Satelite> satelites = new ArrayList<>();

    public Planeta(int posicionEnSS, String nombre, String descripcion, Satelite satelite) {
        this.posicionEnSS = posicionEnSS;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getPosicionEnSS() {
        return posicionEnSS;
    }

    public void setPosicionEnSS(int posicionEnSS) {
        this.posicionEnSS = posicionEnSS;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Satelite> getSatelites() {
        return satelites;
    }

    public void addSatelite(Satelite satelite) {
        this.satelites.add(satelite);
    }

    @Override
    public String toString() {
        return "Datos del planeta: " + this.posicionEnSS + ", " + this.nombre + ", " + this.descripcion + ", " + this.satelites;
    }
}
