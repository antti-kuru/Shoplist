package com.example.shoplist;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    ImageView editItem;

    ImageView sortByCalendar;
    ImageView sortByAlphabets;
    ImageView deleteItem;

    TextView itemName, itemNotes;
    EditText editName, editNotes;

    public ItemViewHolder(@NonNull View itemView){
        super(itemView);
        editItem = itemView.findViewById(R.id.imgEdit);
        deleteItem = itemView.findViewById(R.id.imgDelete);
        itemName = itemView.findViewById(R.id.txtItemName);
        itemNotes = itemView.findViewById(R.id.txtItemNotes);
        editName = itemView.findViewById(R.id.refactorName);
        editNotes = itemView.findViewById(R.id.refactorNotes);
        sortByCalendar = itemView.findViewById(R.id.imgCalendar);
        sortByAlphabets = itemView.findViewById(R.id.imgAlphabets);

    }


}
