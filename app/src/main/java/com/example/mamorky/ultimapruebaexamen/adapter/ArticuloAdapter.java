package com.example.mamorky.ultimapruebaexamen.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mamorky.ultimapruebaexamen.R;
import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;

import java.util.ArrayList;

/**
 * Created by mamorky on 13/12/17.
 */

public class ArticuloAdapter extends ArrayAdapter<Articulo> {

    public ArticuloAdapter(@NonNull Context context) {
        super(context, R.layout.item_articulo,new ArrayList<Articulo>());
    }

    public class HolderArticulo{
        TextView txvNombre;
        TextView txvPrecio;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View viewRoot = convertView;
        HolderArticulo holderArticulo;

        if(viewRoot == null){
            viewRoot = View.inflate(getContext(),R.layout.item_articulo,null);
            holderArticulo = new HolderArticulo();

            holderArticulo.txvNombre = viewRoot.findViewById(R.id.txvNombreArticulo);
            holderArticulo.txvPrecio = viewRoot.findViewById(R.id.txvPrecioArticulo);

            viewRoot.setTag(holderArticulo);
        }
        else
            holderArticulo = (HolderArticulo) viewRoot.getTag();

        holderArticulo.txvNombre.setText(getItem(position).getNombre());
        holderArticulo.txvPrecio.setText(getItem(position).getCoste()+" €");

        return viewRoot;
    }
}
