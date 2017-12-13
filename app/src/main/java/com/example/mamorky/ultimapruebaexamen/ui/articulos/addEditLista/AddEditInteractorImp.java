package com.example.mamorky.ultimapruebaexamen.ui.articulos.addEditLista;

import android.nfc.FormatException;

import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;
import com.example.mamorky.ultimapruebaexamen.data.repository.ArticuloRepository;
import com.example.mamorky.ultimapruebaexamen.util.AddEdit;

/**
 * Created by mamorky on 13/12/17.
 */

public class AddEditInteractorImp implements AddEditInteractor{

    private AddEditPresenter presenter;

    public AddEditInteractorImp(AddEditPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addArticulo(String nombre, String precio,onValidateArticulo onValidateArticulo) {

        if(!comprobaciones(nombre,precio,onValidateArticulo))
            return;

        try{
            int precioArticulo = Integer.valueOf(precio);
            int ultimoId = ArticuloRepository.getInstance().getArticulos().get(ArticuloRepository.getInstance().getArticulos().size()-1).getId()+1;
            ArticuloRepository.getInstance().addArticulo(new Articulo(ultimoId,nombre,precioArticulo));
            onValidateArticulo.onSucess();
        }catch (Exception e){
            onValidateArticulo.onPriceConvertFailed();
        }
    }

    @Override
    public void editArticulo(int id,String precio, onValidateArticulo onValidateArticulo) {

        if(precio.isEmpty()){
            onValidateArticulo.onPriceEmpty();
            return;
        }

        try{
            int precioArticulo = Integer.valueOf(precio);
            int ultimoId = ArticuloRepository.getInstance().getArticulos().get(ArticuloRepository.getInstance().getArticulos().size()-1).getId()+1;
            ArticuloRepository.getInstance().editArticulo(id,precioArticulo);
            onValidateArticulo.onSucess();
        }catch (Exception e){
            onValidateArticulo.onPriceConvertFailed();
        }
    }

    public boolean comprobaciones(String nombre,String precio,onValidateArticulo onValidateArticulo){
        if(nombre.isEmpty()){
            onValidateArticulo.onNameEmpty();
            return false;
        }

        if(precio.isEmpty()){
            onValidateArticulo.onPriceEmpty();
            return false;
        }

        return true;
    }
}
