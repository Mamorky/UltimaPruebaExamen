package com.example.mamorky.ultimapruebaexamen.data.pojo;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by mamorky on 13/12/17.
 */

public class Articulo implements Serializable,Comparable<Articulo>{
    private int id;
    private String nombre;
    private int coste;


    public Articulo(int id, String nombre, int coste) {
        this.id = id;
        this.nombre = nombre;
        this.coste = coste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    @Override
    public int compareTo(@NonNull Articulo o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
