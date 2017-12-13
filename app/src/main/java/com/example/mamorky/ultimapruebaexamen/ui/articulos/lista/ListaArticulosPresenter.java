package com.example.mamorky.ultimapruebaexamen.ui.articulos.lista;

import com.example.mamorky.ultimapruebaexamen.adapter.ArticuloAdapter;
import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;

import java.util.Comparator;

/**
 * Created by mamorky on 13/12/17.
 */

public interface ListaArticulosPresenter extends ListaArticulosInteractor.onLoadSuccess{
    void loadArticulos();
    void deleteArticulo(Articulo articulo);
    void orderArticulos(Comparator<Articulo> comparator, ArticuloAdapter adapter);
}
