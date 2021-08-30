package com.company.inventory;

import com.company.objects.items.Items;


import java.util.ArrayList;

public class Inventory {
    private ArrayList<Items> inventory = new ArrayList();
    private ArrayList<Integer> itemsCountInInventory = new ArrayList();
    private String owner;

    public ArrayList<Items> getInventory() {
        return this.inventory;
    }

    public Inventory(String owner) {
        this.owner = owner;
    }

    public void add_item(Items item, int count) {
        if (this.inventory.contains(item)) {
            int index = this.inventory.indexOf(item);
            this.itemsCountInInventory.set(index, (Integer)this.itemsCountInInventory.get(index) + count);
            System.out.println("Предмет " + item.getTitle() + " увеличил количество");
        } else {
            this.inventory.add(item);
            this.itemsCountInInventory.add(count);
            System.out.println("Предмет " + item.getTitle() + " добавлен в инвентарь " + this.owner);
        }

    }

    public boolean check(Items item) {
        if (this.inventory.contains(item)) {
            return (Integer)this.itemsCountInInventory.get(this.inventory.indexOf(item)) > 1;
        } else {
            return false;
        }
    }

    public void remove(Items item, int count) {
        if ((Integer)this.itemsCountInInventory.get(this.inventory.indexOf(item)) - count >= 1) {
            this.itemsCountInInventory.set(this.inventory.indexOf(item), (Integer)this.itemsCountInInventory.get(this.inventory.indexOf(item)) - count);
        } else {
            this.itemsCountInInventory.remove(this.inventory.indexOf(item));
            this.inventory.remove(item);
        }

    }

    public int getIndex(Items item) {
        return this.inventory.indexOf(item);
    }

    public Items get(int index) {
        return (Items)this.inventory.get(index);
    }

    public String toString() {
        String result = " Инветарь " + this.owner;
        if (this.inventory.size() > 0) {
            result = result + " содержит: \n";
            int length = result.length();

            for(int index = 0; index < this.inventory.size(); ++index) {
                if ((Integer)this.itemsCountInInventory.get(index) - 1 > 0) {
                    result = result + (index + 1) + ":" + this.inventory.get(index) + " x" + ((Integer)this.itemsCountInInventory.get(index) - 1) + "\n";
                }
            }

            if (result.length() == length) {
                result = "Инвентарь " + this.owner + " пуст.";
            }

            return result;
        } else {
            return result + " пуст";
        }
    }

    public void flush() {
        this.inventory.clear();
        this.itemsCountInInventory.clear();
    }
}
