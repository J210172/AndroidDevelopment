package com.example.recicleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyHolder> {
    private List<Encapsulador> entradas;

    public Adaptador(List<Encapsulador> entradas) {
        this.entradas = entradas;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        MyHolder mvh = new MyHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.imagen.setImageResource(entradas.get(position).getIdImagen());
        holder.titulo.setText(entradas.get(position).getTextoTitulo());
        holder.texto.setText(entradas.get(position).getTextoContenido());
    }

    @Override
    public int getItemCount() {
        return entradas.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView titulo;
        public TextView texto;

        public MyHolder (View vista){
            super(vista);
            imagen = (ImageView) vista.findViewById(R.id.imgV1);
            titulo = (TextView) vista.findViewById(R.id.texV1);
            texto = (TextView) vista.findViewById(R.id.texV2);
        }
    }

}
