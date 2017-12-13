package com.example.mamorky.ultimapruebaexamen.ui.articulos.lista;

import android.widget.ArrayAdapter;

import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;

import java.util.ArrayList;

/**
 * Created by mamorky on 13/12/17.
 */

public interface ListaArticulosInteractor {
    void loadArticulos(onLoadSuccess onLoadSuccess);
    void deleteArticulo(Articulo articulo);
    interface onLoadSuccess{
        void onLoadSuccess(ArrayList<Articulo> articulos);
    }
}
