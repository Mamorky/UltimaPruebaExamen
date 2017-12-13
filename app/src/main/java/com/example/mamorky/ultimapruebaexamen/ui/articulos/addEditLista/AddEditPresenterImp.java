package com.example.mamorky.ultimapruebaexamen.ui.articulos.addEditLista;

/**
 * Created by mamorky on 13/12/17.
 */

public class AddEditPresenterImp  implements AddEditPresenter,AddEditInteractor.onValidateArticulo{
    AddEditView view;
    AddEditInteractor interactor;

    public AddEditPresenterImp(AddEditView view){
        this.view = view;
        this.interactor = new AddEditInteractorImp(this);
    }

    @Override
    public void onNameEmpty() {
        view.onSetNameEmpty();
    }

    @Override
    public void onPriceEmpty() {
        view.onSetNumberEmpty();
    }

    @Override
    public void onPriceConvertFailed() {
        view.onSetConvertFailed();
    }

    @Override
    public void onSucess() {
        view.onSuccess();
    }

    @Override
    public void addArticulo(String nombre, String precio) {
        interactor.addArticulo(nombre,precio,this);
    }

    @Override
    public void editArticulo(int id, String precio) {
        interactor.editArticulo(id,precio,this);
    }
}
