package com.example.mamorky.ultimapruebaexamen.ui.articulos.lista;

import com.example.mamorky.ultimapruebaexamen.adapter.ArticuloAdapter;
import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by mamorky on 13/12/17.
 */

public class ListaArticulosPresenterImp implements ListaArticulosPresenter{
    ListaArticulosView view;
    ListaArticulosInteractor interactor;

    public ListaArticulosPresenterImp(ListaArticulosView view){
        this.view = view;
        this.interactor = new ListaArticulosInteractorImp(this);
    }

    @Override
    public void onLoadSuccess(ArrayList<Articulo> articulos) {
        view.onLoadSuccess(articulos);
    }

    @Override
    public void loadArticulos() {
        interactor.loadArticulos(this);
    }

    @Override
    public void deleteArticulo(Articulo articulo) {
        interactor.deleteArticulo(articulo);
        loadArticulos();
    }

    @Override
    public void orderArticulos(Comparator<Articulo> comparator, ArticuloAdapter adapter) {
        adapter.sort(comparator);
    }
}
