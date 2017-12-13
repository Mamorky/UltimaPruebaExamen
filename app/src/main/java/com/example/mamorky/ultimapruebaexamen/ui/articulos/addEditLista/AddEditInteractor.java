package com.example.mamorky.ultimapruebaexamen.ui.articulos.addEditLista;
/**
 * Created by mamorky on 13/12/17.
 */

public interface AddEditInteractor {
    void addArticulo(String nombre,String precio,onValidateArticulo onValidateArticulo);
    void editArticulo(int id, String precio, onValidateArticulo onValidateArticulo);

    interface onValidateArticulo{
        void onNameEmpty();
        void onPriceEmpty();
        void onPriceConvertFailed();
        void onSucess();
    }
}
