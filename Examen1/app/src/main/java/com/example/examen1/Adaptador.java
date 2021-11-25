package com.example.examen1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyHolder> {
    private List<Encapsulador> items;

    public Adaptador(List<Encapsulador> items) {
        this.items = items;
    }

    public void setItems(List<Encapsulador> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyHolder mvh = new MyHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.idTV.setText(String.valueOf(items.get(position).getId()));
        holder.nameTV.setText(items.get(position).getName());
        holder.image.setImageResource(R.drawable.ima6);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        public TextView idTV;
        public TextView nameTV;
        public ImageView image;

        public MyHolder (View vista){
            super(vista);
            idTV = vista.findViewById(R.id.idTV);
            nameTV = vista.findViewById(R.id.nameTV);
            image = vista.findViewById(R.id.image);
        }
    }

}
