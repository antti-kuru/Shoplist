package com.example.shoplist;

import android.os.Build;

import java.time.LocalDateTime;
import java.util.Comparator;


public class Item {
    private String name;
    private String extraNotes;

    private int creationOrderNumber;

     // private LocalDateTime creationTime;


    public Item(String name, String extraNotes, int creationOrderNumber){
        this.name = name;
        this.extraNotes = extraNotes;
        this.creationOrderNumber = creationOrderNumber;

        // I would have like to use this real datetime unit
        //this.creationTime = LocalDateTime.now();
        }


    public static final Comparator<Item> sortbyname = new Comparator<Item>() {
        @Override
        public int compare(Item item, Item t1) {
            return item.name.compareTo(t1.name);
        }
    };

    public static final Comparator<Item> sortbydate = new Comparator<Item>() {
        @Override
        public int compare(Item item, Item t1) {
            return item.creationOrderNumber - (t1.creationOrderNumber);
        }
    };

    public String getName(){
        return name;
    }

    public String getExtraNotes(){
        return extraNotes;
    }

    public void setExtraNotes(String newNotes){
        extraNotes = newNotes;
    }

    public void setName(String newName){
        name = newName;
    }






}
