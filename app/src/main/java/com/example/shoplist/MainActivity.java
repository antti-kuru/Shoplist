package com.example.shoplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvItemList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), storage.getItems()));
    }



    public void switchToAddItem(View view){
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }


    public void sortByName(View view){
        List<Item> sortedList = Storage.getInstance().getItems();
        Collections.sort(sortedList, Item.sortbyname);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), storage.getItems()));

    }

    public void sortByDateTime(View view){
        List<Item> sortedList = Storage.getInstance().getItems();
        Collections.sort(sortedList, Item.sortbydate);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), storage.getItems()));
    }









}