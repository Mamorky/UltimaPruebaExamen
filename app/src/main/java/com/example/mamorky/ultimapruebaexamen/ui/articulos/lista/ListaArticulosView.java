package com.example.mamorky.ultimapruebaexamen.ui.articulos.lista;

import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;

import java.util.ArrayList;

/**
 * Created by mamorky on 13/12/17.
 */

public interface ListaArticulosView {
    void onLoadSuccess(ArrayList<Articulo> articulos);
}
