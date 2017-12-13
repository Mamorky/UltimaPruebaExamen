package com.example.mamorky.ultimapruebaexamen.ui.articulos.addEditLista;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mamorky.ultimapruebaexamen.R;
import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;
import com.example.mamorky.ultimapruebaexamen.util.AddEdit;

public class AddEditViewImp extends AppCompatActivity implements AddEditView{

    private AddEdit addEdit;

    private AddEditPresenter presenter;

    private EditText edtNombre,edtPrecio;
    private TextInputLayout tilNombre,tilPrecio;

    private FloatingActionButton fabSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        edtNombre = findViewById(R.id.edtNombre);
        edtPrecio = findViewById(R.id.edtPrecio);
        tilNombre = findViewById(R.id.tilNombre);
        tilPrecio = findViewById(R.id.tilPrecio);
        fabSave = findViewById(R.id.fabSave);

        addEdit = new AddEdit();

        presenter = new AddEditPresenterImp(this);
        addEdit.modo = getIntent().getExtras().getInt(AddEdit.TAG_ADDEDIT);

        if(addEdit.modo == AddEdit.ADD){
            fabSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.addArticulo(edtNombre.getText().toString(),edtPrecio.getText().toString());
                }
            });
        }
        else if(addEdit.modo == AddEdit.EDIT){
            edtNombre.setEnabled(false);
            edtPrecio.requestFocus();

            final Articulo articuloEdt = (Articulo) getIntent().getExtras().getSerializable(Articulo.class.toString());
            edtNombre.setText(articuloEdt.getNombre());
            edtPrecio.setText(String.valueOf(articuloEdt.getCoste()));

            fabSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.editArticulo(articuloEdt.getId(),edtPrecio.getText().toString());
                }
            });
        }
    }

    @Override
    public void onSetConvertFailed() {
        tilPrecio.setError("El precio debe ser un entero");
        tilNombre.setError("");
        edtPrecio.requestFocus();
    }

    @Override
    public void onSetNumberEmpty() {
        tilPrecio.setError("Precio no puede ser vacio");
        tilNombre.setError("");
        edtPrecio.requestFocus();
    }

    @Override
    public void onSetNameEmpty() {
        tilNombre.setError("Nombre no puede ser vacio");
        edtNombre.requestFocus();
    }

    @Override
    public void onSuccess() {
        finish();
    }
}
