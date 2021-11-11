package com.example.ejercicio8_sqlite;

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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        MyHolder mvh = new MyHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvGroup.setText(entradas.get(position).getGroup());
        holder.tvDisk.setText(entradas.get(position).getDisk());
    }

    @Override
    public int getItemCount() {
        return entradas.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tvGroup;
        public TextView tvDisk;

        public MyHolder (View vista){
            super(vista);
            imageView = vista.findViewById(R.id.image);
            tvGroup = (TextView) vista.findViewById(R.id.group);
            tvDisk = (TextView) vista.findViewById(R.id.disk);
        }
    }

}
