package com.example.shoplist;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Item> items = new ArrayList<>();
    private static Storage storage = null;

    public Storage(){

    }

    public static Storage getInstance(){
        if (storage == null){
            storage = new Storage();
        }
        return storage;
    }

    public void addItem(Item item){
        items.add(item);
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public void deleteItem(String name){
        int i = 0;

        for (Item item : items){
            if (item.getName().equals(name)) {
                break;
            }
        i++;
        }
        items.remove(i);
    }


  public Item getItem (int i){
        return items.get(i);
  }


}
