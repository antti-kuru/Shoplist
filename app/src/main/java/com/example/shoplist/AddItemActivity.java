package com.example.shoplist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    private EditText itemName;
    private EditText itemNotes;

    private Button button;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        itemName = findViewById(R.id.editItemName);
        itemNotes = findViewById(R.id.editItemAdditionalNotes);
        button = findViewById(R.id.btnSaveItem);
        context = this;
    }

    public void addItem(View view){
        // With the Storage.getInstance().getItems().size() (int) we give every item a number countdown starting from 0
        // so first item has 0, second 1 and so on. We can compare the creation times with this
        // I tried to use LocalDateTime to use actual time but I got error code "Call requires API level 26 (current min is 24): java.time.LocalDateTime#now"
        Item item = new Item(itemName.getText().toString(), itemNotes.getText().toString(), Storage.getInstance().getItems().size());
        Storage.getInstance().addItem(item);


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }



}