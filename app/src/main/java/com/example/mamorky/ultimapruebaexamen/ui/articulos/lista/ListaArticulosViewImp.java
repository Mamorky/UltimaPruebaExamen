package com.example.mamorky.ultimapruebaexamen.ui.articulos.lista;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mamorky.ultimapruebaexamen.GeneralPreferences;
import com.example.mamorky.ultimapruebaexamen.R;
import com.example.mamorky.ultimapruebaexamen.adapter.ArticuloAdapter;
import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;
import com.example.mamorky.ultimapruebaexamen.ui.articulos.addEditLista.AddEditView;
import com.example.mamorky.ultimapruebaexamen.ui.articulos.addEditLista.AddEditViewImp;
import com.example.mamorky.ultimapruebaexamen.util.AddEdit;
import com.example.mamorky.ultimapruebaexamen.util.Comparators;

import java.util.ArrayList;
import java.util.Comparator;

public class ListaArticulosViewImp extends AppCompatActivity implements ListaArticulosView{

    private ListaArticulosPresenter presenter;

    private ListView listaArticulos;
    private ArticuloAdapter adapter;

    private FloatingActionButton fabAdd;

    private Comparator<Articulo> articuloComparator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_articulos);

        presenter = new ListaArticulosPresenterImp(this);

        listaArticulos = findViewById(R.id.listaArticulos);
        fabAdd = findViewById(R.id.fabAdd);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddEditViewImp.class);
                intent.putExtra(AddEdit.TAG_ADDEDIT,AddEdit.ADD);

                startActivity(intent);
            }
        });

        adapter = new ArticuloAdapter(this);
        listaArticulos.setAdapter(adapter);

        listaArticulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Articulo articuloEdt = (Articulo) parent.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(),AddEditViewImp.class);
                intent.putExtra(Articulo.class.toString(),articuloEdt);
                intent.putExtra(AddEdit.TAG_ADDEDIT,AddEdit.EDIT);

                startActivity(intent);
            }
        });

        registerForContextMenu(listaArticulos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadArticulos();
        presenter.orderArticulos(articuloComparator,adapter);
        mostrarOcultarLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_order_articulos,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_orderByNombre:
                articuloComparator = null;
                presenter.orderArticulos(articuloComparator,adapter);
                break;
            case R.id.action_orderById:
                articuloComparator = new Comparators.CompareById();
                presenter.orderArticulos(articuloComparator,adapter);
                break;
            case R.id.action_orderByCoste:
                articuloComparator = new Comparators.CompareByCoste();
                presenter.orderArticulos(articuloComparator,adapter);
                break;
            case R.id.action_prefernces:
                Intent intent = new Intent(getApplicationContext(), GeneralPreferences.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opciones del Articulo");
        getMenuInflater().inflate(R.menu.menu_context_articulo,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Articulo articulo = (Articulo) listaArticulos.getItemAtPosition(menuInfo.position);
                presenter.deleteArticulo(articulo);
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onLoadSuccess(ArrayList<Articulo> articulos) {
        adapter.clear();
        adapter.addAll(articulos);
    }

    private void mostrarOcultarLista(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Boolean listaVisible = sharedPreferences.getBoolean(getString(R.string.key_mostrar_lista_articulo),true);

        if(listaVisible)
            listaArticulos.setVisibility(View.VISIBLE);
        else
            listaArticulos.setVisibility(View.INVISIBLE);
    }
}
