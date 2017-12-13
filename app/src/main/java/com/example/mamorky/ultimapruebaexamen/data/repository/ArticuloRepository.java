package com.example.mamorky.ultimapruebaexamen.data.repository;

import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;

import java.util.ArrayList;

/**
 * Created by mamorky on 13/12/17.
 */

public class ArticuloRepository{
    private static ArticuloRepository instance;
    private ArrayList<Articulo> articulos;

    private ArticuloRepository(){
        articulos = new ArrayList<Articulo>();
        inicialice();
    }

    public static ArticuloRepository getInstance(){
        if(instance == null)
            instance = new ArticuloRepository();
        return instance;
    }

    private void inicialice(){
        for (int i = 0; i < 7; i++) {
            addArticulo(new Articulo(i+0,"Patatas",i*8));
            addArticulo(new Articulo(i+10,"Albondigas",i*1));
            addArticulo(new Articulo(i+10,"Filete de Lomo",i*6));
        }
    }

    public ArrayList<Articulo> getArticulos(){
        return articulos;
    }

    public void addArticulo(Articulo articulo){
        articulos.add(articulo);
    }

    public void editArticulo(int id,int precio){
        for (int i = 0; i < articulos.size(); i++) {
            if(articulos.get(i).getId() == id)
            {
                articulos.get(i).setCoste(precio);
            }
        }
    }

    public void deleteArticulo(Articulo articulo){
        articulos.remove(articulo);
    }
}
