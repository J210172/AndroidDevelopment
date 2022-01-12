package com.example.p1recurdar.rRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.p1recurdar.R;

import java.io.File;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {
    private List<File> items;

    public Adapter(List<File> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model1, parent, false);
        MyHolder mvh = new MyHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.fileName.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        protected TextView fileName;

        public MyHolder(View view) {
            super(view);
            fileName = view.findViewById(R.id.file_name);
        }

    }
}
