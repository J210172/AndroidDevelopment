package com.example.p1recurdar.iRecycler;

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
    private List<Item> items;

    public Adapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model2, parent, false);
        MyHolder mvh = new MyHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.itemTitle.setText(items.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;
        protected TextView itemDesc;

        public MyHolder(View view) {
            super(view);
            itemTitle = view.findViewById(R.id.item_title);
            itemDesc = view.findViewById(R.id.item_short_desc);
        }

    }
}
