package com.example.shoplist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;

    private ArrayList<Item> items = new ArrayList<>();


    public ItemListAdapter(Context context, ArrayList<Item> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position){
        holder.itemName.setText(items.get(position).getName());
        holder.itemNotes.setText(items.get(position).getExtraNotes());
        holder.editName.setText(items.get(position).getName());
        holder.editNotes.setText(items.get(position).getExtraNotes());
        holder.deleteItem.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            Storage.getInstance().deleteItem(items.get(pos).getName());
            notifyItemRemoved(pos);
        });


        holder.editItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                 if (holder.editName.getVisibility() == View.VISIBLE) {
                    Item item = Storage.getInstance().getItem(pos);
                    item.setName(holder.editName.getText().toString());
                    item.setExtraNotes(holder.editNotes.getText().toString());
                    holder.editName.setVisibility(View.GONE);
                    holder.editNotes.setVisibility(View.GONE);

                    notifyDataSetChanged();
                }
                else {
                    holder.editName.setVisibility(View.VISIBLE);
                    holder.editNotes.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return items.size();
    }

}
