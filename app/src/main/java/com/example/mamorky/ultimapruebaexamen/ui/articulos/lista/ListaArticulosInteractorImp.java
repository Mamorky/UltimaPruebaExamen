package com.example.mamorky.ultimapruebaexamen.ui.articulos.lista;

import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;
import com.example.mamorky.ultimapruebaexamen.data.repository.ArticuloRepository;

import java.util.ArrayList;

/**
 * Created by mamorky on 13/12/17.
 */

public class ListaArticulosInteractorImp implements ListaArticulosInteractor{
    ListaArticulosPresenter presenter;

    public ListaArticulosInteractorImp(ListaArticulosPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadArticulos(onLoadSuccess onLoadSuccess) {
        ArrayList<Articulo> articulos = ArticuloRepository.getInstance().getArticulos();
        onLoadSuccess.onLoadSuccess(articulos);
    }

    @Override
    public void deleteArticulo(Articulo articulo) {
        ArticuloRepository.getInstance().deleteArticulo(articulo);
    }
}
